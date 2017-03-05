package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Robot;
import org.usfirst.frc.team1764.robot.Tracking;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithGyro extends Command {
	double leftSpeed,rightSpeed;
	double target, threshold;

    public DriveWithGyro(double target, double threshold) {
    	this.target = target;
    	this.threshold = threshold;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = Robot.chassis.getGyroAngle();
  		double rotation = (angle-target) / threshold * 0.2;
    	Robot.chassis.setSpeedBoth(rotation, -rotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double angle = Robot.chassis.getGyroAngle();
    	return angle > target - threshold && angle < target + threshold;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.setSpeedBoth(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.chassis.setSpeedBoth(0, 0);
    }
}
