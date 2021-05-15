// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.swerve;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveSubsystem;
import frc.input.Controllers;
import frc.input.JoystickProfile;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/** An example command that uses an example subsystem. */
public class DriveSwerveCommand extends CommandBase {
  public double targetPos;
  public double currentPos;

  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final SwerveSubsystem swerveSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param swerveSubsystem The subsystem used by this command.
   */
  public DriveSwerveCommand(SwerveSubsystem swerveSubsystem) { // TODO: add parameters whenever
                                                               // swerveSubsystem.setDrivePowers() is finished.
    this.swerveSubsystem = swerveSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(swerveSubsystem);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void initialize() {
  } // intentionally left empty because we don't need to initialize anything

  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public void execute() {
    double vX = Controllers.SWERVE_XBOX.getX(Hand.kLeft); // taking input from controllers x velocity
    double vY = Controllers.SWERVE_XBOX.getY(Hand.kLeft);
    double vAng = Controllers.SWERVE_XBOX.getTriggerAxis(Hand.kRight)
        - Controllers.SWERVE_XBOX.getTriggerAxis(Hand.kLeft); // subtracting trigger to see which way to turn
    vX = JoystickProfile.applyProfile(vX);
    vY = JoystickProfile.applyProfile(vY);
    vAng = JoystickProfile.applyProfile(vAng);
    swerveSubsystem.set(vX, vY, vAng);
  }

}
