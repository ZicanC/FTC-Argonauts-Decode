package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.routines.Routine;

public class servoTest extends Subsystem{

    private CRServo servo1;
    private CRServo servo2;
    private boolean isOn;
    private boolean wasPressed;
    public CRServo getServo1()
    {
        return servo1;
    }

    public CRServo getServo2()
    {
        return servo2;
    }
    public void setWasPressed(boolean value)
    {
        this.wasPressed = value;
    }
    public boolean getIsOn()
    {
        return isOn;
    }
    public void setIsOn(boolean value)
    {
        this.isOn = value;
    }

    public void toggleServos(Boolean clicked)
    {

        if (clicked && !getIsOn()) {
            setIsOn(!getIsOn());
        }

        setWasPressed(clicked);

        if (getIsOn()) {
            getServo1().setPower(0.1);
            getServo2().setPower(0.1);
        } else {
            getServo1().setPower(0.0);
            getServo1().setPower(0.0);
        }
    }

    public servoTest(Routine routine)
    {
        super(routine);
        servo1 = routine.hardwareMap.get(CRServo.class, "servo_1");
        servo2 = routine.hardwareMap.get(CRServo.class, "servo2");
        servo2.setDirection(DcMotorSimple.Direction.REVERSE);

    }
}
