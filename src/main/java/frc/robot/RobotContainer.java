// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ExampleAutoCommand;
import frc.robot.subsystems.IntervalSolenoid;
import frc.robot.subsystems.solenoids.DelaySolenoids;
import frc.robot.subsystems.solenoids.MotorControllerSolenoid;
import frc.robot.subsystems.solenoids.PCMSolenoid;
import frc.robot.subsystems.solenoids.ParallelSolenoids;
import frc.robot.subsystems.solenoids.RepeaterSolenoids;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final IntervalSolenoid tylerMech = new IntervalSolenoid(new MotorControllerSolenoid(0), 0, 20, 5);

  private final IntervalSolenoid ethanMech = new IntervalSolenoid(new MotorControllerSolenoid(1), 0, 10, 5);

  private final IntervalSolenoid roMech = new IntervalSolenoid(new MotorControllerSolenoid(2), 0, 10, 5);

  private final IntervalSolenoid mattyMech = new IntervalSolenoid(
      new DelaySolenoids(new MotorControllerSolenoid(12), new MotorControllerSolenoid(13), 1), 0, 8, 5);

  private final IntervalSolenoid alexMech = new IntervalSolenoid(
      new ParallelSolenoids(new MotorControllerSolenoid(14), new MotorControllerSolenoid(15)), 0, 20, 4);

  private final IntervalSolenoid lucyMech = new IntervalSolenoid(new MotorControllerSolenoid(3), 0, 7, 20);

  private final IntervalSolenoid aarushMech = new IntervalSolenoid(
      new ParallelSolenoids(new PCMSolenoid(0), new RepeaterSolenoids(new PCMSolenoid(1), 3)), 0, 30, 12);

  private final ExampleAutoCommand autoCommand = new ExampleAutoCommand();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autoCommand;
  }
}
