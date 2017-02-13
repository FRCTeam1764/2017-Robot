package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FuelIntake extends Subsystem {

    Spark belt, noodle;
    
    public FuelIntake() {
    	belt = new Spark(RobotMap.PORT_BALLINTAKE_BELT);
    	noodle = new Spark(RobotMap.PORT_BALLINTAKE_NOODLE);
    }

    public void initDefaultCommand() {
    }
    
    public void setBelt(double speed) {
    	belt.setSpeed(speed);
    }
    
    public void setNoodle(double speed) {
    	noodle.setSpeed(speed);
    }
    
    public void setBoth(double speed) {
    	belt.setSpeed(speed);
    	noodle.setSpeed(speed);
    }
}

