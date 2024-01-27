// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

/**
 * This is a sample program to demonstrate the use of a BangBangController with a flywheel to
 * control RPM.
 */
public class Robot extends TimedRobot {

  private static CANSparkMax upperShooter = new CANSparkMax(9,MotorType.kBrushless);
  private static CANSparkMax lowerShooter = new CANSparkMax(55,MotorType.kBrushless);
  private static CANSparkMax intake  = new CANSparkMax(33,MotorType.kBrushless);

  @Override
  public void robotInit() {
    upperShooter.restoreFactoryDefaults();
    lowerShooter.restoreFactoryDefaults();
    intake.restoreFactoryDefaults();

    upperShooter.setIdleMode(IdleMode.kCoast);
    lowerShooter.setIdleMode(IdleMode.kCoast);
    intake.setIdleMode(IdleMode.kCoast);
  }

  /** Controls flywheel to a set speed (RPM) controlled by a joystick. */
  @Override
  public void teleopPeriodic() {

      upperShooter.set(.65);
      lowerShooter.set(-.65);
      intake.set(.75);

  }

  /** Update our simulation. This should be run every robot loop in simulation. */
  @Override
  public void simulationPeriodic() {

  }
}
