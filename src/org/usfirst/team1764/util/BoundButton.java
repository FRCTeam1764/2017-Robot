package org.usfirst.team1764.util;

import java.util.Vector;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class BoundButton {
	public enum ButtonFunctionType {
		WHILE_ACTIVE,
		WHILE_INACTIVE,
		WHEN_ACTIVE,
		WHEN_INACTIVE,
		TOGGLE_WHEN_ACTIVE,
		TOGGLE_WHEN_INACTIVE
	};
	
	private static Joystick pilot;
	private static Joystick copilot;
	private static Vector<BoundButton> buttons = new Vector<>();
	
	private JoystickButton button;
	
	public BoundButton() {
		buttons.add(this);
	}
}
