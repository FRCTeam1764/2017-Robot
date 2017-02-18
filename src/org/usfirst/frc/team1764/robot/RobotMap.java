package org.usfirst.frc.team1764.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int PORT_LIFTER = 4;

	public static int PORT_SHOOTER_FLYWHEEL = 2;
	
	//				CHASSIS						\\
	public static int PORT_CHASSIS_LEFT_FRONT = 0;
	public static int PORT_CHASSIS_LEFT_BACK = 1;
	public static int PORT_CHASSIS_RIGHT_FRONT = 2;
	public static int PORT_CHASSIS_RIGHT_BACK = 3;
	public static int PORT_CHASSIS_SHIFTER_SOLE_ONE = 0;
	public static int PORT_CHASSIS_SHIFTER_SOLE_TWO = 1;
	
	//				GEAR INTAKE					\\
	public static int PORT_GEARINTAKE_SOLE_ONE = 6;
	public static int PORT_GEARINTAKE_SOLE_TWO = 7;
	
	public static int PORT_FEEDER_WHEEL = 3;
	
	//				BALL INTAKE					\\
	public static int PORT_BALLINTAKE_NOODLE = 1;
	public static int PORT_BALLINTAKE_BELT = 0;
	
	//				CLIMBING   					\\
	public static int PORT_CLIMBER_MOTOR = 4;
}
