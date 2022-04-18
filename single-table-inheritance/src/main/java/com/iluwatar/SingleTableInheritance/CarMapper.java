package com.iluwatar.SingleTableInheritance;

import com.iluwatar.SingleTableInheritance.ClassObject.Car;
import com.iluwatar.SingleTableInheritance.ClassObject.Vehicle;

import java.util.List;

public class CarMapper extends AbstractVehicleMapper<Car>{

    public Car find(int id){
        List<Vehicle> rows = AbstractFind(id);
        return Load(rows);
    }

    public Car Load(List<Vehicle> rows){
        return (Car) super.Load(rows);
    }

    public Car Save(Vehicle v, boolean update){
        return (Car) super.Save(v, update);
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
