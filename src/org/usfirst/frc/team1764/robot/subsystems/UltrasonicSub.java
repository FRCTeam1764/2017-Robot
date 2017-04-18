package org.usfirst.frc.team1764.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1764.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Ultrasonic;

/**
 *
 */
public class UltrasonicSub extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	PWM pwm;
	AnalogInput input;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public UltrasonicSub()
    {
    	pwm = new PWM(RobotMap.PORT_ULTRASONIC);
    	input = new AnalogInput(0);
    }
    public double getDistance() {
    	return input.getVoltage()/0.977;
 //   	return pwm.getPosition();
    }
}

