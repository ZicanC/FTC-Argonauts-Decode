package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.routines.Routine;

public class IntakeServo extends Subsystem{

    private CRServo intakeServo;
    private boolean isHold = false;
    private boolean isOn = false;
    public CRServo getServo()
    {
        return intakeServo;
    }

    public void toggleServos(Boolean clicked)
    {
        if(!isHold && clicked)
        {
            isHold = true;
        }
        else if(isHold && !clicked)
        {
            isHold = false;
            if(isOn)
            {
                getServo().setPower(0);
                isOn = false;
            } else
            {
                getServo().setPower(1);
                isOn = true;
            }
        }
    }
    public IntakeServo(Routine routine)
    {
        super(routine);
        intakeServo = routine.hardwareMap.get(CRServo.class, "intake_servo");

    }
}
