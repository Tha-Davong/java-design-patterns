package com.iluwatar.SingleTableInheritance;

import com.iluwatar.SingleTableInheritance.ClassObject.Ship;
import com.iluwatar.SingleTableInheritance.ClassObject.Vehicle;

import java.util.List;

public class ShipMapper extends AbstractVehicleMapper<Ship>{
    public Ship find(int id) {
        List<Vehicle> rows = AbstractFind(id);
        return Load(rows);
    }

    public Ship Load(List<Vehicle> rows){
        return (Ship) super.Load(rows);
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
