// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GuitarCommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.CubeShooterHigh;
import frc.robot.commands.NewIntakeIn;
import frc.robot.commands.NewIntakeOut;
import frc.robot.subsystems.ConeIntake;
import frc.robot.subsystems.CubeIntake;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.NewIntake;

public class GuitarCommand extends CommandBase {
  Joystick guitar;
  DrivetrainSubsystem drivetrain;
  NewIntake newIntake;
  CubeIntake cube;
  ConeIntake cone;
  int direction;
  boolean left;
  int button;
  Trigger green;
  Trigger red;
  Trigger yellow;
  Trigger blue;
  Trigger orange;

  boolean gPlayed = false;
  boolean rPlayed = false;
  boolean yPlayed = false;
  boolean bPlayed = false;
  boolean oPlayed = false;

  Trigger gStickF;
  Trigger gStickFR;
  Trigger gStickR;
  Trigger gStickBR;
  Trigger gStickB;
  Trigger gStickBL;
  Trigger gStickL;
  Trigger gStickFL;

  /**  Creates a new GuitarCommand. */
  public GuitarCommand(Joystick guitar, DrivetrainSubsystem drivetrain, NewIntake newIntake, CubeIntake cube, ConeIntake cone, int direction, boolean left, int button, Trigger green, Trigger red, Trigger yellow, Trigger blue, Trigger orange) {
    this.guitar = guitar;
    this.drivetrain = drivetrain;
    this.newIntake = newIntake;
    this.cube = cube;
    this.cone = cone;
    this.direction = direction;
    this.left = left;
    this.button = button;
    this.green = green;
    this.red = red;
    this.yellow = yellow;
    this.blue = blue;
    this.orange = orange;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
    addRequirements(newIntake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    gStickF = new POVButton(guitar, 180);
    gStickFR = new POVButton(guitar, 135);
    gStickR = new POVButton(guitar, 90);
    gStickBR = new POVButton(guitar, 45);
    gStickB = new POVButton(guitar, 0);
    gStickBL = new POVButton(guitar, 315);
    gStickL = new POVButton(guitar, 270);
    gStickFL = new POVButton(guitar, 225);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  if(direction == -1) {
    // Green
    if(button == 1) {
      if(guitar.getPOV() == 180) {
        gPlayed = true;
      }
      if(gPlayed) {
        green.whileTrue(new NewIntakeIn(newIntake));
      }
    }

    // Red
    if(button == 2) {
      if(guitar.getPOV() == 180) {
        rPlayed = true;
      }
      if(rPlayed) {
        red.whileTrue(new CubeShooterHigh(cone, cube));
      }
    }

    // Yellow
    if(button == 3) {
      if(guitar.getPOV() == 180) {
        yPlayed = true;
      }
      if(yPlayed) {
        yellow.whileTrue(new NewIntakeOut(newIntake));
      }
    }

    // Blue
    if(button == 4) {
      blue.whileTrue(new GuitarRotate(drivetrain, true));
    }

    // Orange
    if(button == 5) {
      orange.whileTrue(new GuitarRotate(drivetrain, false));
    }
  }

  if(button == -1) {
    // if (direction == 0) drivetrain.simpleDrive(1, 0, 0);
    // else if (direction == 45) drivetrain.simpleDrive(1, -1, 0);
    // else if (direction == 90) drivetrain.simpleDrive(0, -1, 0);
    // else if (direction == 135) drivetrain.simpleDrive(-1, -1, 0);
    // else if (direction == 180) drivetrain.simpleDrive(-1, 0, 0);
    // else if (direction == 225) drivetrain.simpleDrive(-1, 1, 0);
    // else if (direction == 270) drivetrain.simpleDrive(0, 1, 0);
    // else if (direction == 315) drivetrain.simpleDrive(1, 1, 0);

    gStickF.whileTrue(new GuitarStrafe(drivetrain, direction));
    gStickFR.whileTrue(new GuitarStrafe(drivetrain, direction));
    gStickR.whileTrue(new GuitarStrafe(drivetrain, direction));
    gStickBR.whileTrue(new GuitarStrafe(drivetrain, direction));
    gStickB.whileTrue(new GuitarStrafe(drivetrain, direction));
    gStickBL.whileTrue(new GuitarStrafe(drivetrain, direction));
    gStickL.whileTrue(new GuitarStrafe(drivetrain, direction));
    gStickFL.whileTrue(new GuitarStrafe(drivetrain, direction));
  }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(direction != -1) {
      drivetrain.simpleDrive(0, 0, 0);
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
