package org.firstinspires.ftc.teamcode.Class;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class ClassBot extends OpMode {

    ClassBench bench = new ClassBench();
    ElapsedTime totalTime = new ElapsedTime();

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {

        bench.straight(bench, 123);

        telemetry.addData("Elapsed Time", totalTime.time());
        telemetry.addData("Left Motor", bench.leftMotorPower);
        telemetry.addData("Right Motor", bench.rightMotorPower);
        telemetry.addData("Target Distance", bench.targetDistance);
        telemetry.addData("Left Distance", bench.leftDistance);
        telemetry.addData("Right Distance", bench.rightDistance);
        telemetry.addData("Target Ticks", bench.targetTicks);
        telemetry.addData("Left Ticks", bench.leftTicks);
        telemetry.addData("Right Ticks", bench.rightTicks);

        telemetry.addData("Left Target Ticks", bench.leftTargetTicks);
        telemetry.addData("Right Target Ticks", bench.rightTargetTicks);
    }
}
