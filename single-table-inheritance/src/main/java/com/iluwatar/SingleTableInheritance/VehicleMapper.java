package com.iluwatar.SingleTableInheritance;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class VehicleMapper extends Mapper{

    CarMapper carMapper = new CarMapper();
    ShipMapper shipMapper = new ShipMapper();
    TrainMapper trainMapper = new TrainMapper();
    FreighterMapper freighterMapper = new FreighterMapper();

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
        Vehicle found = AbstractFind(v.getIdVehicle());
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
