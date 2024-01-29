package gb.spring;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class VehicleTest {

    @Test
    void instanceOfVehicle(){

        Car car = new Car("BMW", "M5", 2001);
        assert(Vehicle.class.isInstance(car));

//        assertInstanceOf(Vehicle.class, car.getClass()); Это вариант возвращает исключние `cannot access java.util.function.Supplier`
//          Почему?

    }

    @Test
    void countCarWheels(){

        Car car = new Car("BMW", "M5", 2001);
        assertEquals(car.getNumWheels(), 4);

//        assertTrue(car.getNumWheels() == 4, "Не соответствует"); возникает аналогичное исключение, как в проошлом тесте `cannot access java.util.function.Supplier`

    }

    @Test
    void countMotorcucleWheels(){

        Motorcycle motorcycle = new Motorcycle("BMW", "M5", 2008);
        assertEquals(motorcycle.getNumWheels(), 2);

//        assertTrue(motorcycle.getNumWheels() == 2, "Не соответствует"); возникает аналогичное исключение, как в проошлом тесте `cannot access java.util.function.Supplier`

    }

    @Test
    void testDriveCar(){

        Car car = new Car("BMW", "M5", 2001);
        car.testDrive();
        assertEquals(car.getSpeed(), 60);
    }

    @Test
    void testDriveMotorcycle(){

        Motorcycle motorcycle = new Motorcycle("BMW", "M5", 2008);
        motorcycle.testDrive();
        assertEquals(motorcycle.getSpeed(), 75);
    }

    @Test
    void testParkCar(){

        Car car = new Car("BMW", "M5", 2001);
        car.testDrive();
        car.park();
        assertEquals(car.getSpeed(), 0);
    }

    @Test
    void testParkMotorcycle(){

        Motorcycle motorcycle = new Motorcycle("BMW", "M5", 2008);
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(motorcycle.getSpeed(), 0);
    }


}