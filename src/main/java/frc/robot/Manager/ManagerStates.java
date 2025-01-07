package frc.robot.Manager;

import org.team7525.subsystem.SubsystemStates;

import frc.robot.Claw.ClawStates;
import frc.robot.Intake.IntakeStates;

public enum ManagerStates implements SubsystemStates {
    IDLE("OFF", IntakeStates.OFF, ClawStates.OFF), 
    INTAKING("INTAKING", IntakeStates.ON, ClawStates.OFF),
    PASSING("PASSING", IntakeStates.PASSING, ClawStates.OFF),
    RECIEVING("RECIEVING", IntakeStates.OFF, ClawStates.INTAKING), //Idk what to name soo
    PROCESSING("PROCESSING", IntakeStates.OFF, ClawStates.PROCESSING), 
    SHOOTING("SHOOTING", IntakeStates.OFF, ClawStates.SHOOTING); 

    String stateString; 
    IntakeStates intakeState; 
    ClawStates clawState; 

    ManagerStates(String stateString, IntakeStates intakeState, ClawStates clawState) {
        this.stateString = stateString;
        this.intakeState = intakeState; 
        this.clawState = clawState; 
    }

    @Override
    public String getStateString() {
        return stateString; 
    }

    public IntakeStates getIntakeStates() {
        return intakeState; 
    }

    public ClawStates getClawStates() {
        return clawState; 
    }
}
