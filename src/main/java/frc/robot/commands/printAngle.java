package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class printAngle extends CommandBase {

    private Drivetrain driveTrain;

    public printAngle(Drivetrain drivetrain){
        this.driveTrain = drivetrain;
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      System.out.println("Left Encoder: " + driveTrain.getLeftDistanceMeter());
      System.out.println("Right Encoder: " + driveTrain.getRightDistanceMeter());
      System.out.println("Error: " + (driveTrain.getRightDistanceMeter() - driveTrain.getLeftDistanceMeter()));
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}
