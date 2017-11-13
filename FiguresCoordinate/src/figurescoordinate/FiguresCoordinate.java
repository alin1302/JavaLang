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
        Square square = null;
        Rectangle rectangle = null;
        Circle circle = null;
        Triangle triangle = null;

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Параметры какой фигуры вычислить? \n1) Квадрат \n2) Прямоугольник \n3) Круг \n4) Треугольник");
            try {
                char figure = in.nextLine().charAt(0);
                if (figure == '1') {
                    System.out.println("Введите координаты стороны квадрата:");
                    String sides = in.nextLine();
                    double[] sqr = new double[4];
                    sqr = getSides(sides);
                    if (square == null) {
                        square = new Square(sqr[0], sqr[1], sqr[2], sqr[3]);
                        square.getPerimeter();
                        square.getArea();
                    }
                    else
                    {
                        if (sqr[0]==square.x1 && sqr[1]==square.y1 && sqr[2]==square.x2 && sqr[3]==square.y2)
                            System.out.println("Эта фигура была вычислена ранее!");
                        else
                        {
                            square = new Square(sqr[0], sqr[1], sqr[2], sqr[3]);
                            square.getPerimeter();
                            square.getArea();
                        }
                    }
                }
                if (figure == '2') {
                    System.out.println("Введите координаты сторон прямоугольника:");
                    String sides = in.nextLine();
                    double[] rect = new double[6];
                    rect = getSides(sides);
                    if (rectangle == null) {
                        rectangle = new Rectangle(rect[0], rect[1], rect[2], rect[3], rect[4], rect[5]);
                        rectangle.getPerimeter();
                        rectangle.getArea();
                    }
                    else
                    {
                        if (rect[0]==rectangle.x1 && rect[1]==rectangle.y1 && rect[2]==rectangle.x2 && rect[3]==rectangle.y2 && rect[4]==rectangle.x3 && rect[5]==rectangle.y3)
                            System.out.println("Эта фигура была вычислена ранее!");
                        else
                        {
                            rectangle = new Rectangle(rect[0], rect[1], rect[2], rect[3], rect[4], rect[5]);
                            rectangle.getPerimeter();
                            rectangle.getArea();
                        }
                    }
                }
                if (figure == '3') {
                    System.out.println("Введите координаты центра и точки на окружности:");
                    String sides = in.nextLine();
                    double[] circ = new double[4];
                    circ = getSides(sides);
                    if (circle == null) {
                        circle = new Circle(circ[0], circ[1], circ[2], circ[3]);
                        circle.getPerimeter();
                        circle.getArea();
                    }
                    else
                    {
                        if (circ[0]==circle.x1 && circ[1]==circle.y1 && circ[2]==circle.x2 && circ[3]==circle.y2)
                            System.out.println("Эта фигура была вычислена ранее!");
                        else
                        {
                            circle = new Circle(circ[0], circ[1], circ[2], circ[3]);
                            circle.getPerimeter();
                            circle.getArea();
                        }
                    }
                }
                if (figure == '4') {
                    System.out.println("Введите координаты сторон треугольника:");
                    String sides = in.nextLine();
                    double[] trian = new double[6];
                    trian = getSides(sides);
                    if (triangle == null) {
                        triangle = new Triangle(trian[0], trian[1], trian[2], trian[3], trian[4], trian[5]);
                        triangle.getPerimeter();
                        triangle.getArea();
                    }
                    else
                    {
                        if (trian[0]==triangle.x1 && trian[1]==triangle.y1 && trian[2]==triangle.x2 && trian[3]==triangle.y2 && trian[4]==triangle.x3 && trian[5]==triangle.y3)
                            System.out.println("Эта фигура была вычислена ранее!");
                        else
                        {
                            triangle = new Triangle(trian[0], trian[1], trian[2], trian[3], trian[4], trian[5]);
                            triangle.getPerimeter();
                            triangle.getArea();
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Вы ввели некорректные данные! Повторите снова");
            }
        }
    }
}