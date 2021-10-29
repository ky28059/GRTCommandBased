// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.tank;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tank.TankSubsystem;
import static frc.robot.Constants.*;

/**
 * A command to drive the Tank subsystem for a given distance
 */
public class DriveTankForDistanceCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final TankSubsystem tankSubsystem;

    private double yScale;
    private double angularScale;
    private boolean squareInput;
    private double distance;


    public DriveTankForDistanceCommand(TankSubsystem tankSubsystem, double meters, double yScale, double angularScale) {
        this(tankSubsystem, meters, yScale, angularScale, true);
    }

    public DriveTankForDistanceCommand(
        TankSubsystem tankSubsystem, double meters, 
        double yScale, double angularScale, boolean squareInput
    ) {
        super();

        this.tankSubsystem = tankSubsystem;

        addRequirements(tankSubsystem);

        this.yScale = yScale;
        this.angularScale = angularScale;
        this.squareInput = squareInput;
        this.distance = meters;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void initialize() {
        tankSubsystem.setLeftDisplacement(0);
        tankSubsystem.setRightDisplacement(0);
        tankSubsystem.setDrivePowers(yScale, angularScale, squareInput);
    }

    @Override
    public boolean isFinished() {
        // Finish if both encoders agree that the robot has travelled more than the required distance
        return tankSubsystem.getLeftDisplacement() * ENCODER_TICKS_TO_METERS > distance
            && tankSubsystem.getRightDisplacement() * ENCODER_TICKS_TO_METERS > distance;
    }

    @Override
    public void end(boolean interrupted) {
        tankSubsystem.setDrivePowers(0, 0, false);
    }
}
