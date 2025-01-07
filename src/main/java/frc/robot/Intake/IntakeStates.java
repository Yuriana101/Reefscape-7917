package frc.robot.Intake; 

import org.team7525.subsystem.SubsystemStates;

import static frc.robot.Constants.Intake.*; 

public enum IntakeStates implements SubsystemStates {
    OFF("OFF", 0, 0), 
    PASSING("PASSING", 0, PASSING_SPEED), 
    ON("ON", ON_SETPOINT.magnitude(), ON_SPEED);

    String stateString; 
    double pivotSetpoint; 
    double wheelSpeed; 
    
    IntakeStates(String stateString, double pivotSetpoint, double wheelSpeed) {
        this.stateString = stateString; 
        this.pivotSetpoint = pivotSetpoint; 
        this.wheelSpeed = wheelSpeed; 
    }

    @Override
    public String getStateString() {
        return stateString; 
    }

    public double getPivotSetPoint() {
        return pivotSetpoint; 
    }

    public double getWheelSpeed() {
        return wheelSpeed; 
    }
}
