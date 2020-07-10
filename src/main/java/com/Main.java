package main.java.com;

import main.java.com.exception.BadInputDataException;
import main.java.com.service.ConsoleService;

public class Main {
    public static void main(String[] args) throws BadInputDataException {
        System.out.println("Введите Ваше математическое выражение. Принимается строка, содержащая цифры и знаки" +
                " сложения/вычитания/деления/умножения, например, 4.2 + 2 * 3 / 3 - 6.1. " +
                "Между всеми элементами, кроме отрицательных чисел, должен стоять пробел.");
        ConsoleService consoleService = new ConsoleService();
        consoleService.readLine();

    }
}
