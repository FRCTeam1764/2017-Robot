package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithRampingJoystick extends Command {
	double leftSpeed, rightSpeed;
	double lastLeftSpeed, lastRightSpeed;
	double lastTime, currentTime;
	double deltaLeftSpeed,deltaRightSpeed,deltaTime,kpl,kpr;
    public DriveWithRampingJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    	this.lastLeftSpeed = 0;
    	this.lastRightSpeed = 0;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.lastTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	leftSpeed = Robot.oi.getDriveY() + Robot.oi.getDriveZ();
    	rightSpeed = Robot.oi.getDriveY() - Robot.oi.getDriveZ();
    	deltaLeftSpeed = leftSpeed - lastLeftSpeed;
    	deltaRightSpeed = rightSpeed - lastRightSpeed;
    	currentTime = System.currentTimeMillis();
    	deltaTime = currentTime - lastTime;
    	
    	kpl = deltaLeftSpeed/deltaTime;
    	kpr = deltaRightSpeed/deltaTime;
    	
    	Robot.chassis.setSpeedBoth(kpl*leftSpeed, kpr*rightSpeed);
    	
    	lastTime = currentTime;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.setSpeedBoth(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.chassis.setSpeedBoth(0, 0);
    }
}
