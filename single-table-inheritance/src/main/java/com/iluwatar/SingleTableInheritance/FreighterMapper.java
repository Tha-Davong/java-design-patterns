package com.iluwatar.SingleTableInheritance;

public class FreighterMapper extends AbstractVehicleMapper<Freighter>{
    Freighter find(int id){
       Freighter f = (Freighter) AbstractFind(id);
       return f;
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
