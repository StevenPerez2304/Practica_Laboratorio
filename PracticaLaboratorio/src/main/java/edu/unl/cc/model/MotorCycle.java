package edu.unl.cc.model;

public class MotorCycle extends Vehicle{
    private int displacement; //cilindrada 
    private static double costMaintenance; 

    public MotorCycle(String credential, double tonnage, float fuel, String lastFixDateMaintenance) {
        super(credential, tonnage, fuel, lastFixDateMaintenance);
    }

    @Override
    void loadFuel() {
        System.out.println("Cargando " + getFuel());
    }
    
    
}
