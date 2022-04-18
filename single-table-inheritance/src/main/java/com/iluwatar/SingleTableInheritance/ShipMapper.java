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
        Vehicle v = super.Load(rows);
        if(v instanceof Ship)
            return (Ship) v;
        else
            return null;
    }

    public Ship Save(Vehicle v, boolean update){
        return (Ship) super.Save(v, update);
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
