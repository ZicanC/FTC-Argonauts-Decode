package org.firstinspires.ftc.teamcode.routines.driver;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.routines.Routine;
import org.firstinspires.ftc.teamcode.subsystems.ConveyorSystem;
import org.firstinspires.ftc.teamcode.subsystems.DriveSystem;
import org.firstinspires.ftc.teamcode.subsystems.LaunchSystem;
import org.firstinspires.ftc.teamcode.subsystems.ServoTest;

@TeleOp(name = "Driver")
public class DriverRoutine extends Routine {
	public DriveSystem driveSystem;
	public ConveyorSystem conveyorSystem;
	public ServoTest servoTest;
	public LaunchSystem launchSystem;


	@Override
	public void onInit() {
		super.onInit();
//		viperSystem = new ViperSystem(this);
//		clawSystem = new ClawSystem(this);
		//conveyorSystem = new ConveyorSystem(this);
		//driveSystem = new DriveSystem(this);
	}

	@Override
	public void onStart() {
		conveyorSystem = new ConveyorSystem(this);
		driveSystem = new DriveSystem(this);
		launchSystem = new LaunchSystem(this);
		servoTest = new ServoTest(this);


		super.onStart();
		try
		{
			Thread.sleep(1000);

		}catch(InterruptedException e){

		}
		while(opModeIsActive()){

			driveSystem.driveOnTickVector(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
			conveyorSystem.toggleMotor(gamepad1.left_bumper);
			servoTest.toggleServos(gamepad1.y);
			launchSystem.moveOnTick(gamepad1.left_bumper, gamepad1.right_bumper);

			telemetry.addData("left_stick_x", gamepad1.left_stick_x);
			telemetry.addData("left_stick_y", gamepad1.left_stick_x);
			telemetry.addData("right_stick_x", gamepad1.right_stick_x);


			telemetry.update();
		}

	}

}
