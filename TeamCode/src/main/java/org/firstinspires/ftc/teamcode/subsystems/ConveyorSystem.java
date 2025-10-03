package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.sun.tools.javac.tree.DCTree;
import org.firstinspires.ftc.teamcode.routines.Routine;

public class ConveyorSystem extends Subsystem {

    private DcMotor conveyorMotor;
    private boolean isHold = false;
    private boolean isOn = false;

    public DcMotor getConveyorMotor() {
        return conveyorMotor;
    }

    public void toggleMotor(boolean clicked)
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
                getConveyorMotor().setPower(0);
                isOn = false;
            } else
            {
                getConveyorMotor().setPower(1);
                isOn = true;
            }
        }

    }



    public ConveyorSystem(Routine routine)
    {
        super(routine);
        conveyorMotor = routine.hardwareMap.get(DcMotor.class, "conveyor_motor");
        conveyorMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

}
