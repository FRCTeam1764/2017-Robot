package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class StartCompressor extends InstantCommand {

    public StartCompressor() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.pneumaticsCompressor);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.pneumaticsCompressor.start();
    }

}
