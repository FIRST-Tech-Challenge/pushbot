package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/*
 * An example linear op mode where the pushbot
 * will drive in a square pattern using sleep()
 * and a for loop.
 */
@TeleOp(name = "PushBotSquare", group = "pushbot")
//@Disabled
// comment out the above line if you want this op mode to be enabled.
public class PushBotSquare extends LinearOpMode {
    DcMotor leftMotor;
    DcMotor rightMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        for(int i=0; i<4; i++) {
            leftMotor.setPower(0.5);
            rightMotor.setPower(0.5);

            telemetry.addData("i", i);
            telemetry.addData("leftPow", leftMotor.getPower());
            telemetry.addData("rightPow", rightMotor.getPower());
            telemetry.update();

            sleep(1000);

            leftMotor.setPower(0.25);
            rightMotor.setPower(-0.25);

            telemetry.addData("i", i);
            telemetry.addData("leftPow", leftMotor.getPower());
            telemetry.addData("rightPow", rightMotor.getPower());
            telemetry.update();

            sleep(750);
        }

        //leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        //rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

    }
}
