package com.iluwatar.SingleTableInheritance;

import javax.persistence.*;
import java.util.List;

public abstract class Mapper {
    public Vehicle AbstractFind(int id){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("AdvancedMapping");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createNativeQuery("select * from vehicle where IDVEHICLE = ?;", Vehicle.class);
        query.setParameter(1, id);
        List<Vehicle> list = query.getResultList();

        if(list.size() == 1){
            return list.get(0);
        }else{
            return null;
        }

    }
}
