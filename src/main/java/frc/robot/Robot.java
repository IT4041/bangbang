// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

/**
 * This is a sample program to demonstrate the use of a BangBangController with
 * a flywheel to
 * control RPM.
 */
public class Robot extends TimedRobot{

  private final XboxController driver = new XboxController(0);
  private static CANSparkMax upperShooter = new CANSparkMax(9, MotorType.kBrushless);
  private static CANSparkMax lowerShooter = new CANSparkMax(55, MotorType.kBrushless);
  private static CANSparkMax intake = new CANSparkMax(33, MotorType.kBrushless);
  private double speed = 0;

  @Override
  public void robotInit() {

    upperShooter.restoreFactoryDefaults();
    lowerShooter.restoreFactoryDefaults();
    intake.restoreFactoryDefaults();

    upperShooter.setIdleMode(IdleMode.kCoast);
    lowerShooter.setIdleMode(IdleMode.kCoast);
    intake.setIdleMode(IdleMode.kCoast);

    lowerShooter.follow(upperShooter, true);
  }

  /** Controls flywheel to a set speed (RPM) controlled by a joystick. */
  @Override
  public void teleopPeriodic() {
    upperShooter.set(speed);
    intake.set(.75);
    SmartDashboard.putNumber("Intake Motor Speed", speed);
    if(driver.getYButtonPressed()){
      if (speed <= 0.95) {
        speed += 0.05;
      }
    }

    if(driver.getAButtonPressed()){
       if (speed >= 0.05) {
        speed -= 0.05;
      }
    }

  }

  /** Update our simulation. This should be run every robot loop in simulation. */
  @Override
  public void simulationPeriodic() {

  }

}
