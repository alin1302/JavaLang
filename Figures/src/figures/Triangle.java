package figures;

public class Triangle implements Parameters {

    double side1;
    double side2;
    double side3;

    public Triangle(double arg1, double arg2, double arg3) {
        this.side1 = arg1;
        this.side2 = arg2;
        this.side3 = arg3;
    }

    public void getPerimeter() {
        double P = side1 + side2 + side3;
        System.out.println("Периметр треугольника равен " + P);
    }

    public void getArea() {
        double p = (side1 + side2 + side3)/2;
        double S = Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
        System.out.println("Площадь треугольника равна " + S);
    }
}
