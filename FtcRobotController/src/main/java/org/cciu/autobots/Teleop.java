package org.cciu.autobots;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Student on 11/4/2016.
 */

public class Teleop extends OpMode {

    DcMotor leftTop;
    DcMotor leftBottom;
    DcMotor rightTop;
    DcMotor rightBottom;

    @Override
    public void init() {
        leftTop = hardwareMap.dcMotor.get("leftTop");
        leftBottom = hardwareMap.dcMotor.get("leftBottom");
        rightTop = hardwareMap.dcMotor.get("rightTop");
        rightBottom = hardwareMap.dcMotor.get("rightBottom");
    }

    @Override
    public void loop() {
        leftTop.setPower(gamepad1.left_stick_y);
        leftBottom.setPower(gamepad1.left_stick_y);

        rightTop.setPower(gamepad1.right_stick_y);
        rightBottom.setPower(gamepad1.right_stick_y);
    }
}
