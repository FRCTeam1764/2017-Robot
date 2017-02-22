package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Constants;
import org.usfirst.frc.team1764.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunShooter extends Command {
	
    public RunShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.set(Constants.FLYWHEEL_SPEED);
    	Robot.shooter.DEBUGREMOVE();
    	if (Robot.shooter.returnPIDInput() > 99999 && Robot.shooter.returnPIDInput() < 999999) {
			Robot.shooter.isReadyForFood = true;
		} else {
			Robot.shooter.isReadyForFood = false;
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.set(0);
    }
}
