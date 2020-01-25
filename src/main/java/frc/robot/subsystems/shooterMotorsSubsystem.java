/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

@SuppressWarnings("deprecation")

  public class shooterMotorsSubsystem extends SubsystemBase{
  
  private static final int leftDeviceID = 1; 
  private static final int rightDeviceID = 2;
  private CANSparkMax m_leftMotor;
  private CANSparkMax m_rightMotor;

  
 public shooterMotorsSubsystem() 
  {      
  
    m_leftMotor = new CANSparkMax(leftDeviceID, MotorType.kBrushless);
    m_rightMotor = new CANSparkMax(rightDeviceID, MotorType.kBrushless);


  }
      
public void moveForward()
{
    motor.setSpeed(1);
}

public void moveBackward()
{
    motor.setSpeed(-1);
}
}
