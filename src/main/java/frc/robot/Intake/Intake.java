package frc.robot.Intake; 
import org.team7525.subsystem.Subsystem;

import static frc.robot.Constants.Intake.*; 

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake extends Subsystem<IntakeStates>{
    public SparkMax wheels;
    public SparkMax pivot; 
    public PIDController wheelController; 
    public PIDController pivotController; 

    public Intake () {
        super("Intake", IntakeStates.OFF); 
        wheels = new SparkMax(WHEELS_DEVICE_ID, MotorType.kBrushless); 
        pivot = new SparkMax(PIVOT_DEVICE_ID, MotorType.kBrushless); 
        wheelController = new PIDController(WHEELS_P, WHEELS_I, WHEELS_D); 
        pivotController = new PIDController(PIVOT_P, PIVOT_I, PIVOT_D); 
    }

    @Override
    public void runState() { 
        wheelController.calculate(wheels.getEncoder().getVelocity(), getState().getWheelSpeed()); 
        pivotController.calculate(pivot.getEncoder().getPosition(), getState().getPivotSetPoint());

        SmartDashboard.putString("Intake State", getState().getStateString()); 
    }    
}
