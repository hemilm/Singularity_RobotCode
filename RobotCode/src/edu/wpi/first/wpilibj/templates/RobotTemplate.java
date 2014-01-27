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
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.Timer;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    Joystick chassisDrive = new Joystick(1);
    RobotDrive driveM = new RobotDrive(1,2); 
    Joystick assistTool = new Joystick(2);
    RobotDrive driveA = new RobotDrive(3,4);
    DriverStationLCD lcd = DriverStationLCD.getInstance();
    
    public void robotInit() {
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
              lcd.println(Line.kUser1,1,"Line 1");
              lcd.println(Line.kUser2,2,"Line 2");
              lcd.println(Line.kUser3,3,"Line 3");
              lcd.println(Line.kUser4,4,"Line 4");
              lcd.println(Line.kUser5,5,"Line 5");
              lcd.println(Line.kUser6,6,"Line 6");
              lcd.updateLCD();
              driveM.drive(0.25, 0.0); //25% Power Forward, 0% curve
              driveM.drive(0.00, 0.0);
              driveA.drive(.25, 0.0);
              driveM.drive(-0.25, 0.0);
          
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
     
        while (true && isOperatorControl() && isEnabled()) // loop until change 
        {  
            driveM.arcadeDrive(chassisDrive, true); //Enabling Drive with Joystick
            Timer.delay(0.005); 
            driveA.arcadeDrive(assistTool, true); //Enabling Drive with Joystick
            Timer.delay(0.002); 
            driveM.setInvertedMotor(RobotDrive.MotorType.kFrontLeft,true);
            driveM.setInvertedMotor(RobotDrive.MotorType.kFrontRight,true);
        }
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
