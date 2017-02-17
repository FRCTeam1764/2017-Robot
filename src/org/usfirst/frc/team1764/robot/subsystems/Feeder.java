package org.usfirst.frc.team1764.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1764.robot.RobotMap;

/**
 *
 */
public class Feeder extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController feederWheel;
	
	public Feeder()
	{
		this.feederWheel = new Talon(RobotMap.PORT_FEEDER_WHEEL);
	}
	
	public void set(double speed)
	{
		this.feederWheel.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

