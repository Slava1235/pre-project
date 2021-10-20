package web.model;

public class Car {
    String model;
    int price;
    int age;

    public Car(String model, int price, int age) {
        this.model = model;
        this.price = price;
        this.age = age;
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
