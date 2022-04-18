package com.iluwatar.SingleTableInheritance;

import com.iluwatar.SingleTableInheritance.ClassObject.Vehicle;

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

