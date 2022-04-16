package com.iluwatar.SingleTableInheritance;

import javax.persistence.*;
import java.util.List;

public abstract class Mapper {

    public List<Vehicle> AbstractFind(int id){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createNativeQuery("select * from vehicle where IDVEHICLE = ?;", Vehicle.class);
        query.setParameter(1, id);
        return query.getResultList();
    }
    public Vehicle Load(List<Vehicle> rows){
        if(rows.size() != 1){
            return null;
        }
        return rows.get(0);
    }

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
