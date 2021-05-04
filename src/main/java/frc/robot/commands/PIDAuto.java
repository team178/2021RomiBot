package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
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
        
        new DriveDistance(drivetrain, 0.37465 - (.00635 * 1), 0.0005),
        new WaitCommand(.5),
        new PIDTurn(drivetrain, 90, 3.5),
        new DriveDistance(drivetrain, 0.2794 - (.00635 * 1), 0.0005),
        new WaitCommand(.5),
        new DriveDistance(drivetrain, -(0.2794 - (.00635 * 1)), 0.0005),

        //Sets Romi For Second Ball
        new WaitCommand(.75),
        new PIDTurn(drivetrain, -90, 8),
        new DriveDistance(drivetrain, 0.18415 - (.00635 * 1), 0.0005),
        new WaitCommand(.75),
        new PIDTurn(drivetrain, -90, 8),
        new DriveDistance(drivetrain, 0.2994 - (.00635 * 1), 0.0005),
        new WaitCommand(.5),
        new PIDTurn(drivetrain, 90, 3.5),
        new DriveDistance(drivetrain, 0.2794 - (.00635 * 1), 0.0005),
        new WaitCommand(.5),
        new PIDTurn(drivetrain, 90, 3.5),

        //Grabs the Second Ball and Sets up for Last Ball
        new DriveDistance(drivetrain, 0.6604 - (.00635 * 1), 0.0005),
        new DriveDistance(drivetrain, -(0.6604 - (.00635 * 1)), 0.0005),
        new WaitCommand(.75),
        new PIDTurn(drivetrain, -90, 10),
        
        //Grabs the Last Ball and Sets up for the end circle
        new DriveDistance(drivetrain, 0.56515 - (.00635 * 1), 0.0005),
        new WaitCommand(.5),
        new PIDTurn(drivetrain, 90, 3.5),
        new DriveDistance(drivetrain, 0.6604 - (.00635 * 1), 0.0005),
        new DriveDistance(drivetrain, -(0.2794 - (.00635 * 1)), 0.0005),
        
        //Gets to the End Circle
        new WaitCommand(.5),
        new PIDTurn(drivetrain, -90, 8),
        new DriveDistance(drivetrain, 0.2794 - (.00635 * 1), 0.0005));


    }
}
