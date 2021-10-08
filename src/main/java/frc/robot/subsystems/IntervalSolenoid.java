package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.solenoids.SolenoidGroup;

public class IntervalSolenoid extends SubsystemBase {
    SolenoidGroup solenoids;

    int period;
    int startupDelay;
    int holdDuration;

    boolean firstLoop;
    boolean hasStarted;

    Timer timer;

    boolean extended;

    public IntervalSolenoid(SolenoidGroup solenoids, 
            int startupDelay, int period, int holdDuration) {
        this.period = period;
        this.startupDelay = startupDelay;
        this.holdDuration = holdDuration;

        this.solenoids = solenoids;

        this.firstLoop = false;

        this.timer = new Timer();

        this.extended = false;
        this.solenoids.set(extended);
    }

    public void periodic() {
        if (!firstLoop) {
            timer.start();
        }

        if (!hasStarted && timer.hasElapsed(startupDelay)) {
            timer.reset();
            hasStarted = true;
        }

        if (hasStarted) {
            if (extended && timer.hasElapsed(holdDuration)) {
                extended = false;
                solenoids.set(false);
                timer.reset();
            } else if (!extended && timer.hasElapsed(period)) {
                extended = true;
                solenoids.set(true);
                timer.reset();
            }
        }
    }
}
