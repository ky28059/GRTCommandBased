// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.swerve.FollowPathCommand;
import frc.robot.subsystems.SwerveSubsystem;

import java.io.BufferedReader;
import java.io.FileReader;
//import java.io.IOException;
import java.io.FileNotFoundException;

/** A command to read instructions from a txt file and execute them */
public class FollowInstructionsFromFileCommand extends SequentialCommandGroup {
    /**
     * Creates a new FollowInstructionsFromFileCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public FollowInstructionsFromFileCommand(SwerveSubsystem swerveSubsystem) throws FileNotFoundException {
        // Read command file
        BufferedReader br = new BufferedReader(new FileReader("commands.txt"));
        br.lines().forEach(System.out::println);

        addCommands(
            new FollowPathCommand(swerveSubsystem),
            // do something quirky here
            new FollowPathCommand(swerveSubsystem) // follow another path
            // maybe do something else quirky
        );
    }
}
