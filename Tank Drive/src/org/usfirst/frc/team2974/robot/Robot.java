/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2974.robot;

import org.usfirst.frc.team2974.robot.subsystems.Catapult;
import org.usfirst.frc.team2974.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends IterativeRobot {
	
	//declare every subsystem. Because I'm doing that at the top of the class, they will have a global scope
	private DriveTrain driveTrain;
	private Catapult catapult;

	@Override
	public void robotInit() {
		//the robotInit function stands for Robot Initialized
		//this code runs once when the code is first put on the robot OR whenever a robot that has code in it
		//already first starts up.
		//This code in robotInit runs before EVERYTHING ELSE
		
		//that's what robotInit is for
		//robotInit should be used to set up subsystems
		
		//create the objects for each subsystem by calling their constructors
		driveTrain = new DriveTrain();
		catapult = new Catapult();
	}

	@Override
	public void teleopPeriodic() {
		//code that runs many many times per second (20-200) while the game is actually going
		//the part of the code where you actually make the controls move the motors
		driveTrain.teleopPeriodic();
		catapult.teleopPeriodic();
	}
}
