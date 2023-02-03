package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.subsystems.Robot;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class ArmIniter extends LinearOpMode{
    private Robot robot;
    private ElapsedTime timer;

    public void runOpMode(){
        robot = new Robot(telemetry, hardwareMap);
        timer = new ElapsedTime();
        robot.init();

        robot.intake.setArmPos(0.5);

        waitForStart();
        while(!isStopRequested() && opModeIsActive()) {

            }
            telemetry.update();
            robot.update();
        }
    }

