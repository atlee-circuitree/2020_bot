/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.shooterMotorsSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;


/**
 * An example command that uses an example subsystem.
 */
public class shooterMotorsCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final shooterMotorsSubsystem m_shooterMotorsSubsystem;

  public shooterMotorsCommand(shooterMotorsSubsystem subsystem) {
    m_shooterMotorsSubsystem = subsystem;
    addRequirements(m_shooterMotorsSubsystem);
  }
  @Override
  public void initialize() {

  }

  
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
