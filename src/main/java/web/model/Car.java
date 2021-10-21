package web.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
    private String model;
    private int price;
    private int age;
    private static List<Car> carList = new ArrayList<>(Arrays.asList(new Car("Lada", 250000, 2010),
            new Car("BMW", 3000000, 2019),
            new Car("Volvo", 450000, 2006),
            new Car("Tesla", 5000000, 2020),
            new Car("Patriot", 500, 2021))
    );

    public Car(String model, int price, int age) {
        this.model = model;
        this.price = price;
        this.age = age;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", age=" + age +
                '}';
    }
}
