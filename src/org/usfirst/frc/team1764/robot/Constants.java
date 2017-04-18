package org.usfirst.frc.team1764.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;


public class Constants {
	//				Control Scheme			\\\
	
	//These are the controller axes for each drive axis.
	 
	/*
	 * IMPORTANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * THIS MUST BE TRUE IF YOU ARE USING THE COMPETITION ROBOT OR CERTAIN PARTS MAY NOT WORK!
	 */
	public static boolean ROBOT_IS_COMPETITION_ROBOT = true; 
	
	public static int XBOX_DRIVE_TURNING = 0;
	public static int XBOX_DRIVE_FWD = 3;
	public static int XBOX_DRIVE_BACK = 2;
		
	//Should the pilot control everything?
	public static boolean COPILOT_ENABLED = false;
	
	public static boolean LIFTER_ISINVERTED = true;
	
	//Button id for shift up and shift down buttons
	public static int PILOT_SHIFT_UP_BUTTON = 5;
	public static int PILOT_SHIFT_DOWN_BUTTON = 6;
	
	public static int PILOT_XBOX_SHIFT_UP_BUTTON = 5; //LB
	public static int PILOT_XBOX_SHIFT_DOWN_BUTTON = 6; //RB
	
	//These are the bindings used when copilot is enabled
	//They will be on the second(copilot's) joystick.
	public static int COPILOT_FUELINTAKE_BUTTON = 3;
	public static int COPILOT_FLYWHEEL_BUTTON = 1;
	public static int COPILOT_GEARINTAKE_TOGGLE_BUTTON = 2;
	public static int COPILOT_FEEDER_BUTTON = 9;
	public static int COPILOT_LIFTER_BUTTON = 9;
	
	//These are the bindings used when copilot is not enabled
	//They will be on the first(pilot's) joystick.
	public static int PILOT_FUELINTAKE_BUTTON = 3;
	public static int PILOT_FLYWHEEL_BUTTON = 1;
	public static int PILOT_GEARINTAKE_TOGGLE_BUTTON = 2;//idk
	public static int PILOT_FEEDER_BUTTON = 999999;
	public static int PILOT_LIFTER_BUTTON = 7;
	public static int PILOT_CLIMBER_BUTTON = 6;
	
	public static int PILOT_XBOX_FUELINTAKE_BUTTON = 3;//X
	public static int PILOT_XBOX_GEARINTAKE_TOGGLE_BUTTON = 2;//B
	public static int PILOT_XBOX_FLYWHEEL_BUTTON = 8; //A
	public static int PILOT_XBOX_FEEDER_BUTTON = 1; //A
	public static int PILOT_XBOX_LIFTER_BUTTON = 999; //Y
	public static int PILOT_XBOX_ALIGN_BUTTON = 10; //right stick press
	public static int PILOT_XBOX_BACKDRIVELIFTER_BUTTON = 7;
	
	//Speed setting for fuel intake
	public static double FUELINTAKE_SPEED_BOTH = 1.0;
	
	
	//Speed for flywheel
	public static double FLYWHEEL_SPEED = -1; //the maximum speed is 1.0...
	public static double INTAKE_SPEED =  0.65;
	
	//Time for the flywheel-feeding system delay (the time it warms up the flywheel for)
	public static double INTAKE_WARMUP = 1.5;
	
	//Lifter
	public static double LIFTER_SPEED = 1.0;
	
	public static boolean USE_PID_INTAKE_DELAY = false; //true: use more accurate delays for feeding that wait for the flywheel to be at a precise speed - false: use timed measurements
	
	public static double TIMED_BASED_INTAKE_DELAY = 1; // 1/x seconds, ex. if it is 2 it will run for 1/2 second, stop, then repeat
	
	
	public static boolean USE_GYRO = false;
}
