// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.awt.event.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

/**
 * This is a sample program to demonstrate the use of a BangBangController with
 * a flywheel to
 * control RPM.
 */
public class Robot extends TimedRobot implements KeyListener {

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

  }

  /** Update our simulation. This should be run every robot loop in simulation. */
  @Override
  public void simulationPeriodic() {

  }

  @Override
  public void keyTyped(KeyEvent e) {
    action(e);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    action(e);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    //action(e);
  }

  private void action(KeyEvent e) {
    SmartDashboard.putString("Key Code", String.valueOf(e.getKeyChar()));
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_LEFT) {

    }

    if (key == KeyEvent.VK_RIGHT) {

    }

    if (key == KeyEvent.VK_UP) {
      if (speed <= 0.95) {
        speed += 0.05;
      }
    }

    if (key == KeyEvent.VK_DOWN) {
      if (speed >= 0.05) {
        speed -= 0.05;
      }
    }

  }
}
