package Esercizio;

import java.util.ArrayList;
import java.util.Date;

public class ParkingArea {

    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    private double tariff = 0.01;
    public int size;

    public ParkingArea(int size) {
        this.size = size;
    }

    public boolean addVehicle(Vehicle vehicle) throws Exception {
        int typeOfVehicle;
        if(vehicle.isTypeOfVehicle())
            typeOfVehicle = 1;
        else
            typeOfVehicle = 3;
        if(this.size-typeOfVehicle <0)
            throw new Exception("Parcheggio pieno");
        this.vehicles.add(vehicle);
        this.size -= typeOfVehicle;
        return true;
    }

    public Vehicle findVihicle(String plate){
        for(int i=0; i<this.vehicles.size(); i++)
            if (this.vehicles.get(i).getPlate().equals(plate))
                return this.vehicles.get(i);
        return null;
    }

    public double calculateTotalPrice(Vehicle vehicle, Date out){
        vehicle.setOut(out);
        int minutes = (int)(out.getTime()-vehicle.getIn().getTime())/60000;
        double totalPrice= (double) minutes*this.tariff;
        if(minutes<= 240 && totalPrice > 2)
            totalPrice = 2.0;
        if(totalPrice > 6)
            totalPrice = 6.0;
        return totalPrice;
    }

    public Vehicle removeVehicle(String plate, Date out) throws Exception {
        Vehicle vehicle;
        if((vehicle = findVihicle(plate)) == null)
            throw new Exception("Non Esiste questa macchina");
        vehicle.setTotalPrice(calculateTotalPrice(vehicle,out));
        int typeOfVehicle;
        if(vehicle.isTypeOfVehicle())
            typeOfVehicle = 1;
        else
            typeOfVehicle = 3;
        this.vehicles.remove(vehicle);
        this.size += typeOfVehicle;
        return vehicle;
    }

    @Override
    public String toString() {
        return "Parcheggio{" +
                "tariff=" + tariff +
                ", size=" + size +
                ", vehicles=" + vehicles +
                '}';
    }
}
