package frc.robot.Claw;

import static frc.robot.Constants.Claw.*;

import org.team7525.subsystem.SubsystemStates;

public enum ClawStates implements SubsystemStates {
    OFF("IDLE",0, 0), 
    INTAKING("INTAKING", 0, INTAKING_SPEED), 
    SHOOTING("SHOOTING", SHOOTING_SETPOINT.magnitude(), SHOOTING_SPEED ), 
    PROCESSING("PROCESSING",PROCESSING_SETPOINT.magnitude() , 0); 

    String stateString; 
    double pivotSetpoint; 
    double wheelSpeed; 

    ClawStates(String stateString, double pivotSetpoint, double wheelSpeed) {
        this.stateString = stateString; 
        this.pivotSetpoint = pivotSetpoint; 
        this.wheelSpeed = wheelSpeed; 
    }

    @Override
    public String getStateString(){
        return stateString; 
    }

    public double getPivotSetPoint() {
        return pivotSetpoint; 
    }

    public double getWheelSpeed() {
        return wheelSpeed; 
    }
}  