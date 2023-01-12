# A script to set RoboRIO motors connected to spark max on port 4 to 50% power

import wpilib
from wpilib import PWMSparkMax

class MyRobot(wpilib.TimedRobot):
    def robotInit(self):
        self.motor = PWMSparkMax(4)

    def teleopPeriodic(self):
        self.motor.set(0.5)