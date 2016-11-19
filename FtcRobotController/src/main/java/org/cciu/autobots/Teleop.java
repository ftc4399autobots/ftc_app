package org.cciu.autobots;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Student on 11/4/2016.
 */
@TeleOp(name="Drive")
public class Teleop extends OpMode {

    DcMotor leftTop;
    DcMotor leftBottom;
    DcMotor rightTop;
    DcMotor rightBottom;
    DcMotor scoop;

    @Override
    public void init() {
        leftTop = hardwareMap.dcMotor.get("leftTop");
        leftBottom = hardwareMap.dcMotor.get("leftBottom");
        rightTop = hardwareMap.dcMotor.get("rightTop");
        rightBottom = hardwareMap.dcMotor.get("rightBottom");
        leftTop.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBottom.setDirection(DcMotorSimple.Direction.REVERSE);
        scoop = hardwareMap.dcMotor.get("scoop");
    }

    @Override
    public void loop() {
        leftTop.setPower(gamepad1.right_stick_y);
        leftBottom.setPower(gamepad1.right_stick_y);

        rightTop.setPower(gamepad1.left_stick_y);
        rightBottom.setPower(gamepad1.left_stick_y);

        if(gamepad1.right_trigger > 0.23) {
            scoop.setPower(gamepad1.right_trigger);
        } else if (gamepad1.left_trigger > 0.23) {
            scoop.setPower(gamepad1.left_trigger * -1);
        } else {
            scoop.setPower(0);
        }
      //  scoop.setPower(gamepad1.right_trigger);
    }
}
