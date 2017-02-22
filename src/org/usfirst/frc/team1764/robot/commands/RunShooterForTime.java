package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Constants;
import org.usfirst.frc.team1764.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class RunShooterForTime extends TimedCommand {

    public RunShooterForTime(double timeout) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.set(Constants.FLYWHEEL_SPEED);;
    }

    // Called once after timeout
    protected void end() {
    	Robot.shooter.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.set(0);
    }
}
