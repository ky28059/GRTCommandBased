// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.sensors.NavXGyro;
import frc.util.Point;

public class SwerveSubsystem extends SubsystemBase {
  private static final double LENGTH = 22.25;
  private static final double WIDTH = 21.70;
  private SwerveModuleSubsystem[] wheels;
  private NavXGyro gyro;

  public SwerveSubsystem() {
    CommandScheduler.getInstance().registerSubsystem(this);
    wheels = new SwerveModuleSubsystem[4];
    wheels[0] = new SwerveModuleSubsystem("fr", WIDTH / 2, LENGTH / 2);
    wheels[1] = new SwerveModuleSubsystem("fl", -WIDTH / 2, LENGTH / 2);
    wheels[2] = new SwerveModuleSubsystem("br", WIDTH / 2, -LENGTH / 2);
    wheels[3] = new SwerveModuleSubsystem("bl", -WIDTH / 2, -LENGTH / 2);
    gyro = new NavXGyro();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  /**
   * set swerve's translational and angular velocity
   * 
   * @param xVeloc   the x component of the translational velocity (number from -1
   *                 to 1)
   * @param yVeloc   the y component of the translational velocity (number from -1
   *                 to 1)
   * @param angVeloc the angular velocity (radians per sec)
   */
  public void set(double xVeloc, double yVeloc, double angVeloc) {
    // sending info to swerve modules on how they should turn
    double wheelVX;
    double wheelVY;
    double wheelSpeed;
    double wheelDirection;
    double gyroAngle = gyro.getAngle();
    double wheelAngRelCent;
    double wheelDistFromCent;

    for (SwerveModuleSubsystem wheel : wheels) {
      wheelAngRelCent = Math.atan(wheel.getY() / wheel.getX()) + gyroAngle;
      wheelDistFromCent = Math.sqrt((wheel.getY() * wheel.getY()) + (wheel.getX() * wheel.getX()));
      wheelVX = xVeloc + (angVeloc * wheelDistFromCent * Math.sin(wheelAngRelCent));
      wheelVY = yVeloc + (angVeloc * wheelDistFromCent * Math.cos(wheelAngRelCent));
      wheelSpeed = Math.sqrt((wheelVX * wheelVX) + (wheelVY * wheelVY));
      wheelDirection = Math.atan(wheelVY / wheelVX);
    }
  } // TODO

  public Point getCurrentPosition() {
    return new Point(); // todo stub
  }
}
