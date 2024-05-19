package org.firstinspires.ftc.teamcode.Subsystem;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {
    Servo leftServo;
    Servo rightServo;
    public Arm(HardwareMap hardwareMap){
        leftServo = hardwareMap.get(Servo.class, "LeftServo");
        rightServo = hardwareMap.get(Servo.class, "RightServo");
        rightServo.setDirection(Servo.Direction.REVERSE);
    }
    public void rotate(float position){
        leftServo.setPosition(leftServo.getPosition() + position);
        rightServo.setPosition(rightServo.getPosition() + position);
    }
}
