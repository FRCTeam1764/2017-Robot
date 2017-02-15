package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearIntake extends Subsystem {
	
	private DoubleSolenoid solenoid;
	private boolean state;
	
	public GearIntake() {
		solenoid = new DoubleSolenoid(RobotMap.PORT_GEARINTAKE_SOLE_ONE, RobotMap.PORT_GEARINTAKE_SOLE_TWO);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setState(boolean state) {
    	this.state = state;
    	if(!state) {
    		solenoid.set(DoubleSolenoid.Value.kForward);
    	} else {
    		solenoid.set(DoubleSolenoid.Value.kReverse);
    	}
    }
    
    public boolean getState() {
    	return state;
    }
}

