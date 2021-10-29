// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.tank;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tank.TankSubsystem;

/**
 * A command to drive the Tank subsystem for a given timeout
 */
public class DriveTankForTimeoutCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final TankSubsystem tankSubsystem;
    private final Timer timer;

    private double yScale;
    private double angularScale;
    private boolean squareInput;
    private double seconds;


    public DriveTankForTimeoutCommand(TankSubsystem tankSubsystem, double seconds, double yScale, double angularScale) {
        this(tankSubsystem, seconds, yScale, angularScale, true);
    }

    public DriveTankForTimeoutCommand(
        TankSubsystem tankSubsystem, double seconds, 
        double yScale, double angularScale, boolean squareInput
    ) {
        super();

        this.tankSubsystem = tankSubsystem;
        this.timer = new Timer();

        addRequirements(tankSubsystem);

        this.yScale = yScale;
        this.angularScale = angularScale;
        this.squareInput = squareInput;
        this.seconds = seconds;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void initialize() {
        tankSubsystem.setDrivePowers(yScale, angularScale, squareInput);
        timer.start();
    }

    @Override
    public boolean isFinished() {
        // Finish if the desired time has elapsed
        return timer.hasElapsed(seconds);
    }

    @Override
    public void end(boolean interrupted) {
        tankSubsystem.setDrivePowers(0, 0, false);
    }
}
