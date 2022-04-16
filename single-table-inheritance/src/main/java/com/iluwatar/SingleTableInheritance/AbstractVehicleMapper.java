package com.iluwatar.SingleTableInheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class AbstractVehicleMapper<T> extends Mapper{

    public Vehicle Save(Vehicle v, boolean update){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        if(update) {
            em.merge(v);
        }else{
            em.persist(v);
        }

        transaction.commit();
        em.close();
        emf.close();
        return v;
    }

    public abstract T Update(Vehicle v);
    public abstract T Insert(Vehicle v);


}

