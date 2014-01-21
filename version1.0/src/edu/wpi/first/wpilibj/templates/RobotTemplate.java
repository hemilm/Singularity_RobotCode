/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.RobotDrive; 
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick; 
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
    RobotDrive drive = new RobotDrive(1, 2); 
    
    public void robotInit() {
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
          for (int i = 0; i<=3; i++){
              drive.drive(0.5, 0.0); //50% Power Forward, 0% Turn for 3 Seconds 
          }
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
     
        while (true && isOperatorControl() && isEnabled()) // loop until change 
        { 
            drive.arcadeDrive(chassisDrive, true); //Enabling Drive with Joystick
            Timer.delay(0.005); 
        }
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}