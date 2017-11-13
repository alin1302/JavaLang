package figurescoordinate;

import java.util.Scanner;

public class FiguresCoordinate {

    public static double[] getSides(String sides) {
        double[] result = new double[6];
        StringBuilder str = new StringBuilder("");
        int count = 0;
        for (int i = 0; i < sides.length(); i++) {
       //     if ((sides.charAt(i) != ' ') || (sides.charAt(i) != ',')){
            if (sides.charAt(i) != ' '){
                str.append(sides.charAt(i));
            }
            if (sides.charAt(i) == ' '){
                result[count] = Double.parseDouble(str.toString());
                count++;
                str.delete(0, str.length());
            }
        }
        result[count] = Double.parseDouble(str.toString());
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Параметры какой фигуры вычислить? \n1) Квадрат \n2) Прямоугольник \n3) Круг \n4) Треугольник");
        try {
            char figure = in.nextLine().charAt(0);
            if (figure == '1') {
                System.out.println("Введите координаты стороны квадрата:");
                String sides = in.nextLine();
                double[] sqr = new double[4];
                sqr = getSides(sides);
                Square square = new Square(sqr[0], sqr[1], sqr[2], sqr[3]);
                square.getPerimeter();
                square.getArea();
            }
            if (figure == '2') {
                System.out.println("Введите координаты сторон прямоугольника:");
                String sides = in.nextLine();
                double[] rect = new double[6];
                rect = getSides(sides);
                Rectangle rectangle = new Rectangle(rect[0], rect[1], rect[2], rect[3], rect[4], rect[5]);
                rectangle.getPerimeter();
                rectangle.getArea();
            }
            if (figure == '3') {
                System.out.println("Введите координаты центра и точки на окружности:");
                String sides = in.nextLine();
                double[] circ = new double[4];
                circ = getSides(sides);
                Circle circle = new Circle(circ[0], circ[1], circ[2], circ[3]);
                circle.getPerimeter();
                circle.getArea();
            }
            if (figure == '4') {
                System.out.println("Введите стороны треугольника:");
                String sides = in.nextLine();
                double[] trian = new double[6];
                trian = getSides(sides);
                Triangle triangle = new Triangle(trian[0], trian[1], trian[2], trian[3], trian[4], trian[5]);
                triangle.getPerimeter();
                triangle.getArea();
            }
        }
        catch (Exception e) {
            System.out.println("Вы ввели некорректные данные! Повторите снова");
        }
    }
}