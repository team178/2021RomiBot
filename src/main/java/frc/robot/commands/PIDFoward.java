// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class PIDFoward extends CommandBase {

  private Drivetrain driveTrain;

  private double kP = .01;
  private double kD = 0; //TODO test and find value
  private double target;
  private double tolerance;

  private double error;
  private double previousError;
  private double derivative = 0;

  public PIDFoward(Drivetrain driveTrain, double target, double tolerance) {
    addRequirements(driveTrain);
    this.driveTrain = driveTrain;
    this.target = target;
    this.tolerance = tolerance;
  }

  @Override
  public void initialize() {
    driveTrain.resetEncoders();
    error = target - driveTrain.getAverageDistanceMeter();
  }

  @Override
  public void execute() {
    double startTime = Timer.getFPGATimestamp();
    double power = Math.abs((error * kP) + (derivative * kD));
    if (error > 0) {
      driveTrain.arcadeDrive(power, 0);
    } else {
      driveTrain.arcadeDrive(-power, 0);
    }
    previousError = error;
    error = target - driveTrain.getAverageDistanceMeter();
    derivative = (error - previousError) / (Timer.getFPGATimestamp() - startTime) * kD;
    System.out.println("Runtime Meter: " + driveTrain.getAverageDistanceMeter());
  }

  @Override
  public void end(boolean interrupted) {
    driveTrain.arcadeDrive(0, 0);
    System.out.println("End Meter: " + driveTrain.getAverageDistanceMeter());
  }

  @Override
  public boolean isFinished() {
    return Math.abs(error) <= tolerance;
  }
}
