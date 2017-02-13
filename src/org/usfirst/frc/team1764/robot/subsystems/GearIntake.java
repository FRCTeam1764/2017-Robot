package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearIntake extends Subsystem {

	public static enum Position {
		UP,
		DOWN
	};
	
	private DoubleSolenoid solenoid;
	private Position position;
	
	public GearIntake() {
		solenoid = new DoubleSolenoid(RobotMap.PORT_GEARINTAKE_SOLE_ONE, RobotMap.PORT_GEARINTAKE_SOLE_TWO);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set(Position position) {
    	this.position = position;
    	switch(position) {
    	case UP:
    		solenoid.set(DoubleSolenoid.Value.kForward);
    		break;
    	case DOWN:
    		solenoid.set(DoubleSolenoid.Value.kReverse);
    		break;
    	}
    }
    
    public Position get() {
    	return position;
    }
}

