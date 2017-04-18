package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Robot;
import org.usfirst.frc.team1764.robot.Tracking;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightUntilDistance extends Command {
	double target, threshold;
	double speed;
	double distance;

    public DriveStraightUntilDistance(double speed, double distance) {
    	this.threshold = 10;
    	this.speed = speed;
    	this.distance = distance;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	target = Robot.chassis.getGyroAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = Robot.chassis.getGyroAngle();
  		double rotation = (angle-target) / threshold * 0.2;
    	Robot.chassis.setSpeedBoth(rotation + speed, -rotation + speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.UltrasonicSub.getDistance() < distance;
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
