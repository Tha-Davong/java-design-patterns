package com.iluwatar.SingleTableInheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**Concrete class of the abstract class TransportationVehicle.
 * The annotation @Entity is used to tell Persistence
 * that this is a concrete class
 */
@Entity
@DiscriminatorValue(value = "Ship")
public class Ship extends TransportationVehicle {
    /**class private attribute.
     */
    private int weightOfShip;

    /**get method for private attribute.
     * @return int
     */
    public int getWeightOfShip() {
        return weightOfShip;
    }
    /**set method for private attribute.
     * @param val set value
     */
    public void setWeightOfShip(final int val) {
        this.weightOfShip = val;
    }
}
