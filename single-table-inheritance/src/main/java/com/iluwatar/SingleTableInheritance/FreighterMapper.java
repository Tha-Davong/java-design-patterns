package com.iluwatar.SingleTableInheritance;

import com.iluwatar.SingleTableInheritance.ClassObject.Car;
import com.iluwatar.SingleTableInheritance.ClassObject.Freighter;
import com.iluwatar.SingleTableInheritance.ClassObject.Vehicle;

import java.util.List;

public class FreighterMapper extends AbstractVehicleMapper<Freighter>{
    public Freighter find(int id){
        List<Vehicle> rows = AbstractFind(id);
        return Load(rows);
    }

    public Freighter Load(List<Vehicle> rows){
        return (Freighter) super.Load(rows);
    }

    public Freighter Save(Vehicle v, boolean update){
        return (Freighter) super.Save(v, update);
    }
    public Freighter Update(Vehicle v){
        Save(v, true);
        return (Freighter) v;
    }

    public Freighter Insert(Vehicle v){
        Save(v, false);
        return (Freighter) v;
    }
}
