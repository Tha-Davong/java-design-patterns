package com.iluwatar.SingleTableInheritance;

public class TrainMapper extends AbstractVehicleMapper{
    Train find(int id){
        Train t = (Train) AbstractFind(id);
        return t;
    }
}
