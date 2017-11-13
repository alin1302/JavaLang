package figures;

public class Circle implements Parameters {

    double rad;

    public Circle (double arg1) {
        this.rad = arg1;
    }

    public void getPerimeter() {
        double P = Math.PI * 2 * rad;
        System.out.println("Длина окружности равна " + P);
    }

    public void getArea() {
        double S = Math.PI * Math.pow(rad, 2);
        System.out.println("Площадь круга равна " + S);
    }
}
