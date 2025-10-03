/*
WIP
 */
package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.routines.Routine;

import java.lang.reflect.Method;
import java.util.function.Consumer;

public class ToggleSystem extends Subsystem{

    private boolean isHold;
    private boolean toggled;
    private Runnable on;
    private Runnable off;

    private void toggle(boolean clicked)
    {
        if(!isHold && clicked)
        {
            isHold = true;
        }
        else if(isHold && !clicked)
        {
            isHold = false;
            if(toggled)
            {
                on.run();
                toggled = false;
            } else
            {
                off.run();
                toggled = true;
            }
        }
    }

    public ToggleSystem(Routine routine, Runnable on,  Runnable off)
    {
        super(routine);
        this.on = on;
        this.off = off;
        this.isHold = false;
        this.toggled = false;

    }


}
