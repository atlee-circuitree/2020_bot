/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;

public class conveyorbeltSubsystem extends SubsystemBase {

  Spark motor;
  
 public conveyorbeltSubsystem() {
    
    Spark leftmotorconveyorbelt = new Spark(); //dont' know the ports yet
    Spark rightmotorconveyorbelt = new Spark(); 

  }

  public void periodic() {
   
  }
}
