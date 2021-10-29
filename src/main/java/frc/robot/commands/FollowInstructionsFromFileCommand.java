// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.tank.TankSubsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//import java.io.IOException;
import java.io.FileNotFoundException;

/** A command to read instructions from a txt file and execute them */
public class FollowInstructionsFromFileCommand extends SequentialCommandGroup {
    private final static String COMMAND_PATH = "commands.txt";

    /**
     * Creates a new FollowInstructionsFromFileCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public FollowInstructionsFromFileCommand(TankSubsystem tankSubsystem) {
        // Read command file
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(new File(Filesystem.getDeployDirectory(), COMMAND_PATH)));
        } catch (FileNotFoundException e) {
            System.out.println("[ERR] commands.txt not found");
            return;
        }

        // Debug print commands
        br.lines().forEach(System.out::println);

        addCommands(
            // do something quirky here
            // maybe do something else quirky
        );
    }
}
