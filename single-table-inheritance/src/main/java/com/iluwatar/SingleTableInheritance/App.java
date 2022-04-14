package com.iluwatar.SingleTableInheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**Singletable inheritance pattern map
 * each instance of class in an inheritance tree into a single table.
 */
final class App {
    /**
     * Program main entry point.
     *
     * @param args program runtime arguments
     */
    public static void main(final String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Car car = new Car();
        car.setManufacturer("Volkswagen");
        final int noOfPassengersCar = 4;
        final int engineCapacity = 1500;
        car.setNoOfPassengers(noOfPassengersCar);
        car.setEngineCapacity(engineCapacity);
        em.persist(car);

        Train train = new Train();
        train.setManufacturer("CRRC");
        final int noOfPassengersTrain = 200;
        final int noOfCarriages = 10;
        train.setNoOfPassengers(noOfPassengersTrain);
        train.setNoOfCarriages(noOfCarriages);
        em.persist(train);

        Freighter airplane = new Freighter();
        airplane.setManufacturer("Boeing");
        final int loadCapacity = 500;
        final int lengthOfPlane = 70;
        airplane.setLoadCapacity(loadCapacity);
        airplane.setLengthOfPlane(lengthOfPlane);
        em.persist(airplane);

        Ship ship = new Ship();
        ship.setManufacturer("Ever Ace");
        final int loadCapacityShip = 500;
        final int weightOfShip = 220;
        ship.setLoadCapacity(loadCapacityShip);
        ship.setWeightOfShip(weightOfShip);
        em.persist(ship);

        transaction.commit();
        em.close();
        emf.close();
    }
    /**
     * private constructor so class App can't be instantiated.
     */
    private App() { }
}
