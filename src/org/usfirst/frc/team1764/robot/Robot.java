
package org.usfirst.frc.team1764.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1764.robot.commands.AlignWithCamera;
import org.usfirst.frc.team1764.robot.commands.AutoGroup;
import org.usfirst.frc.team1764.robot.commands.DriveStraight;
import org.usfirst.frc.team1764.robot.commands.DriveWithGyro;
import org.usfirst.frc.team1764.robot.commands.ExampleCommand;
import org.usfirst.frc.team1764.robot.commands.LeftAuto;
import org.usfirst.frc.team1764.robot.commands.StraightAuto;
import org.usfirst.frc.team1764.robot.commands.RightAuto;
import org.usfirst.frc.team1764.robot.subsystems.CameraTracker;
import org.usfirst.frc.team1764.robot.subsystems.Chassis;
import org.usfirst.frc.team1764.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team1764.robot.subsystems.Feeder;
import org.usfirst.frc.team1764.robot.subsystems.FuelIntake;
import org.usfirst.frc.team1764.robot.subsystems.GearIntake;
import org.usfirst.frc.team1764.robot.subsystems.Gyro;
import org.usfirst.frc.team1764.robot.subsystems.Lifter;
import org.usfirst.frc.team1764.robot.subsystems.PneumaticsCompressor;
import org.usfirst.frc.team1764.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final PneumaticsCompressor pneumaticsCompressor = new PneumaticsCompressor();
	public static final Chassis chassis = new Chassis();
	public static final FuelIntake fuelIntake = new FuelIntake();
	public static final GearIntake gearIntake = new GearIntake();
	public static final Gyro gyro = new Gyro();
	public static final CameraTracker camTrack = new CameraTracker();
	public static final Shooter shooter = new Shooter();
	public static final Feeder feeder = new Feeder();
	public static final Lifter lifter = new Lifter();
	
	public static Tracking tracking;

	public static OI oi;
	public static NetworkTable table;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		CameraServer.getInstance().startAutomaticCapture(0);
		tracking = new Tracking();
		tracking.start();
		oi = new OI();
		
		chassis.setShifter(false);
		table = NetworkTable.getTable("cam");
		chooser.addDefault("Straight Auto", new ExampleCommand());
		chooser.addObject("Left Auto", new LeftAuto());
		chooser.addObject("Right Auto", new RightAuto());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto Mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
