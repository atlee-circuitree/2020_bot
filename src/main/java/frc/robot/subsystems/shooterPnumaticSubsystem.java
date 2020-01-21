package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;

//@SuppressWarnings("deprecation")

public class shooterPnumaticSubsystem extends SubsystemBase
{
    DoubleSolenoid shooterPnumatic = new DoubleSolenoid(1, 5, 6);

public shooterPnumaticSubsystem()
{
    
}

    public void periodic() 
    {


    }
}