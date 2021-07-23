package frc.robot.commands.swerve;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SwerveSubsystem;
import frc.util.Point;

public class PurePursuitCommand extends CommandBase {
    private final SwerveSubsystem swerveSubsystem;
    private final Point[] controlPoints;

    // Constants
    private static final int FOLLOW_RADIUS = 25; // TODO tune
    private static final int STOP_RADIUS = 1;

    // Helpers
    private int followIndex; // the control point we are moving towards

    public PurePursuitCommand(SwerveSubsystem swerveSubsystem, Point[] controlPoints) { // TODO add parameters
        this.swerveSubsystem = swerveSubsystem;
        this.controlPoints = controlPoints;

        this.followIndex = 1;

        addRequirements(swerveSubsystem);
    }

    public void execute() {
        // Find intersections
        Point pursue = findPursuePoint();
    }

    private Point findPursuePoint() {
        Point currentPosition = swerveSubsystem.getCurrentPosition();

        // Search this path and the next one for an intersection
        // for the furthest intersection between the radius around the robot, and the path.
        for (int i = followIndex; i < Math.min(followIndex + 2, controlPoints.length); i++) {
            
        }

        return new Point(); // TODO stub
    }
}
