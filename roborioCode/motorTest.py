# A script to set RoboRIO motors connected to spark max on CAN to 50% power


from rev import CANSparkMax
import wpilib

MOTOR_TYPE = CANSparkMax.MotorType.kBrushed

class MyRobot(wpilib.TimedRobot):
    def robotInit(self):
        self.motor = CANSparkMax(1, MOTOR_TYPE)
    def teleopPeriodic(self):
        self.motor.set(0.5)
