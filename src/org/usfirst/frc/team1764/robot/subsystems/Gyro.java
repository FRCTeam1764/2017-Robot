package org.usfirst.frc.team1764.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gyro extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private ADXRS450_Gyro gyro;
	
	public Gyro() {
		this.gyro = new ADXRS450_Gyro();
	}
	
	public double getAngle() {
		return gyro.getAngle();
	}
	
	public void reset() {
		gyro.reset();
	}
	
	public void calibrate() {
		reset();
		gyro.calibrate();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

