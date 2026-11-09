package org.firstinspires.ftc.teamcode.Class;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class ClassBot extends OpMode {

    ClassBench bench = new ClassBench();

    @Override
    public void init() {
    }

    @Override
    public void loop() {
        ElapsedTime ElapsedTime = new ElapsedTime();

        bench.math();

        bench.move();
        telemetry.addData("Elapsed Time", ElapsedTime);
        telemetry.addData("Left Motor", bench.leftMotorPower);
        telemetry.addData("Right Motor", bench.rightMotorPower);
        telemetry.addData("Target Distance", bench.targetDistance);
        telemetry.addData("Left Distance", bench.leftDistance);
        telemetry.addData("Right Distance", bench.rightDistance);
        telemetry.addData("Target Ticks", bench.targetTicks);
        telemetry.addData("Left Ticks", bench.leftTicks);
        telemetry.addData("Right Ticks", bench.rightTicks);
    }
}
