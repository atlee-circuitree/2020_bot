/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

//import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.XboxController;
import frc.robot.subsystems.climbupPnumaticSubsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class climbupPnumaticCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final frc.robot.subsystems.climbupPnumaticSubsystem m_subsystem;

  /**
   * Creates a new ExampleCommand.
   * 
   * @param <climbupPnumaticSubsystem>
   *
   * @param subsystem                  The subsystem used by this command.
   */
  public <climbupPnumaticSubsystem> climbupPnumaticCommand(climbupPnumaticSubsystem subsystem) {
    m_subsystem = (frc.robot.subsystems.climbupPnumaticSubsystem) subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements((frc.robot.subsystems.climbupPnumaticSubsystem) subsystem);
  }

  private void addRequirements(climbupPnumaticSubsystem subsystem) {
}

// Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

     if (XboxController.bController = 1)  {



     }

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
