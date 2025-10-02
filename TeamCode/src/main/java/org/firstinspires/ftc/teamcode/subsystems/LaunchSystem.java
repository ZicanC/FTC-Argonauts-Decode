package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;


import org.firstinspires.ftc.teamcode.routines.Routine;

public class LaunchSystem extends Subsystem{
    private DcMotor launch_motor;

    private boolean holdingDown = false;
    public DcMotor getLaunch_motor() {
        return launch_motor;
    }


    public void moveOnTick(boolean start, boolean stop){
        double pow = 1;
        if(holdingDown){
            return;
        }
        if(start && !stop){
            getLaunch_motor().setPower(pow);
        }
        else{
            getLaunch_motor().setPower(0);
        }


    }
    


    public LaunchSystem(Routine routine) {
        super(routine);
        launch_motor = routine.hardwareMap.get(DcMotor.class, "launch_motor");



        launch_motor.setDirection(DcMotor.Direction.REVERSE);

        launch_motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
}
