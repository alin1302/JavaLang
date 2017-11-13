package figures;
import java.util.Scanner;

public class Figures {

    public static double[] getSides(String sides) {
        double[] result = new double[3];
        StringBuilder str = new StringBuilder("");
        int count = 0;
        for (int i = 0; i < sides.length(); i++) {
            if (sides.charAt(i) != ' ') {
                str.append(sides.charAt(i));
            }
            if (sides.charAt(i) == ' ') {
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
                System.out.println("Введите сторону квадрата:");
                Square square = new Square(Double.parseDouble(in.nextLine()));
                square.getPerimeter();
                square.getArea();
            }
            if (figure == '2') {
                System.out.println("Введите стороны прямоугольника:");
                String sides = in.nextLine();
                double[] rect = new double[3];
                rect = getSides(sides);
                Rectangle rectangle = new Rectangle(rect[0], rect[1]);
                rectangle.getPerimeter();
                rectangle.getArea();
            }
            if (figure == '3') {
                System.out.println("Введите радиус окружности:");
                Circle circle = new Circle(Double.parseDouble(in.nextLine()));
                circle.getPerimeter();
                circle.getArea();
            }
            if (figure == '4') {
                System.out.println("Введите стороны треугольника:");
                String sides = in.nextLine();
                double[] trian = new double[3];
                trian = getSides(sides);
                Triangle triangle = new Triangle(trian[0], trian[1], trian[2]);
                triangle.getPerimeter();
                triangle.getArea();
            }
        }
        catch (Exception e) {
            System.out.println("Вы ввели некорректные данные! Повторите снова");
        }
    }
}
