package figures;

public class Square implements Parameters {

    double side1;

    public Square(double arg1) {
        this.side1 = arg1;
    }

    public void getPerimeter() {
        double P = 4 * side1;
        System.out.println("Периметр квадрата равен " + P);
    }

    public void getArea() {
        double S = Math.pow(side1, 2);
        System.out.println("Площадь квадрата равна " + S);
    }
}