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
        /* Mondrian Madness Cords
        new DriveDistance(drivetrain, 0.4318, 0.0005),
        new PIDTurn(drivetrain, 90, 2.5),
        new DriveDistance(drivetrain, 0.4445, 0.0005),
        new PIDTurn(drivetrain, 90, 2.5),
        new DriveDistance(drivetrain, 0.4191, 0.0005),
        new PIDTurn(drivetrain, 90, 2.5),
        new DriveDistance(drivetrain, 0.2413, 0.0005),
        new PIDTurn(drivetrain, -90, 2.5),
        new DriveDistance(drivetrain, 0.2921, 0.0005),
        new PIDTurn(drivetrain, -90, 2.5),
        new DriveDistance(drivetrain, 0.4572, 0.0005),
        new PIDTurn(drivetrain, -90, 2.5),
        new DriveDistance(drivetrain, 0.4572, 0.0005));
        */

        //First Ball Is Picked Up Here
        new DriveDistance(drivetrain, 0.381, 0.0005),
        new PIDTurn(drivetrain, 90, 2.5),
        new DriveDistance(drivetrain, 0.381, 0.0005),
        new PIDTurn(drivetrain, 90, 2.5),
        new PIDTurn(drivetrain, 90, 2.5),

        //Sets Romi For Second Ball
        new DriveDistance(drivetrain, 0.381, 0.0005),
        new PIDTurn(drivetrain, 90, 2.5),
        new DriveDistance(drivetrain, 0.1905, 0.0005),
        new PIDTurn(drivetrain, -90, 2.5),
        new DriveDistance(drivetrain, 0.381, 0.0005),
        new PIDTurn(drivetrain, 90, 2.5),
        new DriveDistance(drivetrain, 0.381, 0.0005),
        new PIDTurn(drivetrain, 90, 2.5),

        //Grabs the Second Ball and Sets up for Last Ball
        new DriveDistance(drivetrain, 0.762, 0.0005),
        new PIDTurn(drivetrain, 90, 2.5),
        new PIDTurn(drivetrain, 90, 2.5),
        new DriveDistance(drivetrain, 0.762, 0.0005),
        new PIDTurn(drivetrain, 90, 2.5),
        
        //Grabs the Last Ball and Sets up for the end circle
        new DriveDistance(drivetrain, 0.5715, 0.0005),
        new PIDTurn(drivetrain, 90, 2.5),
        new DriveDistance(drivetrain, 0.762, 0.0005),
        new PIDTurn(drivetrain, 90, 2.5),
        new PIDTurn(drivetrain, 90, 2.5),
        
        //Gets to the End Circle
        new DriveDistance(drivetrain, 0.381, 0.0005),
        new PIDTurn(drivetrain, 90, 2.5),
        new DriveDistance(drivetrain, 0.381, 0.0005));


    }
}
