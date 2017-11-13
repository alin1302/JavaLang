package figures;

public class Rectangle implements Parameters {

    double side1;
    double side2;

    public Rectangle(double arg1, double arg2) {
        this.side1 = arg1;
        this.side2 = arg2;
    }

    public void getPerimeter() {
        double P = 2 * (side1 + side2);
        System.out.println("Периметр прямоугольника равен " + P);
    }

    public void getArea() {
        double S = side1 * side2;
        System.out.println("Площадь прямоугольника равна " + S);
    }

}
