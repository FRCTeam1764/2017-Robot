package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class MoveGearIntake extends InstantCommand {
	boolean state;

    public MoveGearIntake(boolean state) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearIntake);
    	this.state = state;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearIntake.set(state);
    }
}
