// - Fix gear ratios to be more exact
// - Finish moveType switch cases
package org.firstinspires.ftc.teamcode.Class;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ClassBench {
    public static double leftMotorPower, rightMotorPower, targetDistance = 123, leftDistance, leftTargetDistance, rightDistance, rightTargetDistance;
    public static double leftTicks, rightTicks, targetTicks, wheelDiameter = 9, width = 30, power = 0.6, ticksPerRotation, wheelCircumference;
    public static double motorRatio, gears = 1.6, cmPerTick;
    public static String moveType = "straight";
    public static DcMotor leftMotor, rightMotor, armMotor;

    public void init(HardwareMap hwMap) {
        leftMotor = hwMap.get(DcMotor.class, "left_motor");
        rightMotor = hwMap.get(DcMotor.class, "right_motor");
        armMotor = hwMap.get(DcMotor.class, "arm_motor");

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public static void math() {
        wheelCircumference = Math.PI * 9;
        ticksPerRotation = 28 * 5 * 4 * 1.6;
        cmPerTick = ticksPerRotation / wheelCircumference;

        leftDistance = leftMotor.getCurrentPosition() * cmPerTick;
        rightDistance = rightMotor.getCurrentPosition() * cmPerTick;

        leftTicks = leftMotor.getCurrentPosition();
        rightTicks = rightMotor.getCurrentPosition();
    }

    public static void move() {
        while (leftDistance < leftTargetDistance || rightDistance < rightTargetDistance) {
            switch (moveType) {
                case "straight":
                    leftMotorPower = power;
                    rightMotorPower = power;
                    leftTargetDistance = targetDistance;
                    rightTargetDistance = targetDistance;
                    break;
//            case "spin left":
//                leftMotorPower = -power;
//                rightMotorPower = power;
//                break;
//            case "spin right":
//                leftMotorPower = power;
//                rightMotorPower = -power;
//                break;
//            case "pivot left":
//                leftMotorPower = 0;
//                rightMotorPower = power;
//                break;
//            case "pivot right":
//                leftMotorPower = power;
//                rightMotorPower = 0;
//                break;
//            case "smooth left":
//                leftMotorPower = 0.6;
//                rightMotorPower = 0;
//                break;
//            case "smooth right":
//                leftMotorPower = 0.6;
//                rightMotorPower = 0;
//                break;
            }

        }

        leftMotor.setPower(leftMotorPower);
        rightMotor.setPower(rightMotorPower);

        while (leftMotorPower != 0 || rightMotorPower != 0) {
            if (leftDistance < leftTargetDistance) {
                leftMotor.setPower(0);
            }
            if (rightDistance < rightTargetDistance) {
                rightMotor.setPower(0);
            }
        }

    }
}
