package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystem.MecanumDrive;
import org.firstinspires.ftc.teamcode.Subsystem.Arm;

@TeleOp
public class TeleOpBasic extends LinearOpMode {
    // Declare our motors
    // Make sure your ID's match your configuration
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(hardwareMap);
       // Arm arm = new Arm(hardwareMap);1
        Gamepad currentGamepad1 = new Gamepad();
        Gamepad currentGamepad2 = new Gamepad();

        Gamepad previousGamepad1 = new Gamepad();
        Gamepad previousGamepad2 = new Gamepad();
    waitForStart();
        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;
            previousGamepad1.copy(currentGamepad1);
            previousGamepad2.copy(currentGamepad2);
            currentGamepad1.copy(gamepad1);
            currentGamepad2.copy(gamepad2);
            if (currentGamepad1.left_bumper && !previousGamepad1.left_bumper) {
             //   arm.rotate(.1f);
            }
            if (!currentGamepad1.right_bumper && previousGamepad1.right_bumper) {
            //    arm.rotate(-.1f);
            }
            drive.move(y,x,rx);
        }
    }
}