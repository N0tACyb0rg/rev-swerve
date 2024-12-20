package frc.robot.subsystems.module;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import frc.robot.Constants.MotorConstants;

public class SwerveModule {
  private final SparkFlex driveMotor;
  private final SparkMax angleMotor;

  private final RelativeEncoder driveEncoder;
  private final AbsoluteEncoder angleEncoder;

  private final SparkClosedLoopController driveController;
  private final SparkClosedLoopController angleController;

  public SwerveModule(int index) {
    switch (index) {
      case 0:
        driveMotor = new SparkFlex(MotorConstants.FL_DRIVE, MotorType.kBrushless);
        angleMotor = new SparkMax(MotorConstants.FL_ANGLE, MotorType.kBrushless);
        break;
      case 1:
        driveMotor = new SparkFlex(MotorConstants.FR_DRIVE, MotorType.kBrushless);
        angleMotor = new SparkMax(MotorConstants.FR_ANGLE, MotorType.kBrushless);
        break;
      case 2:
        driveMotor = new SparkFlex(MotorConstants.RL_DRIVE, MotorType.kBrushless);
        angleMotor = new SparkMax(MotorConstants.RL_ANGLE, MotorType.kBrushless);
        break;
      case 3:
        driveMotor = new SparkFlex(MotorConstants.RR_DRIVE, MotorType.kBrushless);
        angleMotor = new SparkMax(MotorConstants.RR_ANGLE, MotorType.kBrushless);
        break;
      default:
        throw new IllegalArgumentException("Index must be in range 0-3.");
    }

    driveEncoder = driveMotor.getEncoder();
    angleEncoder = angleMotor.getAbsoluteEncoder();

    driveController = driveMotor.getClosedLoopController();
    angleController = angleMotor.getClosedLoopController();
  }
}

