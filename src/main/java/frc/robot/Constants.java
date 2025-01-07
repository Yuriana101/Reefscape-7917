package frc.robot;

import static edu.wpi.first.units.Units.*;

import edu.wpi.first.units.measure.Angle;

public class Constants {
    public static final class Claw {
        //IDs
        public static final int WHEELS_DEVICE_ID = 7; 
        public static final int PIVOT_DEVICE_ID = 8; 

        //PID Controller
        public static final double WHEELS_P = 1; 
        public static final double WHEELS_I = 0; 
        public static final double WHEELS_D = 0.1; 
        public static final double PIVOT_P = 1; 
        public static final double PIVOT_I = 0; 
        public static final double PIVOT_D = 0.1; 

        //Speeds 
        public static final double INTAKING_SPEED = -10; 
        public static final double SHOOTING_SPEED = 10; 

        //Set Points - degrees
        public static final Angle SHOOTING_SETPOINT = Degrees.of(100); 
        public static final Angle PROCESSING_SETPOINT = Degrees.of(270); 
    }

    public static final class Intake {
        //IDs
        public static final int WHEELS_DEVICE_ID = 4; 
        public static final int PIVOT_DEVICE_ID = 5; 

        //PID Controller 
        public static final double WHEELS_P = 1; 
        public static final double WHEELS_I = 0; 
        public static final double WHEELS_D = 0.1; 
        public static final double PIVOT_P = 1; 
        public static final double PIVOT_I = 0; 
        public static final double PIVOT_D = 0.1; 

        //Speeds
        public static final double PASSING_SPEED = 10; 
        public static final double ON_SPEED = 10; 

        //Set Points
        public static final Angle ON_SETPOINT = Degrees.of(120); //Random value idk 
    }
}
