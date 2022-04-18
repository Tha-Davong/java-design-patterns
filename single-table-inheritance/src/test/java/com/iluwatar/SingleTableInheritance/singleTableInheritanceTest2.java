package com.iluwatar.SingleTableInheritance;

import com.iluwatar.SingleTableInheritance.ClassObject.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for App class.
 */
//Run App.java before run the test cases
public class singleTableInheritanceTest2 {
    @Test
    public void testfind(){
        VehicleMapper vm = new VehicleMapper();
        Vehicle v = vm.find(1);
        Assert.assertEquals("Car", v.getClass().getSimpleName());
        v = vm.find(2);
        Assert.assertEquals("Train", v.getClass().getSimpleName());
        v = vm.find(3);
        Assert.assertEquals("Freighter", v.getClass().getSimpleName());
        v = vm.find(4);
        Assert.assertEquals("Ship", v.getClass().getSimpleName());
        v = vm.find(-1);
        Assert.assertNull(v);
    }

    @Test
    public void testdelete(){
        VehicleMapper vm = new VehicleMapper();
        Vehicle c = vm.insert(new Car());
        vm.Delete(c);
        Vehicle v = vm.find(c.getIdVehicle());
        Assert.assertNull(v);
    }

    @Test
    public void testupdate(){
        VehicleMapper vm = new VehicleMapper();
        Train t = (Train) vm.insert(new Train());
        Train inserted = (Train) vm.find(t.getIdVehicle());
        Assert.assertEquals(0, inserted.getNoOfCarriages());
        t.setNoOfCarriages(20);
        vm.update(t);
        Train updated = (Train) vm.find(t.getIdVehicle());
        Assert.assertEquals(20, updated.getNoOfCarriages());
    }

    @Test
    public void testInsert(){
        VehicleMapper vm = new VehicleMapper();
        Car c = new Car();
        vm.insert(c);
        Vehicle v = vm.find(c.getIdVehicle());
        Assert.assertNotNull(v);
    }


}