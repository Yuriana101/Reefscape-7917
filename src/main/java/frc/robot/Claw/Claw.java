package frc.robot.Claw;

import org.team7525.subsystem.Subsystem;
import static frc.robot.Constants.Claw.*; 

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Claw extends Subsystem<ClawStates>{
    public TalonFX wheels; 
    public TalonFX pivot; 
    public PIDController wheelsController; 
    public PIDController pivotController;
    
    public Claw() {
        super("Claw", ClawStates.OFF); 
        wheels = new TalonFX(WHEELS_DEVICE_ID); 
        pivot = new TalonFX(PIVOT_DEVICE_ID); 

        wheelsController = new PIDController(WHEELS_P, WHEELS_I, WHEELS_D); 
        pivotController = new PIDController(PIVOT_P, PIVOT_I, PIVOT_D); 
        
        pivot.setPosition(0); 
    }

    @Override
    public void runState() {
        wheelsController.calculate(wheels.getVelocity().getValueAsDouble(), getState().getWheelSpeed()); 
        pivotController.calculate((pivot.getPosition().getValueAsDouble())* 360, getState().getPivotSetPoint()); 

        SmartDashboard.putString("Claw State", getState().getStateString()); 
    }
}
