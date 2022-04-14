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
        final int noOfCarriages = 1500;
        train.setNoOfPassengers(noOfPassengersTrain);
        train.setNoOfCarriages(noOfCarriages);
        em.persist(train);

        PrivateJet airplane = new PrivateJet();
        airplane.setManufacturer("Boeing");
        final int loadCapacity = 200;
        final int lengthOfPlane = 1500;
        airplane.setLoadCapacity(loadCapacity);
        airplane.setLengthOfPlane(lengthOfPlane);
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
    private App() {}
}
