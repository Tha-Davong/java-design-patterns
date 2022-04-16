package com.iluwatar.SingleTableInheritance;

public class ShipMapper extends AbstractVehicleMapper<Ship>{
    Ship find(int id) {
        Ship s = (Ship) AbstractFind(id);
        return s;
    }

    public Ship Update(Vehicle v){
        Save(v, true);
        return (Ship) v;
    }

    public Ship Insert(Vehicle v){
        Save(v, false);
        return (Ship) v;
    }
}
