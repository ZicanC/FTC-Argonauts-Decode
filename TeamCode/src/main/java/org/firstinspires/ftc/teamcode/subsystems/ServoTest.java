package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.routines.Routine;

public class ServoTest extends Subsystem{

    private CRServo servo1;
    private CRServo servo2;
    public CRServo getServo1()
    {
        return servo1;
    }

    public CRServo getServo2()
    {
        return servo2;
    }

    public void toggleServos(Boolean clicked)
    {
        if(clicked) {
            getServo1().setPower(1);
            getServo2().setPower(1);
        }
        else {
            getServo1().setPower(0);
            getServo2().setPower(0);
        }
    }
    public ServoTest(Routine routine)
    {
        super(routine);
        servo1 = routine.hardwareMap.get(CRServo.class, "servo_1");
        servo2 = routine.hardwareMap.get(CRServo.class, "servo2");
        servo2.setDirection(DcMotorSimple.Direction.REVERSE);

    }
}
