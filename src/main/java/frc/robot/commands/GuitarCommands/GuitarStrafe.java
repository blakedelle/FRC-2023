// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.commands.GuitarCommands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;


public class GuitarStrafe extends CommandBase {
  DrivetrainSubsystem drivetrain;
  int direction;
  /** Creates a new guitarDrive. */
  public GuitarStrafe(DrivetrainSubsystem drivetrain, int direction) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
    this.direction = direction;
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (direction == 0) drivetrain.simpleDrive(1, 0, 0);
    else if (direction == 45) drivetrain.simpleDrive(1, -1, 0);
    else if (direction == 90) drivetrain.simpleDrive(0, -1, 0);
    else if (direction == 135) drivetrain.simpleDrive(-1, -1, 0);
    else if (direction == 180) drivetrain.simpleDrive(-1, 0, 0);
    else if (direction == 225) drivetrain.simpleDrive(-1, 1, 0);
    else if (direction == 270) drivetrain.simpleDrive(0, 1, 0);
    else if (direction == 315) drivetrain.simpleDrive(1, 1, 0);
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.simpleDrive(0, 0, 0);
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}


