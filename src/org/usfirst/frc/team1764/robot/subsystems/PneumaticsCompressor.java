package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.commands.StartCompressor;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticsCompressor extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Compressor compressor;
	
	public PneumaticsCompressor() {
		compressor = new Compressor(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new StartCompressor());
    }
    
    public void start() {
    	compressor.start();
    }
}

