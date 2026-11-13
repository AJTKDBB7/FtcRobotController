package org.firstinspires.ftc.teamcode.Class;

import static java.lang.Math.round;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ClassBench {
    public static double leftMotorPower, rightMotorPower, targetDistance, leftDistance, leftTargetDistance, rightDistance, rightTargetDistance;
    public static double leftTicks, rightTicks, targetTicks, wheelDiameter = 9, width = 30, power = 0.6, ticksPerRotation, wheelCircumference;
    public static double motorRatio = 28, gears = 1.6, cmPerTick, leftTargetTicks, rightTargetTicks, degree;
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
        ticksPerRotation = motorRatio * 5.33 * 3.61 * gears;
        cmPerTick = ticksPerRotation / wheelCircumference;
        targetTicks = targetDistance * cmPerTick;

        leftDistance = leftMotor.getCurrentPosition() * cmPerTick;
        rightDistance = rightMotor.getCurrentPosition() * cmPerTick;

        leftTicks = leftMotor.getCurrentPosition();
        rightTicks = rightMotor.getCurrentPosition();
    }

    public void straight(ClassBench bench, int distance) {

        targetDistance = distance;
        bench.math();

        leftTargetTicks = targetTicks;
        rightTargetTicks = targetTicks;

        leftMotor.setTargetPosition((int)leftTargetTicks);
        rightMotor.setTargetPosition((int)rightTargetTicks);

        leftMotor.setPower(power);
        rightMotor.setPower(power);

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void spin(ClassBench bench, int degrees) {

        degree = degrees;
        bench.math();



    }
}
