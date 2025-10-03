package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.teamcode.routines.Routine;

public class LaunchSystem extends Subsystem{
    private DcMotor launch_motor;

    private boolean isHold = false;
    private boolean isOn = false;
    public DcMotor getLaunch_motor() {
        return launch_motor;
    }


    public void moveOnTick(boolean clicked){
        if(!isHold && clicked)
        {
            isHold = true;
        }
        else if(isHold && !clicked)
        {
            isHold = false;
            if(isOn)
            {
                getLaunch_motor().setPower(0);
                isOn = false;
            } else
            {
                getLaunch_motor().setPower(1);
                isOn = true;
            }
        }


    }



    public LaunchSystem(Routine routine) {
        super(routine);
        launch_motor = routine.hardwareMap.get(DcMotor.class, "launch_motor");
        launch_motor.setDirection(DcMotor.Direction.REVERSE);

        launch_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
}
