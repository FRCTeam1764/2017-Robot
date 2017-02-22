package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.Constants;
import org.usfirst.frc.team1764.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends PIDSubsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	SpeedController flywheel;
	public boolean isReadyForFood;
	Encoder encoder;
	
	public void DEBUGREMOVE() {
		System.out.println(returnPIDInput());
	}
	
	public Shooter() {
		super("Flywheel",0.01,0,0.01);
		//setAbsoluteTolerance(0.5);
		//getPIDController().setContinuous(false);
		if (Constants.ROBOT_IS_COMPETITION_ROBOT) {
			this.flywheel = new Spark(RobotMap.PORT_SHOOTER_FLYWHEEL);
		} else {
			this.flywheel = new Talon(RobotMap.PORT_SHOOTER_FLYWHEEL);
		}
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set(double val) {
    	flywheel.set(val);
    }
    public double returnPIDInput() {
    	return encoder.getSamplesToAverage();
    }
    public void usePIDOutput(double output) {
    	flywheel.pidWrite(output);
    }
}

