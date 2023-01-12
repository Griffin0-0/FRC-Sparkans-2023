# A script to set RoboRIO motors connected to spark max on CAN to 50% power


from rev import CANSparkMax
import wpilib

class MyRobot(wpilib.TimedRobot):
    def robotInit(self):
        self.motor = CANSparkMax(1, CANSparkMax.MotorType.kBrushless)
    def teleopPeriodic(self):
        self.motor.set(0.5)
