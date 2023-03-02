package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private static int victorDeviceID;
    private static int victorDeviceID2;
    private static int victorDeviceID3;
    private static int victorDeviceID4;

    
    private WPI_VictorSPX m_vLeftMotorFront;
    private WPI_VictorSPX m_vRightMotorFront;
    private WPI_VictorSPX m_vLeftMotorBack;
    private WPI_VictorSPX m_vRightMotorBack;
    private VictorSPXControlMode spxControlMode;

    private DifferentialDrive drivetrain;
    
    public Drivetrain(){


        spxControlMode = VictorSPXControlMode.PercentOutput;

        victorDeviceID = 1;
        victorDeviceID2 = 2;
        victorDeviceID3 = 3;
        victorDeviceID4 = 4;

        m_vLeftMotorFront = new WPI_VictorSPX(victorDeviceID);
        m_vLeftMotorBack = new WPI_VictorSPX(victorDeviceID2);

        m_vRightMotorBack = new WPI_VictorSPX(victorDeviceID3);
        m_vRightMotorFront = new WPI_VictorSPX(victorDeviceID4);

        drivetrain = new DifferentialDrive(m_vLeftMotorBack, m_vRightMotorBack);
        drivetrain.setSafetyEnabled(false);
    }

    public void drive(double speed, double rotationSpeed){
        drivetrain.arcadeDrive(speed, rotationSpeed);
        setTopVictors(m_vLeftMotorBack.get(), m_vRightMotorBack.get());
        System.out.println("Setting Victors");
    }
    public void setTopVictors(double l, double r){
        m_vRightMotorFront.set(spxControlMode, r);
        m_vLeftMotorFront.set(spxControlMode, l);
      }
      
   
}
