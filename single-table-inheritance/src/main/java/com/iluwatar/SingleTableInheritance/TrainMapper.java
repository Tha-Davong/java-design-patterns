package com.iluwatar.SingleTableInheritance;

import com.iluwatar.SingleTableInheritance.ClassObject.Train;
import com.iluwatar.SingleTableInheritance.ClassObject.Vehicle;

import java.util.List;

public class TrainMapper extends AbstractVehicleMapper<Train>{
    public Train find(int id){
        List<Vehicle> rows = AbstractFind(id);
        return Load(rows);
    }

    public Train Load(List<Vehicle> rows){
        Vehicle v = super.Load(rows);
        if(v instanceof Train)
            return (Train) v;
        else
            return null;
    }

    public Train Save(Vehicle v, boolean update){
        return (Train) super.Save(v, update);
    }

    public Train Update(Vehicle v){
        Save(v, true);
        return (Train) v;
    }

    public Train Insert(Vehicle v){
        Save(v, false);
        return (Train) v;
    }
}
