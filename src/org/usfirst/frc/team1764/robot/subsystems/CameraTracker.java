package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class CameraTracker extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	boolean isUpToDate = false;
	double angle = 0;
	
	public CameraTracker() {
		//Robot.table = NetworkTable.getTable("camera");
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean update() {
//    	if(isUpToDate) {
//    		isUpToDate = false;
//    		setFlag(true);
//    	}
//    	
//    	if(!getFlag()) {
//    		angle = Robot.table.getNumber("targetAngle", 0);
//    		isUpToDate = true;
//    		return true;
//    	}
//    	
//    	return false;
    	angle = Robot.table.getNumber("targetAngle", 0);
    	setFlag(true);
    	return true;
    }
    
    public boolean getIsUpToDate() {
    	return isUpToDate;
    }
    
    public double getAngle() {
    	return angle;
    }
    
    private boolean getFlag() {
    	return Robot.table.getBoolean("getTargetAngle", true);
    }
    
    private void setFlag(boolean flag) {
    	Robot.table.putBoolean("getTargetAngle", flag);
    }
}

