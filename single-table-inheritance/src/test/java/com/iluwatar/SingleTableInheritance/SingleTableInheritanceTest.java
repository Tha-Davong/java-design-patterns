package com.iluwatar.SingleTableInheritance;

import com.iluwatar.SingleTableInheritance.ClassObject.*;
import org.junit.Assert;
import org.junit.Test;
import javax.persistence.*;
import java.util.List;

/**
 * Unit tests for App class.
 */
//Run App.java before run the test cases
public class SingleTableInheritanceTest {

    @Test
    public void testAllVehicleTypes() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle;", Vehicle.class);
        List<Vehicle> list = query.getResultList();
        String type1 = list.get(0).getClass().getSimpleName();
        String type2 = list.get(1).getClass().getSimpleName();
        String type3 = list.get(2).getClass().getSimpleName();
        String type4 = list.get(3).getClass().getSimpleName();

        Assert.assertEquals("Car", type1);
        Assert.assertEquals("Train", type2);
        Assert.assertEquals("Freighter", type3);
        Assert.assertEquals("Ship", type4);
    }

    @Test
    public void testEqualityOfCar() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle where vehicle_type = ?;", Vehicle.class);
        query.setParameter(1, "Car");
        List<Car> list = query.getResultList();
        String manufacturer = list.get(0).getManufacturer();
        int passengers = list.get(0).getNoOfPassengers();
        int engine = list.get(0).getEngineCapacity();

        Assert.assertEquals("Volkswagen", manufacturer);
        Assert.assertEquals(4, passengers);
        Assert.assertEquals(1500, engine);
    }

    @Test
    public void testEqualityOfTrain() {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle where vehicle_type = ?;", Vehicle.class);
        query.setParameter(1, "Train");
        List<Train> list = query.getResultList();
        String manufacturer = list.get(0).getManufacturer();
        int passengers = list.get(0).getNoOfPassengers();
        int carriages = list.get(0).getNoOfCarriages();

        Assert.assertEquals("CRRC", manufacturer);
        Assert.assertEquals(200, passengers);
        Assert.assertEquals(10, carriages);
    }

    @Test
    public void testEqualityOfFreighter() {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle where vehicle_type = ?;", Vehicle.class);
        query.setParameter(1, "Freighter");
        List<Freighter> list = query.getResultList();
        String manufacturer = list.get(0).getManufacturer();
        int loadCapacity = list.get(0).getLoadCapacity();
        int length = list.get(0).getLengthOfPlane();

        Assert.assertEquals("Boeing", manufacturer);
        Assert.assertEquals(500, loadCapacity);
        Assert.assertEquals(70, length);
    }

    @Test
    public void testEqualityOfShip() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle where vehicle_type = ?;", Vehicle.class);
        query.setParameter(1, "Ship");
        List<Ship> list = query.getResultList();
        String manufacturer = list.get(0).getManufacturer();
        int loadCapacity = list.get(0).getLoadCapacity();
        int weight = list.get(0).getWeightOfShip();

        Assert.assertEquals("Ever Ace", manufacturer);
        Assert.assertEquals(500, loadCapacity);
        Assert.assertEquals(220, weight);
    }

    @Test
    public void testPassengerVehicles() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle where noofpassengers is not null;", Vehicle.class);
        List<PassengerVehicle> list = query.getResultList();
        String type1 = list.get(0).getClass().getSimpleName();
        String type2 = list.get(1).getClass().getSimpleName();

        Assert.assertEquals("Car", type1);
        Assert.assertEquals("Train", type2);
    }

    @Test
    public void testNotPassengerVehicles() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle where noofpassengers is null;", Vehicle.class);
        List<TransportationVehicle> list = query.getResultList();
        String type1 = list.get(0).getClass().getSimpleName();
        String type2 = list.get(1).getClass().getSimpleName();

        Assert.assertEquals("Freighter", type1);
        Assert.assertEquals("Ship", type2);
    }

    @Test
    public void testTransportationVehicles() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle where loadcapacity is not null;", Vehicle.class);
        List<TransportationVehicle> list = query.getResultList();
        String type1 = list.get(0).getClass().getSimpleName();
        String type2 = list.get(1).getClass().getSimpleName();

        Assert.assertEquals("Freighter", type1);
        Assert.assertEquals("Ship", type2);
    }

    @Test
    public void testNotTransportationVehicles() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle where loadcapacity is null;", Vehicle.class);
        List<PassengerVehicle> list = query.getResultList();
        String type1 = list.get(0).getClass().getSimpleName();
        String type2 = list.get(1).getClass().getSimpleName();

        Assert.assertEquals("Car", type1);
        Assert.assertEquals("Train", type2);
    }

    @Test
    public void testfind(){
        VehicleMapper vm = new VehicleMapper();
        Vehicle v = vm.find(1);
        Assert.assertEquals("Car", v.getClass().getSimpleName());
        v = vm.find(2);
        Assert.assertEquals("Train", v.getClass().getSimpleName());
        v = vm.find(3);
        Assert.assertEquals("Freighter", v.getClass().getSimpleName());
        v = vm.find(4);
        Assert.assertEquals("Ship", v.getClass().getSimpleName());
    }

    @Test
    public void testdelete(){
        VehicleMapper vm = new VehicleMapper();
        Vehicle c = vm.insert(new Car());
        vm.Delete(c);
        Vehicle v = vm.find(c.getIdVehicle());
        Assert.assertNull(v);

    }

    @Test
    public void testupdate(){
        VehicleMapper vm = new VehicleMapper();
        //probably need to get rid of this casting
        Train t = (Train) vm.insert(new Train());
        t.setNoOfCarriages(20);
        vm.update(t);
        Train updated = (Train) vm.find(t.getIdVehicle());
        Assert.assertEquals(20, updated.getNoOfCarriages());

    }

    @Test
    public void RandomTest(){
        VehicleMapper vm = new VehicleMapper();
        Car c = new Car();
        c.setNoOfPassengers(-1);
        c.setEngineCapacity(-1);
        Vehicle v = vm.insert(c);
        Car found = (Car) vm.find(v.getIdVehicle());
        Assert.assertNotNull(found);
    }
}