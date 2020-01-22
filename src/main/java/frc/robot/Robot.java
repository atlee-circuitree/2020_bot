/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.PWMTalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.DoubleSolenoid;

//Limelight Imports

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.VictorSP;


@SuppressWarnings("deprecation")

public class Robot extends TimedRobot {
    public static Object driveSubsystem;
	DifferentialDrive robotDrive;
    // Talon frontLeft, frontRight, rearLeft, rearRight;
    Spark frontLeft, frontRight, rearLeft, rearRight;

    XboxController stick;

    // public static final double kDistancePerRevolution = 18.84; // guestimate from
    // your code
    // public static final double kPulsesPerRevolution = 4096; // for an talon?
    // maybe
    // public static final double kDistancePerPulse = kDistancePerRevolution /
    // kPulsesPerRevolution;

    /**
     * Constructor. Called once when this class is created.
     */
    public Robot() {
        System.out.println("Robot.constructor()");
    }

    /**
     * Called once after class load complete. Use to perform any needed
     * initializations. Very similar to the constructor.
     */

    public void robotInit() {

        
        System.out.println("Robot.robotInit()");
        // Create two PWM Talon motor controller objects for left & right motors on PWM
        // ports 0 & 1.
        // Assumes robot has two motors controlled by Talon controllers connected via
        // PWM.
        // Add them to a drive controller class that can do tank and arcade driving
        // based on
        // joystick input.

        // public class Robot{}

        frontLeft = new Spark(8);
        rearLeft = new Spark(9);
        // frontLeft = new Talon(1);
        // rearLeft = new Talon(0);
        SpeedControllerGroup leftDrive = new SpeedControllerGroup(frontLeft, rearLeft);

        frontRight = new Spark(7);
        rearRight = new Spark(6);
        // frontRight = new Talon(3);
        // rearRight = new Talon(2);
        SpeedControllerGroup rightDrive = new SpeedControllerGroup(frontRight, rearRight);

        robotDrive = new DifferentialDrive(leftDrive, rightDrive);

        robotDrive.setExpiration(0.2); // need to see motor input at least every
                                       // 10th of a second or stop motors.

        // One side has motors reversed so the wheels turn in the same direction.
        robotDrive.setRightSideInverted(true);

        stick = new XboxController(0); // joystick on usb port 0.

    }

    /**
     * Executes a simple autonomous program. Called by the driver station or field
     * control system at the start of the autonomous period.
     */
    public void autonomous() {
        System.out.println("Robot.autonomous()");

        robotDrive.setSafetyEnabled(false); // motor safety off due to the fact
                                            // we want the motor to run 2 sec
                                            // with no other input.

        robotDrive.tankDrive(0.5, 0.5); // drive forwards half speed
        Timer.delay(2.0); // for 2 seconds.
        robotDrive.tankDrive(0.0, 0.0); // stop motors.
    }
   /**
    * Runs the motors with arcade steering, input from joystick.
    * Called by the driver station or field control system at the
    * start of the operator control (teleop) period. Runs in a loop
    * until robot is disabled.
    */
   public void operatorControl()
   {
       System.out.println("Robot.operatorControl()");
 
       robotDrive.setSafetyEnabled(true);   // motor safety back on.

        
  
       while (isOperatorControl() && isEnabled())
       {
           robotDrive.arcadeDrive(-stick.getY()/2, stick.getX()/2);   // drive with arcade style.
           robotDrive.tankDrive(-stick.getY(Hand.kLeft)/2, -stick.getY(Hand.kRight)/2);
           Timer.delay(2.0);
           
           if (XboxController.getAButton()) {

                 

           }
    

       }
    }
          private boolean m_LimelightHasValidTarget = false;
          private double m_LimelightDriveCommand = 0.0;
          private double m_LimelightSteerCommand = 0.0;
    
    public void Update_Limelight_Tracking()
    {
          // These numbers must be tuned for your Robot!  Be careful!
          final double STEER_K = 0.03;                    // how hard to turn toward the target
          final double DRIVE_K = 0.26;                    // how hard to drive fwd toward the target
          final double DESIRED_TARGET_AREA = 13.0;        // Area of the target when the robot reaches the wall
          final double MAX_DRIVE = 0.7;                   // Simple speed limit so we don't drive too fast
  
          double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
          double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
          double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
          double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
  
          if (tv < 1.0)
          {
            m_LimelightHasValidTarget = false;
            m_LimelightDriveCommand = 0.0;
            m_LimelightSteerCommand = 0.0;
            return;
          }
  
          m_LimelightHasValidTarget = true;
  
          // Start with proportional steering
          double steer_cmd = tx * STEER_K;
          m_LimelightSteerCommand = steer_cmd;
  
          // try to drive forward until the target area reaches our desired area
          double drive_cmd = (DESIRED_TARGET_AREA - ta) * DRIVE_K;
  
          // don't let the robot drive too fast into the goal
          if (drive_cmd > MAX_DRIVE)
          {
            drive_cmd = MAX_DRIVE;
          }
          m_LimelightDriveCommand = drive_cmd;
    }
    
    /**
     * Called whenever the robot is disabled by the DS or field control. Use to
     * perform any needed resets or changes when switching between modes.
     */
    public void disabled() {
        System.out.println("Robot.disabled()");
    }

    /**
     * Runs during test mode
     */
    public void test() {
        System.out.println("Robot.test()");

        // Limelime

        NetworkTableInstance.getDefault().getTable("limelight").getEntry("<variablename>").getDouble(0);
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("<variablename>").setNumber(1);

        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");

        // read values periodically
        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);

        // post to smart dashboard periodically
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);

    }
}
