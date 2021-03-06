// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.team2667.robotcannon.subsystems;

import org.team2667.robotcannon.RobotMap;
import org.team2667.robotcannon.commands.Drive;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * DriveTrain Subsystem
 * @author Haruko
 * @since September 19, 2015
 */
public class DriveTrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController leftFront = RobotMap.driveTrainLeftFront;
    private final SpeedController leftRear = RobotMap.driveTrainLeftRear;
    private final SpeedController rightRear = RobotMap.driveTrainRightRear;
    private final SpeedController rightFront = RobotMap.driveTrainRightFront;
    private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    AnalogInput rangeFinder = RobotMap.sensorsUltraSonicSensor;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new Drive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	/**
	 * Set the max output speed
	 * @param speed
	 */
	public void setMaxOutput(double speed) {
		robotDrive.setMaxOutput(speed);
	}
	
	/**
	 * Arcade drive with the joystick input
	 * @param operatorInterface
	 */
	public void arcadeDrive(Joystick operatorInterface){
		robotDrive.arcadeDrive(operatorInterface.getX(), operatorInterface.getY(), true);
	}
	
	public void tankDrive(Joystick leftStick, Joystick rightStick){
		robotDrive.tankDrive(leftStick, rightStick);
	}
	
	/**
	 * Stops the drive train
	 */
	public void stop() {
		robotDrive.arcadeDrive(0, 0);
	}
	
	public double getDistanceToObstacle() {
		return rangeFinder.getAverageVoltage();
	}
	
}

