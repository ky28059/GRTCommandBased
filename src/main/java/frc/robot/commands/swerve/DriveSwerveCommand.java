// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.swerve;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveSubsystem;


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
  public DriveSwerveCommand(SwerveSubsystem swerveSubsystem) { // TODO: add parameters whenever swerveSubsystem.setDrivePowers() is finished.
    this.swerveSubsystem = swerveSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(swerveSubsystem);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void initialize() {
    swerveSubsystem.setDrivePowers(); // TODO: add parameters whenever the method is fixed
  }

  @Override
  public boolean isFinished() {
    return true;
  }

  public void Drive (){ //not yet called
    //recieve data to turn wheels and change speed from swerve subsystem

  }
  public XboxController(double joystickInp){
    //take input from one joystick for speed
    //take input from the other joystick for direction
    //profile these values
    //use these profiled values to set target value and target speed
    //send targetpos values to the swervesubsystem
    //send targetspeed value to swervesubsystem                                  
  }

  private JoystickProfile(){ 
    //cut out deadband and send the numbers to XboxController                      

  }

}
