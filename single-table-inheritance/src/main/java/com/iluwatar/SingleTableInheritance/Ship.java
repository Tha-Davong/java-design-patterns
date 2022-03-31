package com.iluwatar.SingleTableInheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Ship")
public class Ship extends TransportationVehicle{

    private int weightOfShip;

    public int getWeightOfShip() {
        return weightOfShip;
    }

    public void setWeightOfShip(int weightOfShip) {
        this.weightOfShip = weightOfShip;
    }
}
