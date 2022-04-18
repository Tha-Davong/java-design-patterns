package com.iluwatar.SingleTableInheritance;

import com.iluwatar.SingleTableInheritance.ClassObject.Car;
import com.iluwatar.SingleTableInheritance.ClassObject.Freighter;
import com.iluwatar.SingleTableInheritance.ClassObject.Ship;
import com.iluwatar.SingleTableInheritance.ClassObject.Train;
import com.iluwatar.SingleTableInheritance.ClassObject.Vehicle;

public class VehicleMapper extends Mapper{

    private final CarMapper carMapper = new CarMapper();
    private final ShipMapper shipMapper = new ShipMapper();
    private final TrainMapper trainMapper = new TrainMapper();
    private final FreighterMapper freighterMapper = new FreighterMapper();

    AbstractVehicleMapper<? extends Vehicle> MapperFor(Vehicle v){
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
        Vehicle found = MapperFor(v).find(v.getIdVehicle());
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

    void Delete(Vehicle v){
        MapperFor(v).Delete(v);
    }

    Vehicle find(int id){
        Vehicle result;
        result = carMapper.find(id);
        if(result == null)
            result = shipMapper.find(id);
        if(result == null)
            result = freighterMapper.find(id);
        if(result == null)
            result = trainMapper.find(id);
        return result;
    }
}
