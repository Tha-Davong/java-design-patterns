import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args){
        /* Create EntityManagerFactory */
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("AdvancedMapping");

        /* Create EntityManager */
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Bike cbr1000rr = new Bike();
        cbr1000rr.setManufacturer("honda");
        cbr1000rr.setNoOfpassengers(1);
        cbr1000rr.setSaddleHeight(30);
        em.persist(cbr1000rr);

        Car avantador = new Car();
        avantador.setManufacturer("lamborghini");
        avantador.setNoOfDoors(2);
        avantador.setNoOfpassengers(2);
        em.persist(avantador);

        Truck truck = new Truck();
        truck.setLoadCapacity(100);
        truck.setManufacturer("mercedes");
        truck.setNoOfContainers(2);
        em.persist(truck);

        transaction.commit();

        em.close();
        emf.close();
    }
}
