package com.iluwatar.SingleTableInheritance;

import com.iluwatar.SingleTableInheritance.ClassObject.*;

public class VehicleMapper extends Mapper{

    CarMapper carMapper = new CarMapper();
    ShipMapper shipMapper = new ShipMapper();
    TrainMapper trainMapper = new TrainMapper();
    FreighterMapper freighterMapper = new FreighterMapper();
    //todo need find method in this class
    AbstractVehicleMapper MapperFor(Vehicle v){
        if( v instanceof Car){
            return carMapper;
        }else if (v instanceof Ship){
            return shipMapper;
        }else if (v instanceof Train){
            return trainMapper;
        }else if (v instanceof Freighter){
            return freighterMapper;
        }else {
            return null;
        }
    }

    Vehicle update(Vehicle v){
        Vehicle found = (Vehicle) MapperFor(v).find(v.getIdVehicle());
        if(found != null){
            MapperFor(v).Update(v);
            return v;
        }
        return null;
    }

    Vehicle insert(Vehicle v){
        MapperFor(v).Insert(v);
        return v;
    }
}
