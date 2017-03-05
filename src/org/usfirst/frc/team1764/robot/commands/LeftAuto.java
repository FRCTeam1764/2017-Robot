package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftAuto extends CommandGroup {

    public LeftAuto() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	//addSequential(new AllignCamera(0.0, 0.4));
    	addSequential(new ResetGyro());
    	addSequential(new DriveStraight(0.5, 2.25));
    	addSequential(new DriveWithGyro(-60, 5));
    	addSequential(new DriveStraight(0.0, 2));
    	addSequential(new DriveWithGyro(-60, 5));
    	addSequential(new DriveStraight(0.5, 2));
    	addSequential(new MoveGearIntake(true));
    	addSequential(new DriveStraight(0, 1));
    	addSequential(new DriveStraight(-0.5, 1));
    	addSequential(new MoveGearIntake(false));
    }
}
