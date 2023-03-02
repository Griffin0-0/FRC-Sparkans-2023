package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.AutoDrive;
import frc.robot.subsystems.Drivetrain;

public class AutoCommand extends SequentialCommandGroup  {
    public AutoCommand (){
        
        Drivetrain drivetrain = new Drivetrain();

        addCommands(
           new SequentialCommandGroup(
                new AutoDrive(drivetrain)
           )
        );
    }
}
