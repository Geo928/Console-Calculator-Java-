package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Калькулятор принимает арабские и римские числа");
        System.out.println("Числа от 0 до 10 включительно и от I до X включительно");
        System.out.println("Введите выражение. Числа и знак должны быть разделены пробелом");
        System.out.println("--------------------------------------------------------------");

        try (Scanner sc = new Scanner(System.in)) {
            String result = new Calculator().calculate(sc.nextLine().trim().split(" "));
            System.out.println(result);
        } catch (CalculatorException c) {
            System.out.println("Ошибка! " + c);
        } catch (Exception e) {
            System.out.println("Неверный формат данных");
        }
    }
}
