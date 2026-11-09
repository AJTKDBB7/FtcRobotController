package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class ArcadeDrive {

    private DcMotor leftMotor, rightMotor;

    public void init (HardwareMap hwMap) {
        leftMotor = hwMap.get(DcMotor.class, "Left_Motor");
        rightMotor = hwMap.get(DcMotor.class, "Right_Motor");

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void drive(double throttle, double spin) {
        double leftPower = throttle + spin;
        double rightPower = throttle - spin;
        double largest = Math.max(Math.abs(leftPower), Math.abs(rightPower));

        if (largest > 1) {
            leftPower /= largest;
            rightPower /= largest;
        }

        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }
}
