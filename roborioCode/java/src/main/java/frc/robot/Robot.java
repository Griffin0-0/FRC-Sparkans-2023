/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Servo;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
// import com.ctre.phoenix.motorcontrol.can.*;
// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {

  private GenericHID m_stick;
  // private static final int leftFront = 1; 
  // private static final int leftBack = 2;
  // private static final int rightFront = 4; // just 3
  // private static final int rightBack = 33;
  // private static final int victorDeviceID = 1;
  // private static final int victorDeviceID2 = 2;
  // private static final int victorDeviceID3 = 3;
  // private static final int victorDeviceID4 = 4;

  public int armGrabAngle = 0;

  // private double armPower = 0.0;

  
  // private CANSparkMax m_leftMotorFront;
  // private CANSparkMax m_rightMotorFront;
  // private CANSparkMax m_leftMotorBack;
  // private CANSparkMax m_rightMotorBack;

  // private WPI_VictorSPX m_vLeftMotorFront;
  // private WPI_VictorSPX m_vRightMotorFront;
  // private WPI_VictorSPX m_vLeftMotorBack;
  // private WPI_VictorSPX m_vRightMotorBack;
  // private VictorSPXControlMode spxControlMode = VictorSPXControlMode.PercentOutput;

  // private DifferentialDrive m_myRobot;

  private Servo servo_1;
  private Servo servo_2;

  @Override
  public void robotInit() {
  /**
   * SPARK MAX controllers are intialized over CAN by constructing a CANSparkMax object
   * 
   * The CAN ID, which can be configured using the SPARK MAX Client, is passed as the
   * first parameter
   * 
   * The motor type is passed as the second parameter. Motor type can either be:
   *  com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless
   *  com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushed
   * 
   * The example below initializes four brushless motors with CAN IDs 1 and 2. Change
   * these parameters to match your setup
   */
    // m_leftMotorBack = new CANSparkMax(leftBack, MotorType.kBrushed);
    // m_rightMotorBack = new CANSparkMax(rightBack, MotorType.kBrushed);

    /**
     * The RestoreFactoryDefaults method can be used to reset the configuration parameters
     * in the SPARK MAX to their factory default state. If no argument is passed, these
     * parameters will not persist between power cycles
     */
    // m_leftMotorBack.restoreFactoryDefaults();
    // m_rightMotorBack.restoreFactoryDefaults();

    // m_leftMotorFront = new CANSparkMax(leftFront, MotorType.kBrushed);
    // m_rightMotorFront = new CANSparkMax(rightFront, MotorType.kBrushed);

    // m_leftMotorFront.restoreFactoryDefaults();
    // m_rightMotorFront.restoreFactoryDefaults();

    // m_arm_bottomSet = new VictorSPX(armDeviceID);
    // m_arm_topSet = new VictorSPX(armDeviceID2);

    // m_vLeftMotorFront = new WPI_VictorSPX(victorDeviceID);
    // m_vLeftMotorBack = new WPI_VictorSPX(victorDeviceID2);

    // m_vRightMotorBack = new WPI_VictorSPX(victorDeviceID3);
    // m_vRightMotorFront = new WPI_VictorSPX(victorDeviceID4);

    // // m_myRobot = new DifferentialDrive(m_leftMotorBack, m_rightMotorBack);
    // m_myRobot = new DifferentialDrive(m_vLeftMotorBack, m_vRightMotorBack);

    m_stick = new GenericHID(0);
    servo_1 = new Servo(0);
    servo_2 = new Servo(1);
  }

  
  // public void setTopMotors(double l, double r){
  //   m_leftMotorFront.set(l);
  //   m_rightMotorFront.set(r);
  // }

  // public void setTopVictors(double l, double r){
  //   m_vRightMotorFront.set(spxControlMode, r);
  //   m_vLeftMotorFront.set(spxControlMode, l);
  // }

  // public void armTest(double power){
  //   m_rightMotorBack.set(power);
  //   m_leftMotorBack.set(power);
  // }

  @Override
  public void teleopPeriodic() {
  //   m_myRobot.arcadeDrive(m_stick.getRawAxis(2)*-0.5, m_stick.getRawAxis(1)*-0.5);
  //   setTopVictors(m_vLeftMotorBack.get(), m_vRightMotorBack.get());
    //m_arm_bottomSet.set(spxControlMode, m_stick.getRawAxis(0)*0.5);
    //m_arm_topSet.set(spxControlMode, m_stick.getRawAxis(4)*0.5);

    // if(m_stick.getRawButtonPressed(7) && armPower < 1){
    //   armPower = armPower + 0.05;
    // }
    // if(m_stick.getRawButtonPressed(5) && armPower > 0){
    //   armPower = armPower - 0.05;
    // } 


    if (m_stick.getRawButton(6) && armGrabAngle <= 60){
      armGrabAngle++;
      System.out.println("up");
    }
    if (m_stick.getRawButton(8) && armGrabAngle >= 0){
      armGrabAngle--;
      System.out.println("down");
    }

    servo_1.setAngle((armGrabAngle*2)+49);
    servo_2.setAngle((armGrabAngle*2)+26);
  }
}
