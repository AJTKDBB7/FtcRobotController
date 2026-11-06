package org.firstinspires.ftc.teamcode.Class;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class ClassBot extends OpMode {

    @Override
    public void init() {
        ClassBench.move();
    }

    @Override
    public void loop() {

    }
}
