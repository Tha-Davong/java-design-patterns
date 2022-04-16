package com.iluwatar.SingleTableInheritance;

public class CarMapper extends AbstractVehicleMapper{
    Car find(int id){
        Car c = (Car) AbstractFind(id);
        return c;
    }
}
