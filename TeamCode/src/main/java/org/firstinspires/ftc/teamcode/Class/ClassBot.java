package org.firstinspires.ftc.teamcode.Class;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class ClassBot extends OpMode {

    ClassBench bench = new ClassBench();

    @Override
    public void init() {
        bench.move();
    }

    @Override
    public void loop() {
        ElapsedTime time = new ElapsedTime();

        telemetry.addData("Elapsed Time", time);
        telemetry.addData("Left Motor", bench.leftMotorPower);
        telemetry.addData("Right Motor", bench.rightMotorPower);
        telemetry.addData("", bench.);
    }
}
