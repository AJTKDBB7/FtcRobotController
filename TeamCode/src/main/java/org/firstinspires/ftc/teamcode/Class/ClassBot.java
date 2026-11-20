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

    public void start() {
        bench.move(bench, 123, "straight");

        halt();
        bench.move(bench, 180, "spinLeft");
        halt();
        bench.move(bench, 123, "straight");
        halt();
    }

    @Override
    public void loop() {
        telemetry();
    }

    public void telemetry () {
        bench.getPositions();

        telemetry.addData("Elapsed Time", totalTime.time());
        telemetry.addData("Left Power", bench.leftMotorPower);
        telemetry.addData("Right Power", bench.rightMotorPower);
//        telemetry.addData("Target Distance", bench.targetDistance);
        telemetry.addData("Left Distance", bench.leftDistance);
        telemetry.addData("Right Distance", bench.rightDistance);
//        telemetry.addData("Target Ticks", bench.targetTicks);
        telemetry.addData("Left Ticks", bench.leftTicks);
        telemetry.addData("Right Ticks", bench.rightTicks);

        telemetry.addData("Left Target Ticks", bench.leftTargetTicks);
        telemetry.addData("Right Target Ticks", bench.rightTargetTicks);

        telemetry.update();
    }

    public void halt() {
        while (!bench.done) {
            telemetry();
            if (((bench.leftTicks >= bench.leftTargetTicks - 5) && (bench.leftTicks <= bench.leftTargetTicks + 5)) && ((bench.rightTargetTicks - 5 <= bench.rightTicks) && (bench.rightTargetTicks + 5 >= bench.rightTicks))) {
                bench.done = true;
            }

//            if ((bench.leftTicks > 200 || bench.rightTicks > 200) && ((bench.leftMotorPower < bench.power / 2 && bench.leftMotorPower > bench.power / 6) || (bench.rightMotorPower < bench.power / 2 && bench.rightMotorPower > bench.power / 6))) {
//
//                bench.leftMotorPower *= 2;
//                bench.rightMotorPower *= 2;
//
//                bench.leftMotor.setPower(bench.leftMotorPower);
//                bench.rightMotor.setPower(bench.rightMotorPower);
//            }
//            else if ((bench.leftTicks > 600 || bench.rightTicks > 600) && ((bench.leftMotorPower > bench.power / 2 && bench.leftMotorPower < bench.power) || (bench.rightMotorPower > bench.power / 2 && bench.rightMotorPower < bench.power))) {
//
//                bench.leftMotorPower *= 1.5;
//                bench.rightMotorPower *= 1.5;
//
//                bench.leftMotor.setPower(bench.leftMotorPower);
//                bench.rightMotor.setPower(bench.rightMotorPower);
//            }
        }
    }
}
