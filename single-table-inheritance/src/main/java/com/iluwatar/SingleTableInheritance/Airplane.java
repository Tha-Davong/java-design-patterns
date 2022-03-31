package com.iluwatar.SingleTableInheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Airplane")
public class Airplane extends TransportationVehicle{

    private int lengthOfPlane;

    public int getLengthOfPlane() {
        return lengthOfPlane;
    }

    public void setLengthOfPlane(int lengthOfPlane) {
        this.lengthOfPlane = lengthOfPlane;
    }

}