package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.Constants;
import org.usfirst.frc.team1764.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lifter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	// TODO: Create motor for the lifter and get ports for the lifter
	private SpeedController lifterMotor;
	
	public Lifter()
	{
		this.lifterMotor = new Talon(RobotMap.PORT_LIFTER);
		this.lifterMotor.setInverted(Constants.LIFTER_ISINVERTED);
	}
	
	public void set(double speed)
	{
		this.lifterMotor.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

