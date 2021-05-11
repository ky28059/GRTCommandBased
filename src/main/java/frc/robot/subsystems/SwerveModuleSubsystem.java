// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SwerveModuleSubsystem extends SubsystemBase {
  private String name;
  private double x;
  private double y;
  
  public SwerveModuleSubsystem(String name, double x, double y) {   //x and y is where each swerve module is in respect to the center of the drive train
    this.name = name;
    this.x = x;
    this.y = y;
    CommandScheduler.getInstance().registerSubsystem(this);

  }


  public void set(double rad, double speed ){
      //tells motors where to turn and at what speed to turn

  }

  public String getName(){  //getter functions
    return name;
  }

  public double getX(){
    return x;
  }

  public double getY(){
    return y;
  }
  

}

  
