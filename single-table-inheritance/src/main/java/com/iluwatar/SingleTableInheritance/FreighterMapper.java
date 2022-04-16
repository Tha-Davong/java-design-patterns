package com.iluwatar.SingleTableInheritance;

import java.util.List;

public class FreighterMapper extends AbstractVehicleMapper<Freighter>{
    public Freighter find(int id){
        List<Vehicle> rows = AbstractFind(id);
        return Load(rows);
    }

    public Freighter Load(List<Vehicle> rows){
        return (Freighter) super.Load(rows);
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
