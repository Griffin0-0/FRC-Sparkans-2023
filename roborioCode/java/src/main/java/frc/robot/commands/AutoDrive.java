package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.subsystems.Drivetrain;

public class AutoDrive extends CommandBase{
    
    Drivetrain drivetrain;
    Timer timer;
    
    public AutoDrive(Drivetrain _drivetrain){
        drivetrain = _drivetrain;
        timer = new Timer();
    }
    public void initialize(){
        timer.reset();
        timer.start();
    }
    public void execute(){
        drivetrain.drive(0.75, 0);
        System.out.println("Calling Drive");
    }
    public boolean isFinished(){
        return timer.get() >= 2500;
    }
    public void end(){
        drivetrain.drive(0, 0);
    }
}
