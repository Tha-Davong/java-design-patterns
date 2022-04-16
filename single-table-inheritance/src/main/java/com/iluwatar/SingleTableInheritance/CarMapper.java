package com.iluwatar.SingleTableInheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CarMapper extends AbstractVehicleMapper<Car>{
    public Car find(int id){
        return (Car) AbstractFind(id);
    }

    public Car Update(Vehicle v){
        Car c = (Car) v;
        Save(c, true);
        return c;
    }

    public Car Insert(Vehicle v){
        Car c = (Car) v;
        Save(c, false);
        return c;
    }
}
