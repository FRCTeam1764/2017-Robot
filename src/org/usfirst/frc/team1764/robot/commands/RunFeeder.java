package org.usfirst.frc.team1764.robot.commands;
 
import org.usfirst.frc.team1764.robot.Constants;
import org.usfirst.frc.team1764.robot.Robot;
 
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
 
 
/**
 *
 */
public class RunFeeder extends Command {
    Timer timer;
   
    public RunFeeder() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.feeder);
        this.timer = new Timer();
    }
 
    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Constants.USE_PID_INTAKE_DELAY) {
    		if (Robot.shooter.isReadyForFood) {
    			Robot.feeder.set(Constants.INTAKE_SPEED);
    		} else {
    			Robot.feeder.set(0);
    		}
    	} else {
	        if (Math.floor(timer.get()*Constants.TIMED_BASED_INTAKE_DELAY) % 2 == 0) { //runs in intervals of 1/the constant value
	            Robot.feeder.set(0);
	        }
	        else {
	            Robot.feeder.set(Constants.INTAKE_SPEED);
	        }
    	}
    }
 
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
 
    // Called once after isFinished returns true
    protected void end() {
        Robot.feeder.set(0);
    }
 
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.feeder.set(0);
    }
}