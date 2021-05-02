// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class PIDTurn extends CommandBase {

  private Drivetrain driveTrain;

  private double kP = .0075;
  private double kD = 0.0004; //TODO test and find value
  private double target;
  private double tolerance;

  private double error;
  private double previousError;
  private double derivative = 0;

  public PIDTurn(Drivetrain driveTrain, double target, double tolerance) {
    addRequirements(driveTrain);
    this.driveTrain = driveTrain;
    this.target = target;
    this.tolerance = tolerance;
  }

@Override
  public void initialize() {
    driveTrain.resetGyro();
    error = target - driveTrain.getHeading();
  }

  @Override
  public void execute() {
    double startTime = Timer.getFPGATimestamp();
    double power = Math.abs((error * kP) + (derivative * kD));
    if (error > 0) {
      driveTrain.arcadeDrive(0, -power);
    } else {
      driveTrain.arcadeDrive(0, power);
    }
    previousError = error;
    error = target - driveTrain.getHeading();
    derivative = (error - previousError) / (Timer.getFPGATimestamp() - startTime) * kD;
    System.out.println("Runtime Power: " + power);
    System.out.println("Runtime Error: " + error);
  }

  @Override
  public void end(boolean interrupted) {
    driveTrain.arcadeDrive(0, 0);
    System.out.println("End Angle: " + driveTrain.getHeading());
  }

  @Override
  public boolean isFinished() {
    return Math.abs(error) <= tolerance;
  }
}
