/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import edu.wpi.first.wpilibj.Servo;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
// import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {

  private GenericHID m_stick;
  private static final int leftFront = 1; 
  private static final int leftBack = 2;
  private static final int rightFront = 4; // just 3
  private static final int rightBack = 33;
  // private static final int armDeviceID2 = 24;
  // private static final int armDeviceID = 21;


  
  private CANSparkMax m_leftMotorFront;
  private CANSparkMax m_rightMotorFront;
  private CANSparkMax m_leftMotorBack;
  private CANSparkMax m_rightMotorBack;

  // private VictorSPX m_arm_bottomSet;
  // private VictorSPX m_arm_topSet;
  // private VictorSPXControlMode spxControlMode = VictorSPXControlMode.PercentOutput;

  private DifferentialDrive m_myRobot;

  // private Servo servo_1;

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
    m_leftMotorBack = new CANSparkMax(leftBack, MotorType.kBrushed);
    m_rightMotorBack = new CANSparkMax(rightBack, MotorType.kBrushed);

    /**
     * The RestoreFactoryDefaults method can be used to reset the configuration parameters
     * in the SPARK MAX to their factory default state. If no argument is passed, these
     * parameters will not persist between power cycles
     */
    m_leftMotorBack.restoreFactoryDefaults();
    m_rightMotorBack.restoreFactoryDefaults();

    m_leftMotorFront = new CANSparkMax(leftFront, MotorType.kBrushed);
    m_rightMotorFront = new CANSparkMax(rightFront, MotorType.kBrushed);

    m_leftMotorFront.restoreFactoryDefaults();
    m_rightMotorFront.restoreFactoryDefaults();

    // m_arm_bottomSet = new VictorSPX(armDeviceID);
    // m_arm_topSet = new VictorSPX(armDeviceID2);

    m_myRobot = new DifferentialDrive(m_leftMotorBack, m_rightMotorBack);

    m_stick = new GenericHID(0);
    // servo_1 = new Servo(0);
  }

  
  public void setTopMotors(double l, double r){
    m_leftMotorFront.set(l);
    m_rightMotorFront.set(-r);
  }

  // public void setArmMotors(double speed){
  //   m_arm_bottomSet.set(spxControlMode, speed);
  //   m_arm_topSet.set(spxControlMode, speed);
  // }

  @Override
  public void teleopPeriodic() {
    m_myRobot.arcadeDrive(-m_stick.getRawAxis(4)*0.75, -m_stick.getRawAxis(1));
    setTopMotors(m_leftMotorBack.get(), m_rightMotorBack.get());
    //m_arm_bottomSet.set(spxControlMode, m_stick.getRawAxis(0)*0.5);
    //m_arm_topSet.set(spxControlMode, m_stick.getRawAxis(4)*0.5);

    //servo_1.set(0.1);
    // servo_1.setAngle(180);
  }
}
