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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.CANDigitalInput;

public class conveyorbeltSubsystem extends SubsystemBase {

  private static final int leftDeviceID = ; //Need to assign Device ID at a later date
  private static final int rightDeviceID = ;
  private CANSparkMax m_leftMotor;
  private CANSparkMax m_rightMotor;
  private CANDigitalInput m_forwardLimit;
  private CANDigitalInput m_reverseLimit;

  public conveyorbeltSubsystem() {

    m_leftMotor = new CANSparkMax(leftDeviceID, MotorType.kBrushless);
    m_rightMotor = new CANSparkMax(rightDeviceID, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    
    m_forwardLimit.enableLimitSwitch(SmartDashboard.getBoolean("Forward Limit Enabled", false));
    m_reverseLimit.enableLimitSwitch(SmartDashboard.getBoolean("Reverse Limit Enabled", false));  
    
    SmartDashboard.putBoolean("Forward Limit Switch", m_forwardLimit.get());
    SmartDashboard.putBoolean("Reverse Limit Switch", m_reverseLimit.get());

  }
}
