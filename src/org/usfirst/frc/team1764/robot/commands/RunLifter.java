package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Constants;
import org.usfirst.frc.team1764.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunLifter extends Command {

	private boolean direction;
	
    public RunLifter(boolean direction) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lifter);
    	this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.lifter.set(Constants.LIFTER_SPEED * (direction ? 1:-1));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lifter.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.lifter.set(0);
    }
}
