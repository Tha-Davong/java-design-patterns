import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Train")
public class Train extends PassengerVehicle {

    private int noOfCarriages;

    public int getNoOfCarriages() {
        return noOfCarriages;
    }

    public void setNoOfCarriages(int noOfCarriages) {
        this.noOfCarriages = noOfCarriages;
    }

}