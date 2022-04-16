package com.iluwatar.SingleTableInheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public abstract class AbstractVehicleMapper<T> extends Mapper{

    public Vehicle Save(Vehicle v, boolean update){
        super.Save(v, update);
        return v;
    }
    public Vehicle Load(List<Vehicle> rows){
        return super.Load(rows);

    }
    public abstract T Update(Vehicle v);
    public abstract T Insert(Vehicle v);
    public abstract T find(int id);


}

