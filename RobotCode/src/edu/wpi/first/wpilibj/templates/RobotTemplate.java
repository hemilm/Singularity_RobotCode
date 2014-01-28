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
    Joystick chassisDrive = new Joystick(1);
    RobotDrive driveM = new RobotDrive(1, 2);
    Joystick assistStick = new Joystick(2);
    //Intake intakeSystem = new Intake(3, assistStick, lcd);
    //RobotDrive driveA = new RobotDrive(4,3);
    
    double dir;
    
    
    public void robotInit() {
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomous() {
        
        
        
        //assistMotor.set(0.3);
/*              
for (int i = 0; i < 4; i++) {
drive.drive(0.5, 0.0);  // drive 50% fwd 0% turn 
Timer.delay(2.0);   // wait 2 seconds 
drive.drive(0.0, 0.75);
System.out.println("Loop count: "+i);// drive 0% fwd, 75% turn 
}

drive.drive(0.0, 0.0);
*/

//drive.drive(0.5, 0.0);
             // Timer.delay(); 
    }

    /**
     * This function is called periodically during operator control
     */
    public void operatorControl() {
        lcd.println(Line.kUser1, 1, "Operator Control Enabled");
        lcd.updateLCD();
        
        driveM.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        driveM.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        
        while(isOperatorControl() && isEnabled()) {
            
            driveM.arcadeDrive(chassisDrive, true); //Enabling Drive with Joystick
            Timer.delay(0.005);
            
            dir = Math.toDegrees(assistStick.getDirectionRadians());
            lcd.println(Line.kUser2, 2, Double.toString(dir) + "degrees");
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
    
}
