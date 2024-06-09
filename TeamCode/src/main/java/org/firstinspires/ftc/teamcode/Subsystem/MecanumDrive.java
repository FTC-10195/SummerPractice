package org.firstinspires.ftc.teamcode.Subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDrive {
    DcMotor frontLeftMotor;
    DcMotor backLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backRightMotor;
    public MecanumDrive(HardwareMap hardwareMap) {
        // Declare our motors
        // Make sure your ID's match your configuration
        frontLeftMotor = hardwareMap.dcMotor.get("motor0");
        backLeftMotor = hardwareMap.dcMotor.get("motor2");
        frontRightMotor = hardwareMap.dcMotor.get("motor1");
        backRightMotor = hardwareMap.dcMotor.get("motor3");
        // Reverse the right side motors. This may be wrong for your setup.
        // If your robot moves backwards when commanded to go forwards,
        // reverse the left side instead.
        // See the note about this earlier on this page.
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
public void move(double y, double x, double rx){
    // Denominator is the largest motor power (absolute value) or 1
    // This ensures all the powers maintain the same ratio,
    // but only if at least one is out of the range [-1, 1]
    double sensitivity = .5;
    double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
    double frontLeftPower = ((y + x + rx) / denominator)*sensitivity;
    double backLeftPower = ((y - x + rx) / denominator)*sensitivity;
    double frontRightPower = ((y - x - rx) / denominator)*sensitivity;
    double backRightPower = ((y + x - rx) / denominator)*sensitivity;
    frontLeftMotor.setPower(frontLeftPower);
    backLeftMotor.setPower(backLeftPower);
    frontRightMotor.setPower(frontRightPower);
    backRightMotor.setPower(backRightPower);
}
}
