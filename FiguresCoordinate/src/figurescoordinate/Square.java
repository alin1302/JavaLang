package figurescoordinate;

public class Square implements Parameters {

    double x1;
    double x2;
    double y1;
    double y2;
    double side1;

    public Square (double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        getLength();
    }
    public void getLength () {
        side1 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        System.out.println("Сторона квадрата: " + side1);
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
