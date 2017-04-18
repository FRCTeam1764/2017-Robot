package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AlignWithCamera extends Command {

	boolean moving = false;
	double error = 0;
	double targetAngle = 0;
	final static double SPEED = 0.2;
	int dir = 1;
	final double tolerance;
	
    public AlignWithCamera(double tolerance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    	//requires(Robot.camTrack);
    	
    	this.tolerance = tolerance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	/*Robot.gyro.reset();
    	Robot.camTrack.update();
    	Robot.chassis.enable();
    	targetAngle = Robot.camTrack.getAngle();
    	Robot.chassis.setSetpoint(targetAngle);*/
//    	if(!moving && Robot.camTrack.update()) {
//    		moving = true;
//    		targetAngle = Robot.camTrack.getAngle();
//    		//Robot.gyro.reset();
//    	} else if(moving) {
//    		error = targetAngle - Robot.gyro.getAngle();
//    		
//    		dir = (int)(error / Math.abs(error));
//    		if(Math.abs(error) < tolerance) {
//    			Robot.chassis.disable();
//    			moving = false;
//    		} else {
//    			Robot.chassis.setLeft(SPEED*dir);
//    			Robot.chassis.setRight(SPEED*dir);
//    		}
//    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.chassis.disable();
    }
}
