package frc.robot.Manager;

import org.team7525.subsystem.Subsystem;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Claw.Claw;
import frc.robot.Intake.Intake;

public class Manager extends Subsystem<ManagerStates>{

    private Intake intake; 
    private Claw claw; 
    private XboxController controller; 

    Manager() {
        super("Manager", ManagerStates.IDLE); 
        intake = new Intake(); 
        claw = new Claw(); 
        controller = new XboxController(1); 
 
        addTrigger(ManagerStates.IDLE, ManagerStates.INTAKING, controller::getAButtonPressed);
        addTrigger(ManagerStates.INTAKING, ManagerStates.IDLE, controller::getAButtonPressed);
        addTrigger(ManagerStates.IDLE, ManagerStates.PASSING, controller::getBButtonPressed);
        addTrigger(ManagerStates.PASSING, ManagerStates.IDLE, controller::getBButtonPressed);
        
        addTrigger(ManagerStates.IDLE, ManagerStates.RECIEVING, controller::getXButtonPressed);
        addTrigger(ManagerStates.RECIEVING,ManagerStates.IDLE, controller::getXButtonPressed);
        addTrigger(ManagerStates.RECIEVING, ManagerStates.PROCESSING, controller::getYButtonPressed);
        addTrigger(ManagerStates.PROCESSING, ManagerStates.SHOOTING, controller::getYButtonPressed); //Ran out of buttons :(
        addTrigger(ManagerStates.SHOOTING, ManagerStates.IDLE, controller::getYButtonPressed);
    }
        
    @Override
    public void runState(){
        intake.setState(getState().getIntakeStates());
        claw.setState(getState().getClawStates());

        intake.periodic();
        claw.periodic(); 

        SmartDashboard.putString("Manager State", getState().stateString);
    }
}