package org.usfirst.frc.team1764.robot;

public class Constants {
	//				Control Scheme			\\\
	
	//These are the controller axes for each drive axis.
	public static int XBOX_DRIVE_X_AXIS = 2;
	public static int XBOX_DRIVE_X_NEG_AXIS = 3;
	public static int XBOX_DRIVE_Z_AXIS = 0;
	
	//Should the pilot control everything?
	public static boolean COPILOT_ENABLED = false;
	
	//Button id for shift up and shift down buttons
	public static int PILOT_SHIFT_UP_BUTTON = 6;
	public static int PILOT_SHIFT_DOWN_BUTTON = 5;
	
	//These are the bindings used when copilot is enabled
	//They will be on the second(copilot's) joystick.
	public static int COPILOT_FUELINTAKE_BUTTON = 3;
	public static int COPILOT_FLYWHEEL_BUTTON = 2;
	public static int COPILOT_GEARINTAKE_TOGGLE_BUTTON = 1;
	
	//These are the bindings used when copilot is not enabled
	//They will be on the first(pilot's) joystick.
	public static int PILOT_FUELINTAKE_BUTTON = 1;
	public static int PILOT_GEARINTAKE_TOGGLE_BUTTON = 2;
	public static int PILOT_FLYWHEEL_BUTTON = 3;
	
	//Speed setting for fuel intake
	public static double FUELINTAKE_SPEED_BOTH = 1.0;
	
	//Speed for flywheel
	public static double FLYWHEEL_SPEED = 0.85;
}
