// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class NewIntake extends SubsystemBase {
  public WPI_TalonSRX motor;
  /** Creates a new NewIntake. */
  public NewIntake() {
    motor = new WPI_TalonSRX(newIntakeCanID);
    motor.setNeutralMode(NeutralMode.Brake);
  }
  
  public void in() {
    motor.set(ControlMode.PercentOutput, 1);
  }

  public void out() {
    motor.set(ControlMode.PercentOutput, -1);
  }

  public void stop() {
    motor.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
