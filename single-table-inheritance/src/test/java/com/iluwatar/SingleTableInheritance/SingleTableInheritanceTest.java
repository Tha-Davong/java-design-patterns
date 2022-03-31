package com.iluwatar.SingleTableInheritance;

import org.junit.Assert;
import org.junit.BeforeClass;
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

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle;", Vehicle.class);
        List<Vehicle> list = query.getResultList();
        String type1 = list.get(0).getClass().getName();
        String type2 = list.get(1).getClass().getName();
        String type3 = list.get(2).getClass().getName();
        String type4 = list.get(3).getClass().getName();

        Assert.assertEquals("com.iluwatar.SingleTableInheritance.Car", type1);
        Assert.assertEquals("com.iluwatar.SingleTableInheritance.Train", type2);
        Assert.assertEquals("com.iluwatar.SingleTableInheritance.Airplane", type3);
        Assert.assertEquals("com.iluwatar.SingleTableInheritance.Ship", type4);
    }

    @Test
    public void testEqualityOfCar() {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AdvancedMapping");
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
    public void testEqualityOfAirplane() {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle where vehicle_type = ?;", Vehicle.class);
        query.setParameter(1, "Airplane");
        List<Airplane> list = query.getResultList();
        String manufacturer = list.get(0).getManufacturer();
        int loadCapacity = list.get(0).getLoadCapacity();
        int length = list.get(0).getLengthOfPlane();

        Assert.assertEquals("Boeing", manufacturer);
        Assert.assertEquals(500, loadCapacity);
        Assert.assertEquals(70, length);
    }

    @Test
    public void testEqualityOfShip() {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AdvancedMapping");
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

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle where noofpassengers is not null;", Vehicle.class);
        List<PassengerVehicle> list = query.getResultList();
        String type1 = list.get(0).getClass().getName();
        String type2 = list.get(1).getClass().getName();

        Assert.assertEquals("com.iluwatar.SingleTableInheritance.Car", type1);
        Assert.assertEquals("com.iluwatar.SingleTableInheritance.Train", type2);
    }

    @Test
    public void testNotPassengerVehicles() {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle where noofpassengers is null;", Vehicle.class);
        List<TransportationVehicle> list = query.getResultList();
        String type1 = list.get(0).getClass().getName();
        String type2 = list.get(1).getClass().getName();

        Assert.assertEquals("com.iluwatar.SingleTableInheritance.Airplane", type1);
        Assert.assertEquals("com.iluwatar.SingleTableInheritance.Ship", type2);
    }

    @Test
    public void testTransportationVehicles() {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle where loadcapacity is not null;", Vehicle.class);
        List<TransportationVehicle> list = query.getResultList();
        String type1 = list.get(0).getClass().getName();
        String type2 = list.get(1).getClass().getName();

        Assert.assertEquals("com.iluwatar.SingleTableInheritance.Airplane", type1);
        Assert.assertEquals("com.iluwatar.SingleTableInheritance.Ship", type2);
    }

    @Test
    public void testNotTransportationVehicles() {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();

        Query query = em.createNativeQuery("select * from vehicle where loadcapacity is null;", Vehicle.class);
        List<PassengerVehicle> list = query.getResultList();
        String type1 = list.get(0).getClass().getName();
        String type2 = list.get(1).getClass().getName();

        Assert.assertEquals("com.iluwatar.SingleTableInheritance.Car", type1);
        Assert.assertEquals("com.iluwatar.SingleTableInheritance.Train", type2);
    }
}