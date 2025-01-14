// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.elevator.ElevatorSubsystem;

/**
 * Add your docs here.
 */
public class ElevatorUpCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final ElevatorSubsystem elevatorSubsystem;

    public ElevatorUpCommand(ElevatorSubsystem elevatorSubsystem) { // TODO add parameters
        this.elevatorSubsystem = elevatorSubsystem;

        addRequirements(elevatorSubsystem);
    }

    // TODO

    @Override
    public void initialize() {
        elevatorSubsystem.elevatorUpCommand(); // TODO: add parameters whenever the method is fixed
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
