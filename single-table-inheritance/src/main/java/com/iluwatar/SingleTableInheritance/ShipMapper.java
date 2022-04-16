package com.iluwatar.SingleTableInheritance;

public class ShipMapper extends AbstractVehicleMapper{
    Ship find(int id) {
        Ship s = (Ship) AbstractFind(id);
        return s;
    }
}
