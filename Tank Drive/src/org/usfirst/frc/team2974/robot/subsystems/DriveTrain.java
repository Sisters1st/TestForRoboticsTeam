package org.usfirst.frc.team2974.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain {
	private DifferentialDrive robotDrive;
	private Joystick m_leftStick;
	private Joystick m_rightStick;
	
	//this is a javadoc comment. Anybody inspecting this constructor will see this comment.
	/**
	 * The base constructor for drivetrain. This should be called in the robot file's robotinit function.
	 * @author John
	 */
	public DriveTrain() {
		robotDrive = new DifferentialDrive(new Spark(0), new Spark(1));
		m_leftStick = new Joystick(0);
		m_rightStick = new Joystick(1);
	}
	
	public void teleopPeriodic() {
		//deadband: a deadband is a number that sets the smallest amount of control that you'll actually accept.
		//for example, if my deadband was 0.1, I would ignore all inputs less than to% away from the center
				
		double lstick = m_leftStick.getY();
		double rstick = m_rightStick.getY();
				
		//Math.abs() returns the absolute value of any double or int put inside
		if(Math.abs(lstick) < 0.1) {
			lstick = 0;
		}
				
		if(Math.abs(rstick) < 0.1) {
			rstick = 0;
		}
				
		if(lstick < 0) {
			lstick = -1*(lstick*lstick);
		}else {
			lstick = lstick * lstick;
		}
				
		if(rstick < 0) {
			rstick = -1*(rstick*rstick);
		}else {
			rstick = rstick * rstick;
		}
				
		//now we have just added a deadband of 0.1
		//now the range of the stick maps squared to the power of the motors
		//this will make fine tuning the robot's position with subtle stick movements MUCH easier
		robotDrive.tankDrive(lstick, rstick);		
	}
	
	/**
	 * Gives a String description of the current state of the DriveTrain
	 * @return a nicely formatted string that gets the current position of the left stick and right stick
	 */
	public String currentState() {
		return "Left Stick:" + m_leftStick.getY() + " Right Stick:" + m_rightStick.getY();
	}
}
