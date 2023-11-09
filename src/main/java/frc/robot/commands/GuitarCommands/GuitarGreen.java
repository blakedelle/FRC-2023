// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GuitarCommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.NewIntakeIn;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.NewIntake;

public class GuitarGreen extends CommandBase {
  Joystick joystick;
  NewIntake newIntake;
  //DrivetrainSubsystem drivetrain;
  boolean played = false;
  boolean resting = false;
  boolean finished = false;
  /** Creates a new GuitarGreen. */
  public GuitarGreen(Joystick joystick, NewIntake newIntake, DrivetrainSubsystem drivetrain) {
    this.joystick = joystick;
    this.newIntake = newIntake;
    //this.drivetrain = drivetrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(newIntake);
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //System.out.println("green pressed");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  if(!finished) {
    if(!resting) {
      if(joystick.getPOV() != 180) {
        resting = true;
      }
    }

    if(resting && !played) {
      if(joystick.getPOV() == 180) {
        played = true;
        // System.out.println("green played");
      }
    }

    // use "if" instead of while here if using while messes things up
    if(played) {
      new NewIntakeIn(newIntake);
      finished = true;
    }


  }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("green end");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
