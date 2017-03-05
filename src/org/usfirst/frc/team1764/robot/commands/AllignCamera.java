package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Robot;
import org.usfirst.frc.team1764.robot.Tracking;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AllignCamera extends Command {
	double offset;
	double threshold;

    public AllignCamera(double offset, double threshold) {
    	this.offset = offset;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		double center = Tracking.getCenter() + offset;
		double rotation = 0;
		if (center < -threshold)
				rotation = -0.15;
		if (center > threshold)
			   rotation = 0.15;
		   if (center > -threshold && center < threshold)
			   rotation = center / threshold * 0.15;
    	        	
    	Robot.chassis.setSpeedBoth(rotation, -rotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double center = Tracking.getCenter();
    	return center < threshold && center > -threshold;
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
