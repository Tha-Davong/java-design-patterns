package com.iluwatar.SingleTableInheritance;

import javax.persistence.*;
import java.util.List;

public class VehicleMapper extends Mapper{

    CarMapper carMapper = new CarMapper();
    ShipMapper shipMapper = new ShipMapper();
    TrainMapper trainMapper = new TrainMapper();
    FreighterMapper freighterMapper = new FreighterMapper();


    void update(Vehicle v){
        Vehicle found = AbstractFind(v.getIdVehicle());
        if(found != null){
            EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory("AdvancedMapping");
            EntityManager em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.merge(v);

            transaction.commit();
            em.close();
            emf.close();
        }
    }

    Vehicle insert(Vehicle v){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(v);

        transaction.commit();
        em.close();
        emf.close();
        return v;
    }

    void Delete(int id){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createNativeQuery("delete from vehicle where IDVEHICLE = ?;", Vehicle.class);
        query.setParameter(1, id);
        query.executeUpdate();

        transaction.commit();
        em.close();
        emf.close();
    }

}
