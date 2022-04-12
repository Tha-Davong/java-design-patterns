package com.iluwatar.SingleTableInheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Car car = new Car();
        car.setManufacturer("Volkswagen");
        car.setNoOfPassengers(4);
        car.setEngineCapacity(1500);
        em.persist(car);

        Train train = new Train();
        train.setManufacturer("CRRC");
        train.setNoOfPassengers(200);
        train.setNoOfCarriages(10);
        em.persist(train);

        PrivateJet airplane = new PrivateJet();
        airplane.setManufacturer("Boeing");
        airplane.setLoadCapacity(500);
        airplane.setLengthOfPlane(70);
        em.persist(airplane);

        Ship ship = new Ship();
        ship.setManufacturer("Ever Ace");
        ship.setLoadCapacity(500);
        ship.setWeightOfShip(220);
        em.persist(ship);

        transaction.commit();
        em.close();
        emf.close();
    }
}
