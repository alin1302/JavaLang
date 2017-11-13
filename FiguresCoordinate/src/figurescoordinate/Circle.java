package figurescoordinate;

public class Circle implements Parameters {

    double x1;
    double x2;
    double y1;
    double y2;
    double rad;

    public Circle (double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        getLength();
    }
    public void getLength () {
        rad = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        System.out.println("Радиус окружности: " + rad);
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
