package frc.robot.subsystems.solenoids;

import edu.wpi.first.wpilibj.Talon;

public class MotorControllerSolenoid implements SolenoidGroup {
    Talon motorController;

    public MotorControllerSolenoid(int canID) {
        this.motorController = new Talon(canID);
    }

    @Override
    public void set(boolean extended) {
        this.motorController.set(extended ? 1 : 0);
    }
    
}
