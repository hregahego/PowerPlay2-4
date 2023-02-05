package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.controls.SlewRateLimiter;
import org.firstinspires.ftc.teamcode.subsystems.Robot;
import org.firstinspires.ftc.teamcode.util.Encoder;

@TeleOp
public class IntakeTest extends LinearOpMode{
    private Robot robot;
    private final double dtRate = 0.5;
    private SlewRateLimiter SRL;
    private Encoder leftEncoder, rightEncoder, frontEncoder;

    FtcDashboard dashboard;


    public void runOpMode(){
        robot = new Robot(telemetry, hardwareMap);
        robot.init();

        TelemetryPacket packet = new TelemetryPacket();
        MultipleTelemetry tele = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        dashboard = FtcDashboard.getInstance();

        robot.lift.setTargetHeight(300);

        waitForStart();

        //robot.lift.setArmPos(LiftConstants.IdleArm);
        telemetry.addData("loop:", "started");
        while(!isStopRequested()) {
//            telemetry.addData("turret goal", robot.turret.getTargetAngle());
//            telemetry.addData("encoder left value: ", leftEncoder.getCurrentPosition());
//            telemetry.addData("encoder right value: ", rightEncoder.getCurrentPosition());
//            telemetry.addData("encoder front value: ", frontEncoder.getCurrentPosition());
//
//            packet.put("encoder left value: ", leftEncoder.getCurrentPosition());
//            packet.put("encoder right value: ", rightEncoder.getCurrentPosition());
//            packet.put("encoder front value: ", frontEncoder.getCurrentPosition());
            dashboard.sendTelemetryPacket(packet);

            robot.update();
            telemetry.update();

            if (gamepad1.left_bumper) {
//                robot.intake.armServo1.setPosition(0.25);
                robot.intake.armServo2.setPosition(0.75);
            }
            if (gamepad1.right_bumper) {
//                robot.intake.armServo1.setPosition(0.6);
                robot.intake.armServo2.setPosition(0.4);
            }
            if (gamepad1.a) {
                robot.lift.setHorizontalPosition(0.15);
            }
            if (gamepad1.b) {
                robot.lift.setHorizontalPosition(1.0);
            }
        }
    }

}