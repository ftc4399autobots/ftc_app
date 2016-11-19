package org.cciu.autobots;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Student on 11/7/2016.
 */
@Autonomous(name="Autonomous")
public class Autonomus extends LinearOpMode {
    DcMotor leftTop;
    DcMotor leftBottom;
    DcMotor rightTop;
    DcMotor rightBottom;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        leftTop = hardwareMap.dcMotor.get("leftTop");
        leftBottom = hardwareMap.dcMotor.get("leftBottom");
        rightTop = hardwareMap.dcMotor.get("rightTop");
        rightBottom = hardwareMap.dcMotor.get("rightBottom");
        leftTop.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBottom.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();

        leftTop.setPower(0);
        leftBottom.setPower(0);
        rightTop.setPower(0);
        rightBottom.setPower(0);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 10)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }

        leftTop.setPower(-1);
        leftBottom.setPower(-1);
        rightTop.setPower(-1);
        rightBottom.setPower(-1);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.3)) {
            telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        leftTop.setPower(-1);
        leftBottom.setPower(-1);
        rightTop.setPower(0.8);
        rightBottom.setPower(0.8);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.25)) {
            telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        leftTop.setPower(-1);
        leftBottom.setPower(-1);
        rightTop.setPower(-1);
        rightBottom.setPower(-1);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.3)) {
            telemetry.addData("Path", "Leg 4: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
    }
}
