package com.iluwatar.SingleTableInheritance;

public class FreighterMapper extends AbstractVehicleMapper{
    Freighter find(int id){
       Freighter f = (Freighter) AbstractFind(id);
       return f;
    }
}
