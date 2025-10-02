package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.sun.tools.javac.tree.DCTree;
import org.firstinspires.ftc.teamcode.routines.Routine;

public class ConveyorSystem extends Subsystem {

    private DcMotor conveyorMotor;

    public DcMotor getConveyorMotor() {
        return conveyorMotor;
    }

    public void toggleMotor(boolean clicked)
    {
        double pow = 1;
        if(clicked){
            getConveyorMotor().setPower(pow);
        }
        else{
            getConveyorMotor().setPower(0);
        }
    }



    public ConveyorSystem(Routine routine)
    {
        super(routine);
        conveyorMotor = routine.hardwareMap.get(DcMotor.class, "conveyor_motor");
        conveyorMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

}
