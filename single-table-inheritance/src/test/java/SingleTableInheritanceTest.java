import org.junit.Assert;
import org.junit.Test;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Unit tests for App class.
 */
public class AppTest1 {

    @Test
    public void test1() {
        Car car = new Car();
        car.setManufacturer("Volkswagen");
        car.setNoOfPassengers(4);
        car.setEngineCapacity(1500);
        String manufacturer = car.getManufacturer();
        int passengers = car.getNoOfPassengers();
        int engine = car.getEngineCapacity();

        Assert.assertEquals("Volkswagen", manufacturer);
        Assert.assertEquals(4, passengers);
        Assert.assertEquals(1500, engine);
    }

    @Test
    public void test2() {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle where vehicle_type = ?;", Vehicle.class);
        //query.setParameter(1, "noofpassengers");
        query.setParameter(1, "Train");
        List<Train> list = query.getResultList();
        String manufacturer = list.get(0).getManufacturer();
        int passengers = list.get(0).getNoOfPassengers();
        int carriages = list.get(0).getNoOfCarriages();

        Assert.assertEquals("CRRC", manufacturer);
        Assert.assertEquals(200, passengers);
        Assert.assertEquals(100, carriages);
    }

}