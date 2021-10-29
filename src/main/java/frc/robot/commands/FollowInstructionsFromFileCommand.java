// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.tank.DriveTankCommand;
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
     * Creates a new FollowInstructionsFromFileCommand which reads commands.txt and adds TankSubsystem
     * commands based on the instructions given in the file.
     * 
     * Valid commands:
     * forward/backward xm/s - moves the robot forward or backwards x meters (if m) or for x seconds (if s)
     * turn left/right x - turns the robot clockwise or counterclockwise x degrees
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
        //br.lines().forEach(System.out::println);

        // Add instructions as commands
        br.lines().forEach((instr) -> {
            String[] args = instr.split(" ");

            if (args[0].equals("turn")) { // Turn command
                double angularScale = Double.parseDouble(args[2]) / 360; // convert degrees to scale from [0, 1]

                if (args[1].equals("left")) // flip from clockwise to counterclockwise if turning left
                    angularScale = -angularScale;
                
                addCommands(new DriveTankCommand(tankSubsystem, 0, angularScale));
            } else { // Move command
                int num = Integer.parseInt(args[1].substring(0, args[1].length() - 1));

                //if (args[1].endsWith("m")) 

                //addCommands(new DriveTankCommand(tankSubsystem, yScale, 0));
            }
        });

        addCommands(
            // do something quirky here
            // maybe do something else quirky
        );
    }
}
