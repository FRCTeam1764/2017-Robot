package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.Robot;
import org.usfirst.frc.team1764.robot.RobotMap;
import org.usfirst.frc.team1764.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team1764.robot.commands.DriveWithRampingJoystick;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends PIDSubsystem {
	private boolean highGear = false;
	
	private CANTalon leftFront,leftBack, rightFront, rightBack;
	private DoubleSolenoid shifter;
	private static ADXRS450_Gyro gyro;
//	private static AnalogInput ir;
	
	public Chassis() {
		super(0.03,0.001,0.0);
		gyro = new ADXRS450_Gyro();
//		ir = new AnalogInput(9);

		leftFront = new CANTalon(RobotMap.PORT_CHASSIS_LEFT_FRONT);
		leftBack = new CANTalon(RobotMap.PORT_CHASSIS_LEFT_BACK);
		rightFront = new CANTalon(RobotMap.PORT_CHASSIS_RIGHT_FRONT);
		rightBack = new CANTalon(RobotMap.PORT_CHASSIS_RIGHT_BACK);
		
		shifter = new DoubleSolenoid(RobotMap.PORT_CHASSIS_SHIFTER_SOLE_ONE, RobotMap.PORT_CHASSIS_SHIFTER_SOLE_TWO);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoystick());
    }
    
    //				Motors				\\
    public void setSpeedLeft(double leftSpeed) {
    	leftBack.set(-leftSpeed);
    	leftFront.set(-leftSpeed);
    }
    
    public void setSpeedRight(double rightSpeed) {
    	rightBack.set(rightSpeed);
    	rightFront.set(rightSpeed);
    }
    
    public void setPIDSpeedLeft(double leftSpeed) {
    	leftBack.pidWrite(-leftSpeed);
    	leftFront.pidWrite(-leftSpeed);
    }
    
    public void setPIDSpeedRight(double rightSpeed) {
    	rightBack.pidWrite(rightSpeed);
    	rightFront.pidWrite(rightSpeed);
    }
    
    public void setSpeedBoth(double leftSpeed, double rightSpeed) {
    	setSpeedLeft(leftSpeed);
    	setSpeedRight(rightSpeed);
    }
    
    //				Shifter				\\
    public void setShifter(boolean highGear) {
    	this.highGear = highGear;
    	if(highGear) {
    		shifter.set(DoubleSolenoid.Value.kForward);
    	} else {
    		shifter.set(DoubleSolenoid.Value.kReverse);
    	}
    }
    
    public boolean getShifter() {
    	return highGear;
    }


    public void setPIDLeft(double speed) {
    	
    	leftFront.pidWrite(speed);
    	leftBack.pidWrite(speed);
    }
    
    public void setPIDRight(double speed) {
    	rightFront.pidWrite(speed);
    	rightBack.pidWrite(speed);
    }
    
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return Robot.gyro.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
		setPIDLeft(output);
		setPIDRight(output);
		
	}
	
	public double getGyroAngle() {
		return gyro.getAngle();
	}
	
	public void resetGyro() {
		gyro.reset();
	}
	
	public double getIR() {
		//return ir.getValue();
		return 0.0;
	}

}

