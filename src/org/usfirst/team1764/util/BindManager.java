package org.usfirst.team1764.util;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.function.Function;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class BindManager {
	public enum ButtonFunctionType {
		WHILE_ACTIVE,
		WHILE_INACTIVE,
		WHEN_ACTIVE,
		WHEN_INACTIVE,
		TOGGLE_WHEN_ACTIVE,
	};
	
	private static HashMap<String, BoundJoystick> namedJoysticks = new HashMap<>();
	
	public static void addJoystick(String name, int port) {
		namedJoysticks.put(name, new BoundJoystick(port));
	}
	
	static class BoundJoystick {
		Joystick joystick;
		
		public BoundJoystick(int port) {
			this.joystick = new Joystick(port);
		}
	}
	
	private abstract class BindableCommand {
		protected boolean bound = false;
	}
	
	public abstract class SingleInputCommand extends BindableCommand {
		private Callable<Double> inputFunc;
		protected abstract void execute(double input);
		
		public void execute() {
			if(bound)
				execute(getInput());
		}
		
		private double getInput() {
			try {
				return inputFunc.call();
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
	}
	
	public abstract class DoubleInputCommand extends BindableCommand {
		private Callable<Double> inputOne;
		private Callable<Double> inputTwo;
		
		protected abstract void execute(double inputOne, double inputTwo);
		
		public void execute() {
			if(bound)
				execute(getInputOne(), getInputTwo());
		}
		
		private double getInputOne() {
			try {
				return inputOne.call();
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		private double getInputTwo() {
			try {
				return inputTwo.call();
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
	}
	
	public class RobotInputFunction {
		SingleInputCommand command;
		
		public RobotInputFunction(SingleInputCommand command) {
			this.command = command;
		}
	}
	
	public class RobotButtonFunction {
		Command command;
		ButtonFunctionType funcType;
		
		RobotButtonFunction(Command command, ButtonFunctionType funcType) {
			this.command = command;
			this.funcType = funcType;
		}
	}
}
