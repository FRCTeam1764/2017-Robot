package org.usfirst.frc.team1764.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team1764.robot.commands.ExampleCommand;
import org.usfirst.frc.team1764.robot.commands.MoveGearIntake;
import org.usfirst.frc.team1764.robot.commands.RunFuelIntake;
import org.usfirst.frc.team1764.robot.commands.RunShooter;
import org.usfirst.frc.team1764.robot.commands.Shift;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick pilot;
	Joystick copilot;
	
	//			BUTTONS				\\
	JoystickButton shiftHigh;
	JoystickButton shiftLow;
	
	JoystickButton gearIntakeToggle;
	JoystickButton runFuelIntake;
	
	JoystickButton flywheelButton;
	
	//			GETTERS				\\
	public double getDriveY() {
		if(pilot.getIsXbox()) {
			return pilot.getRawAxis(Constants.XBOX_DRIVE_X_AXIS) - pilot.getRawAxis(Constants.XBOX_DRIVE_X_NEG_AXIS);
		} else {
			return pilot.getY();
		}
	}
	
	public double getDriveZ() {
		if(pilot.getIsXbox()) {
			return pilot.getRawAxis(Constants.XBOX_DRIVE_Z_AXIS);
		} else {
			return pilot.getZ();
		}
	}
	
	public OI() {
		pilot = new Joystick(0);
		copilot = new Joystick(1);
		
		//Assign Buttons
		if(Constants.COPILOT_ENABLED) {
			runFuelIntake = new JoystickButton(copilot, Constants.COPILOT_FUELINTAKE_BUTTON);
			gearIntakeToggle = new JoystickButton(copilot, Constants.COPILOT_GEARINTAKE_TOGGLE_BUTTON);
			flywheelButton = new JoystickButton(copilot, Constants.COPILOT_FLYWHEEL_BUTTON);
		} else {
			runFuelIntake = new JoystickButton(pilot, Constants.PILOT_FUELINTAKE_BUTTON);
			gearIntakeToggle = new JoystickButton(pilot, Constants.PILOT_GEARINTAKE_TOGGLE_BUTTON);
			flywheelButton = new JoystickButton(pilot, Constants.PILOT_FLYWHEEL_BUTTON);
		}
		
		shiftHigh = new JoystickButton(pilot, Constants.PILOT_SHIFT_UP_BUTTON);
		shiftLow = new JoystickButton(pilot, Constants.PILOT_SHIFT_DOWN_BUTTON);
		////////////////
		
		//Bind buttons to commands
		shiftHigh.whenPressed(new Shift(true));
		shiftLow.whenPressed(new Shift(false));
		
		runFuelIntake.whileHeld(new RunFuelIntake());
		
		gearIntakeToggle.whenActive(new MoveGearIntake(true));
		gearIntakeToggle.whenInactive(new MoveGearIntake(false));
		
		flywheelButton.whileActive(new RunShooter());
		////////////////
	}
}
