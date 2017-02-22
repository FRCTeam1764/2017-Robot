package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShooterGroup extends CommandGroup {

    public ShooterGroup() {
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
    	if (!Constants.USE_PID_INTAKE_DELAY) { //only need to warmup if time-delay, pid will wait for shooter to be at good speed before feeding.
    		addSequential(new RunShooterForTime(Constants.INTAKE_WARMUP)); //First, run the shooter for Constants.INTAKE_WARMUP
    	}
    	addParallel(new RunFeeder()); //Secondly, run both the shooter and the feeder
    	addParallel(new RunShooter());
    }
}
