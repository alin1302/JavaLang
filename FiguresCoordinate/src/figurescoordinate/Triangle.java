package figurescoordinate;

public class Triangle implements Parameters {

    double x1;
    double x2;
    double x3;
    double y1;
    double y2;
    double y3;
    double side1;
    double side2;
    double side3;

    public Triangle (double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        getLength();
    }
    public void getLength () {
        side1 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        side2 = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        side3 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        System.out.println("Стороны прямоугольника: " + side1 + " " + side2 + " " + side3);
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
