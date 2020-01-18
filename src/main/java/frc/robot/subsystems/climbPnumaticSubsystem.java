package frc.robot;


import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.SampleRobot;

@SuppressWarnings("deprecation")

public class Pnumatics extends SampleRobot
{
    DoubleSolenoid Shooter = new DoubleSolenoid(1, 3, 4);
	DoubleSolenoid piston2 = new DoubleSolenoid(1, 5, 6);
}