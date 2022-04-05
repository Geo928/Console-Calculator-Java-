package calculator;

public class Calculator {
    private final Converter converter;

    public Calculator() {
        this.converter = new Converter();
    }

    public String calculate(String [] args) throws CalculatorException {
        if (args.length < 3) {
            throw new CalculatorException("Введите выражение через пробел");
        }
        try {
            int result = calculate(Integer.parseInt(args[0]), Integer.parseInt(args[2]), args[1]);
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            int result = calculate (converter.toArabic(args[0]), converter.toArabic(args[2]), args[1]);
            return converter.toRoman(result);
        }
    }

    private int calculate(int first, int second, String arithmetic) throws CalculatorException {
        if (first < 0 || first > 10 || second < 0 || second > 10) {
            throw new CalculatorException("Калькулятор принимает только числа " +
                    "от 0 до 10 включительно и от I до X включительно");
        }
        if (arithmetic.equals("/") && second == 0) {
            throw new CalculatorException("На ноль делить нельзя");
        }
        return switch (arithmetic) {
            case "+" -> first + second;
            case "/" -> first / second;
            case "*" -> first * second;
            case "-" -> first - second;
            default ->  throw new CalculatorException("Неверный формат данных");
        };
    }
}
