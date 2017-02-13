package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Robot;
import org.usfirst.frc.team1764.robot.subsystems.GearIntake.Position;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleGearIntake extends Command {
	boolean done = false;
	
    public ToggleGearIntake() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!done) {
    		Robot.gearIntake.set(Robot.gearIntake.get()==Position.UP ? Position.DOWN : Position.UP);
    		done = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
