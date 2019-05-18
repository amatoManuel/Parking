package Esercizio;

import java.util.Date;

public class Vehicle {

    private Date in;
    private Date out;
    private boolean typeOfVehicle;
    private String plate;
    private double totalPrice;

    public Vehicle(boolean typeOfVehicle, String plate) {
        this.typeOfVehicle = typeOfVehicle;
        this.plate = plate;
    }

    public Vehicle(Date in, boolean typeOfVehicle, String plate) {
        this(typeOfVehicle,plate);
        this.in = in;
    }

    public Date getIn() {
        return in;
    }

    public void setIn(Date in) {
        this.in = in;
    }

    public Date getOut() {
        return out;
    }

    public void setOut(Date out) {
        this.out = out;
    }

    public boolean isTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(boolean typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public String toString() {
        String s = "";
        s += "\nVeicolo{" +
                "\n\tMarca=" + plate  +
                "\n\tEntrata=" + this.in +
                "\n\tUscita=" + this.out +
                "\n\tTipo di veicolo=";
        if (this.typeOfVehicle) {
            s+="Automobile";
        }
        else
            s+= "Autotreno";

        s+="\n}";
        return s;
    }
}
