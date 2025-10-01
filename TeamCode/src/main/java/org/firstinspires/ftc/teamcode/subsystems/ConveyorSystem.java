package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.sun.tools.javac.tree.DCTree;
import org.firstinspires.ftc.teamcode.routines.Routine;

public class ConveyorSystem extends Subsystem {

    private DcMotor conveyorMotor;
    private boolean isOn;
    private boolean wasPressed;

    public DcMotor getConveyorMotor() {
        return conveyorMotor;
    }

    public boolean getWasPressed()
    {
        return wasPressed;
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
    public void toggleMotor(boolean clicked)
    {
        if (clicked && !getIsOn()) {
            setIsOn(!getIsOn());
        }

        setWasPressed(clicked);

        if (getIsOn()) {
            getConveyorMotor().setPower(0.9);
        } else {
            getConveyorMotor().setPower(0.0);
        }
        /*
        if(clicked && !getIsOn())
        {
            getConveyorMotor().setPower(0.9);
            this.setIsOn(true);
        } else if (clicked && getIsOn()) {
            getConveyorMotor().setPower(0);
            this.setIsOn(false);
        }
        */
    }
    public ConveyorSystem(Routine routine)
    {
        super(routine);
        this.isOn = false;
        this.wasPressed = false;
        conveyorMotor = routine.hardwareMap.get(DcMotor.class, "conveyor_motor");
        conveyorMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

}
