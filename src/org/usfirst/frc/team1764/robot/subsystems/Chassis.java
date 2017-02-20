package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.RobotMap;
import org.usfirst.frc.team1764.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team1764.robot.commands.DriveWithRampingJoystick;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem {
	private boolean highGear = false;
	
	private CANTalon leftFront,leftBack, rightFront, rightBack;
	private DoubleSolenoid shifter;
	private Compressor compressor; 
	
	public Chassis() {
		leftFront = new CANTalon(RobotMap.PORT_CHASSIS_LEFT_FRONT);
		leftBack = new CANTalon(RobotMap.PORT_CHASSIS_LEFT_BACK);
		rightFront = new CANTalon(RobotMap.PORT_CHASSIS_RIGHT_FRONT);
		rightBack = new CANTalon(RobotMap.PORT_CHASSIS_RIGHT_BACK);
		
		shifter = new DoubleSolenoid(RobotMap.PORT_CHASSIS_SHIFTER_SOLE_ONE, RobotMap.PORT_CHASSIS_SHIFTER_SOLE_TWO);
		compressor = new Compressor(0);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoystick());
    }
    
    //				Motors				\\
    public void setSpeedLeft(double leftSpeed) {
    	leftBack.set(-leftSpeed);
    	leftFront.set(-leftSpeed);
    }
    public void turnOnCompressor() //This runs the compressor at the start of the round rather than the first time you try to shift
    {
    	compressor.start();
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
    	System.out.println(leftSpeed + ":" + rightSpeed);
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
}

