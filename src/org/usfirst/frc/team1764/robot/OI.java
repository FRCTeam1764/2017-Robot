package org.usfirst.frc.team1764.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team1764.robot.commands.ExampleCommand;
import org.usfirst.frc.team1764.robot.commands.MoveGearIntake;
import org.usfirst.frc.team1764.robot.commands.RunFeeder;
import org.usfirst.frc.team1764.robot.commands.RunFuelIntake;
import org.usfirst.frc.team1764.robot.commands.RunLifter;
import org.usfirst.frc.team1764.robot.commands.RunShooter;
import org.usfirst.frc.team1764.robot.commands.Shift;
import org.usfirst.frc.team1764.robot.commands.ShooterGroup;
import org.usfirst.frc.team1764.robot.commands.StopFeeder;

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
	
	JoystickButton feederButton;
	JoystickButton lifterButton;
	
	
	//			GETTERS				\\
	public double getDriveY() {
		if(pilot.getIsXbox()) {
			return pilot.getRawAxis(Constants.XBOX_DRIVE_FWD) - pilot.getRawAxis(Constants.XBOX_DRIVE_BACK);
		} else {
			return pilot.getY();
		}
	}
	
	public double getDriveZ() {
		if(pilot.getIsXbox()) {
			return pilot.getRawAxis(Constants.XBOX_DRIVE_TURNING);
		} else {
			return pilot.getZ();
		}
	}
	
	public OI() {
		pilot = new Joystick(0);
		copilot = new Joystick(1);
		
		//Assign Buttons
		gearIntakeToggle = new JoystickButton(pilot, Constants.PILOT_XBOX_GEARINTAKE_TOGGLE_BUTTON);
		
		if(Constants.COPILOT_ENABLED) {
			runFuelIntake = new JoystickButton(copilot, Constants.COPILOT_FUELINTAKE_BUTTON);
			//gearIntakeToggle = new JoystickButton(copilot, Constants.COPILOT_GEARINTAKE_TOGGLE_BUTTON);
			flywheelButton = new JoystickButton(copilot, Constants.COPILOT_FLYWHEEL_BUTTON);
			feederButton = new JoystickButton(copilot, Constants.COPILOT_FEEDER_BUTTON);
		} else {
			if (pilot.getIsXbox())
			{
				runFuelIntake = new JoystickButton(pilot, Constants.PILOT_XBOX_FUELINTAKE_BUTTON);
				//gearIntakeToggle = new JoystickButton(pilot, Constants.PILOT_XBOX_GEARINTAKE_TOGGLE_BUTTON);
				flywheelButton = new JoystickButton(pilot, Constants.PILOT_XBOX_FLYWHEEL_BUTTON);
				feederButton = new JoystickButton(pilot, Constants.PILOT_XBOX_FEEDER_BUTTON);
			}
			else
			{
				runFuelIntake = new JoystickButton(pilot, Constants.PILOT_FUELINTAKE_BUTTON);
				gearIntakeToggle = new JoystickButton(pilot, Constants.PILOT_GEARINTAKE_TOGGLE_BUTTON);
				flywheelButton = new JoystickButton(pilot, Constants.PILOT_FLYWHEEL_BUTTON);
				feederButton = new JoystickButton(pilot, Constants.PILOT_FEEDER_BUTTON);
			}
		}
		if(pilot.getIsXbox())
		{
			shiftHigh = new JoystickButton(pilot, Constants.PILOT_XBOX_SHIFT_UP_BUTTON);
			shiftLow = new JoystickButton(pilot, Constants.PILOT_XBOX_SHIFT_DOWN_BUTTON);
			lifterButton = new JoystickButton(pilot, Constants.PILOT_XBOX_LIFTER_BUTTON);
		}
		else
		{
			shiftHigh = new JoystickButton(pilot, Constants.PILOT_SHIFT_UP_BUTTON);
			shiftLow = new JoystickButton(pilot, Constants.PILOT_SHIFT_DOWN_BUTTON);
			lifterButton = new JoystickButton(pilot, Constants.PILOT_LIFTER_BUTTON);
		}
		
		
		////////////////
		
		//Bind buttons to commands
		shiftHigh.whenPressed(new Shift(true));
		shiftLow.whenPressed(new Shift(false));
		
		runFuelIntake.whileHeld(new RunFuelIntake());
		
		gearIntakeToggle.whenActive(new MoveGearIntake(true));
		gearIntakeToggle.whenInactive(new MoveGearIntake(false));
		
		feederButton.whileHeld(new RunFeeder(Constants.INTAKE_SPEED));
		
		
		//flywheelButton.whileActive(new RunShooter(false));
		flywheelButton.toggleWhenPressed(new ShooterGroup());
//		flywheelButton.toggleWhenReleased(new StopFeeder());
		lifterButton.whileHeld(new RunLifter(-1.0));
		////////////////
	}
}
