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

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {

  private GenericHID m_stick;
  private static final int leftDeviceID = 1; 
  private static final int leftDeviceID2 = 2;
  private static final int rightDeviceID2 = 3;
  private static final int rightDeviceID = 4;


  
  private CANSparkMax m_leftMotor_topSet;
  private CANSparkMax m_rightMotor_topSet;
  private CANSparkMax m_leftMotor_bottomSet;
  private CANSparkMax m_rightMotor_bottomSet;
  private DifferentialDrive m_myRobot;
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
    m_leftMotor_bottomSet = new CANSparkMax(leftDeviceID, MotorType.kBrushed);
    m_rightMotor_bottomSet = new CANSparkMax(rightDeviceID, MotorType.kBrushed);

    /**
     * The RestoreFactoryDefaults method can be used to reset the configuration parameters
     * in the SPARK MAX to their factory default state. If no argument is passed, these
     * parameters will not persist between power cycles
     */
    m_leftMotor_bottomSet.restoreFactoryDefaults();
    m_rightMotor_bottomSet.restoreFactoryDefaults();

    m_leftMotor_topSet = new CANSparkMax(leftDeviceID2, MotorType.kBrushed);
    m_rightMotor_topSet = new CANSparkMax(rightDeviceID2, MotorType.kBrushed);

    m_leftMotor_topSet.restoreFactoryDefaults();
    m_rightMotor_topSet.restoreFactoryDefaults();

   m_myRobot = new DifferentialDrive(m_leftMotor_bottomSet, m_rightMotor_bottomSet);

    m_stick = new GenericHID(0);
  }

  
  public void setTopMotors(double l, double r){
    m_leftMotor_topSet.set(l);
    m_rightMotor_topSet.set(r);
  }


  @Override
  public void teleopPeriodic() {
    m_myRobot.arcadeDrive(-m_stick.getRawAxis(4)*0.75, -m_stick.getRawAxis(1)*0.75);
    setTopMotors(m_leftMotor_bottomSet.get(), m_rightMotor_bottomSet.get());
  }
}
