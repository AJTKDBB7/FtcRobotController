package org.firstinspires.ftc.teamcode.Class;

import static java.lang.Math.round;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ClassBench {
    public static double leftMotorPower, rightMotorPower, targetDistance, leftDistance, leftTargetDistance, rightDistance, rightTargetDistance;
    public static double leftTicks, rightTicks, targetTicks, wheelDiameter = 9, width = 30, power = 0.2, ticksPerRotation, wheelCircumference;
    public static double motorRatio = 28, gears = 1.6, cmPerTick, leftTargetTicks = 0, rightTargetTicks = 0, degree, internalRatio = 5.33 * 3.61;
    public static double targetDistanceAngle, targetTicksAngle;
    public static boolean done;
    public static DcMotor leftMotor, rightMotor, armMotor;

    public void init(HardwareMap hwMap) {
        leftMotor = hwMap.get(DcMotor.class, "left_motor");
        rightMotor = hwMap.get(DcMotor.class, "right_motor");
        armMotor = hwMap.get(DcMotor.class, "arm_motor");

        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void math() {
        wheelCircumference = Math.PI * wheelDiameter;
        ticksPerRotation = motorRatio * internalRatio * gears;
        cmPerTick = ticksPerRotation / wheelCircumference;

        degreeToTicks();
    }

    public void getPositions() {
        leftDistance = leftMotor.getCurrentPosition() * cmPerTick;
        rightDistance = rightMotor.getCurrentPosition() * cmPerTick;

        leftTicks = leftMotor.getCurrentPosition();
        rightTicks = rightMotor.getCurrentPosition();
    }

    public void degreeToTicks() {
        targetDistanceAngle = Math.PI * width / (360/degree);
        targetDistance = degree;
        targetTicks = targetDistance * cmPerTick;
        targetTicksAngle = targetDistanceAngle * cmPerTick;
    }

    public void move(ClassBench bench, int degrees, String direction) {
        resetMotors();
        done = false;

        degree = degrees;
        bench.math();

        if (direction.equals("straight")) {
            leftTargetTicks = targetTicks;
            rightTargetTicks = targetTicks;
        }
        else if (direction.equals("spinLeft")) {
            leftTargetTicks = -targetTicksAngle;
            rightTargetTicks = targetTicksAngle;
        }
        else if (direction.equals("spinRight")) {
            rightTargetTicks = -targetTicksAngle;
            leftTargetTicks = targetTicksAngle;
        }
        else if (direction.equals("pivotLeft")) {
            leftTargetTicks = targetTicksAngle * 2;
            rightTargetTicks = 0;
        }
        else if (direction.equals("pivotRight")) {
            leftTargetTicks = 0;
            rightTargetTicks = targetTicksAngle * 2;
        }

        leftMotorPower = power;
        rightMotorPower = power;

        startMoving();
    }

//    public void smooth() {
//        resetMotors();
//
//
//
//        startMoving();
//    }

    public void startMoving() {
        leftMotor.setTargetPosition((int)leftTargetTicks);
        rightMotor.setTargetPosition((int)rightTargetTicks);

        leftMotor.setPower(leftMotorPower);
        rightMotor.setPower(rightMotorPower);

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void resetMotors() {
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void resetArm() {
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}
