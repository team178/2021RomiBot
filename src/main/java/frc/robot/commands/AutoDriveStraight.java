// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutoDriveStraight extends CommandBase {
  
  private Drivetrain drivetrain;
  private double targetHeading;
  private double currentHeading;
  private double error;

  private double kP = 0.07;
  private double leftPower = 1;
  private double rightPower = 1;
  private double tolerance = 2;

  public AutoDriveStraight(Drivetrain drivetrain, double targetHeading) {
    addRequirements(drivetrain);
    this.drivetrain = drivetrain;
    this.targetHeading = targetHeading;
    currentHeading = drivetrain.getHeading();
  }

  @Override
  public void initialize() {
    drivetrain.arcadeDrive(0, 0);
  }

  @Override
  public void execute() {
    error = currentHeading - targetHeading;
    if (Math.abs(error) > tolerance) {
      if (error > 0) {
        leftPower -= (error * kP);
      } else {
        rightPower -= (error * kP);
      }
    }
    drivetrain.tankDrivePower(leftPower, rightPower);

    leftPower = 1;
    rightPower = 1;
  }
  
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
