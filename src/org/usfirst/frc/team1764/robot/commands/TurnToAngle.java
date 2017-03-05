package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToAngle extends Command {
	final double angle;
	double error;
	double tolerance;
	
    public TurnToAngle(double angle, double tolerance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    	requires(Robot.gyro);
    	
    	this.tolerance = tolerance;
    	this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	error = angle - Robot.gyro.getAngle();
    	double errorPol = error / Math.abs(error);
    	
    	Robot.chassis.setSpeedLeft(0.25*errorPol);
    	Robot.chassis.setSpeedRight(0.25*errorPol);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(error) <= tolerance;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.chassis.disable();
    }
}
