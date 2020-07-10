package main.java.com.service;

import main.java.com.exception.BadInputDataException;

import java.util.LinkedList;

public class RPNCalcService {
    private ConsoleService consoleService = new ConsoleService();

    public void calculate(LinkedList<String> polandNotation) throws BadInputDataException {

        int i = 0;
        double firstNumber;
        double secondNumber;
        String operation;
        String operationCheck;

        while (!(polandNotation.size() == 1)) {
            try {
                operationCheck = polandNotation.get(i + 2);
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("Пожалуйста, проверьте правильность ввода.");
            }

            if (!(operationCheck.equals("*") || operationCheck.equals("-") ||
                  operationCheck.equals("+") || operationCheck.equals("/"))) {
                i++;
            } else {
                try {
                    firstNumber = Double.parseDouble(polandNotation.remove(i));
                    secondNumber = Double.parseDouble(polandNotation.remove(i));
                    operation = polandNotation.remove(i);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Пожалуйста, проверьте правильность ввода.");
                }

                switch (operation) {
                    case "*":
                        polandNotation.add(i, multiply(firstNumber, secondNumber));
                        i = 0;
                        break;
                    case "+":
                        polandNotation.add(i, sum(firstNumber, secondNumber));
                        i = 0;
                        break;
                    case "-":
                        polandNotation.add(i, subtraction(firstNumber, secondNumber));
                        i = 0;
                        break;
                    case "/":
                        polandNotation.add(i, division(firstNumber, secondNumber));
                        i = 0;
                        break;
                }
            }
        }

        if (Double.valueOf(polandNotation.getFirst()).equals(Double.POSITIVE_INFINITY) ||
            Double.valueOf(polandNotation.getFirst()).equals(Double.NEGATIVE_INFINITY)) {
            throw new ArithmeticException("Деление на ноль не поддерживается");
        }
        consoleService.printResult(polandNotation.getFirst());
    }

    private String sum(double firstNum, double secondNum) {
        return firstNum + secondNum + "";
    }

    private String subtraction(double firstNum, double secondNum) {
        return firstNum - secondNum + "";
    }

    private String multiply(double firstNum, double secondNum) {
        return firstNum * secondNum + "";
    }

    private String division(double firstNum, double secondNum) {
        return firstNum / secondNum + "";
    }
}
