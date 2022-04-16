package com.iluwatar.SingleTableInheritance;

public class TrainMapper extends AbstractVehicleMapper<Train>{
    Train find(int id){
        Train t = (Train) AbstractFind(id);
        return t;
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
