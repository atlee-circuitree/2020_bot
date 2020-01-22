package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;

//@SuppressWarnings("deprecation")

public class climbPnumaticSubsystem extends SubsystemBase
{
    DoubleSolenoid leftClimbPnumatic = new DoubleSolenoid(1, 5, 6);
    DoubleSolenoid rightClimbPnumatic = new DoubleSolenoid(1, 5, 6);

public climbPnumaticSubsystem()
{
    
    
}
    public void periodic() 
    {


    }
}