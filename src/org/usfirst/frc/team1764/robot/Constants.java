package org.usfirst.frc.team1764.robot;

public class Constants {
	//				Control Scheme			\\\
	
	//These are the controller axes for each drive axis.
	
	public static int XBOX_DRIVE_TURNING = 0;
	public static int XBOX_DRIVE_FWD = 2;
	public static int XBOX_DRIVE_BACK = 3;
		
	//Should the pilot control everything?
	public static boolean COPILOT_ENABLED = true;
	
	
	//Button id for shift up and shift down buttons
	public static int PILOT_SHIFT_UP_BUTTON = 5;
	public static int PILOT_SHIFT_DOWN_BUTTON = 3;
	
	public static int PILOT_XBOX_SHIFT_UP_BUTTON = 4;
	public static int PILOT_XBOX_SHIFT_DOWN_BUTTON = 2;
	
	//These are the bindings used when copilot is enabled
	//They will be on the second(copilot's) joystick.
	public static int COPILOT_FUELINTAKE_BUTTON = 3;
	public static int COPILOT_FLYWHEEL_BUTTON = 1;
	public static int COPILOT_GEARINTAKE_TOGGLE_BUTTON = 2;
	public static int COPILOT_FEEDER_BUTTON = 4;
	public static int COPILOT_LIFTER_BUTTON = 5;
	
	//These are the bindings used when copilot is not enabled
	//They will be on the first(pilot's) joystick.
	public static int PILOT_FUELINTAKE_BUTTON = 6;
	public static int PILOT_GEARINTAKE_TOGGLE_BUTTON = 2;
	public static int PILOT_FLYWHEEL_BUTTON = 1;
	public static int PILOT_FEEDER_BUTTON = 4;
	public static int PILOT_LIFTER_BUTTON = 7;
	public static int PILOT_CLIMBER_BUTTON = 6;
	
	public static int PILOT_XBOX_FUELINTAKE_BUTTON = 3;//X
	public static int PILOT_XBOX_GEARINTAKE_TOGGLE_BUTTON = 2;
	public static int PILOT_XBOX_FLYWHEEL_BUTTON = 1; //A
	public static int PILOT_XBOX_FEEDER_BUTTON = 8; //START
	public static int PILOT_XBOX_LIFTER_BUTTON = 4; //Y
	//Speed setting for fuel intake
	public static double FUELINTAKE_SPEED_BOTH = 1.0;
	
	//Speed for flywheel
	public static double FLYWHEEL_SPEED = 0.75;
	public static double INTAKE_SPEED = 0.9;
	
	//Time for the flywheel-feeding system delay (the time it wamrs up the flywheel for)
	public static double INTAKE_WARMUP = 1;
	
}