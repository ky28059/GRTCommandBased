package frc.robot.subsystems.solenoids;

import edu.wpi.first.wpilibj.Solenoid;

public class PCMSolenoid implements SolenoidGroup {
    Solenoid solenoid;

    public PCMSolenoid(int pcmChannel) {
        this.solenoid = new Solenoid(pcmChannel);
    }

    @Override
    public void set(boolean extended) {
        solenoid.set(extended);
    }
}
