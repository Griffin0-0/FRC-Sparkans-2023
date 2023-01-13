# A script to set RoboRIO motors connected to spark max on CAN to 20% power


from rev import CANSparkMax
import wpilib

MOTOR_TYPE = CANSparkMax.MotorType.kBrushed

class MyRobot(wpilib.TimedRobot):
    def robotInit(self):
        self.motor = CANSparkMax(3, MOTOR_TYPE)
        self.motor1 = CANSparkMax(4, MOTOR_TYPE)
    def teleopPeriodic(self):
        self.motor.set(0.2)
        self.motor1.set(0.2)
