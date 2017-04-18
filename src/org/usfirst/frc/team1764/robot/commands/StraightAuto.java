package org.usfirst.frc.team1764.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StraightAuto extends CommandGroup {

    public StraightAuto() {
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
//    	addSequential(new DriveStraight(0,5));

    	/*addSequential(new MoveGearIntake(true));
    	addSequential(new DriveStraightUntilDistanceWithoutGyro(0.3, 0.299));
    	addSequential(new DriveStraightWithoutGyro(0,1.25));
    	addSequential(new MoveGearIntake(false));
    	addSequential(new DriveStraightWithoutGyro(0,1.5));
    	addSequential(new DriveStraightWithoutGyro(-0.5, 2));*/
    	
    	addSequential(new ResetGyro());
    	addSequential(new MoveGearIntake(true));
    	addSequential(new DriveStraight(0.3, 4.60));
    	addSequential(new DriveStraight(0,1.25));
    	addSequential(new MoveGearIntake(false));
    	addSequential(new DriveStraight(0,1.5));
    	addSequential(new DriveStraight(-0.5, 1.25));
    }
}
