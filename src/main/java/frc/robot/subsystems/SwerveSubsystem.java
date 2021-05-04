// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveSubsystem extends SubsystemBase {
  public SwerveSubsystem() {
    CommandScheduler.getInstance().registerSubsystem(this);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //Wheel(name);        //TODO name wheels
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void setDrivePowers() {} // TODO

  public void Wheel (String name){ //Contructor to create the wheels of the robot
    //set Talon SRX and Spark Max for each wheel
    //set encoder/ticks 
    //set speed
    //set starting position
    //swerve status
  }

  public double calculatePID(double startingPos, targetPos){
    //take starting position and calculate how much to turn to target position (reverse direction of wheel if needed)
    //return how much to turn AND if the direction of the wheel needs to be reversed

  }
}

  
