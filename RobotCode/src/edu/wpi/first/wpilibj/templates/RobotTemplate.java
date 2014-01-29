/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.DriverStationLCD.Line;
import edu.wpi.first.wpilibj.RobotDrive; 
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer; 


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    DriverStationLCD lcd = DriverStationLCD.getInstance();
    Joystick driveStick = new Joystick(1);
    RobotDrive driveM = new RobotDrive(1, 2);
    Joystick assistStick = new Joystick(2);
    Talon assistMotor = new Talon(3);
    //Intake intakeSystem = new Intake(3, assistStick, lcd);
    //RobotDrive driveA = new RobotDrive(4,3);
    
    double dir;
    
    
    public void robotInit() {
        lcd.println(Line.kUser6, 1, "Robot Initialized");
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomous() {
        
        driveM.drive(0.25, 0.0);
        Timer.delay(2.00);
        driveM.drive(0.0, 0.0);
        assistMotor.set(0.2);
        Timer.delay(1.00);
        assistMotor.set(0.0);
        driveM.drive(-0.25, 0.0);
        Timer.delay(1.00);
        driveM.drive(0.0, 0.0);
        Timer.delay(6.00);
        
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void operatorControl() {
        lcd.println(Line.kUser1, 1, "Operator Control Enabled");
        lcd.updateLCD();
        
        driveM.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        driveM.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        
        //loop
        while(isOperatorControl() && isEnabled()) {
            
            driveM.arcadeDrive(driveStick, true); //Enabling Drive with Joystick
            Timer.delay(0.005);
            
            
            dir = Math.toDegrees(assistStick.getDirectionRadians());
            
            if(assistStick.getTrigger())
                assistMotor.set(getSpeedByJoystick(dir));
            else
                assistMotor.set(0.0);
            
            lcd.println(Line.kUser2, 2, Double.toString(dir));
            lcd.updateLCD();
            Timer.delay(0.005);
        }
        lcd.clear();
        
        /*
        while (true && isOperatorControl() && isEnabled()) // loop until change 
        { 
            driveM.arcadeDrive(chassisDrive, true); //Enabling Drive with Joystick
            Timer.delay(0.005);
        }
        */
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void test() {
        
        
    }
    
    private double getSpeedByJoystick(double direction) {
        Math.abs(direction);
        double temp_dir = 90.0 - direction;
        if(temp_dir > 0)
            return 0.25;
        else
            return -0.25;
    }
}
