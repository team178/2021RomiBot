package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

public class PIDAuto extends SequentialCommandGroup {
    /**
     * Creates a new Autonomous Drive based on distance. This will drive out for a
     * specified distance, turn around and drive back.
     *
     * @param drivetrain The drivetrain subsystem on which this command will run
     */
    public PIDAuto(Drivetrain drivetrain) {
      addCommands(
        new PIDFoward(drivetrain, 0.3048, 0.0254),
        new PIDTurn(drivetrain, 90, 2));
    }
}
