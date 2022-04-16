package com.iluwatar.SingleTableInheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class CarMapper extends AbstractVehicleMapper<Car>{

    public Car find(int id){
        List<Vehicle> rows = AbstractFind(id);
        return Load(rows);
    }

    public Car Load(List<Vehicle> rows){
        return (Car) super.Load(rows);
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
