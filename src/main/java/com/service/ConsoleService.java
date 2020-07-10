package main.java.com.service;

import main.java.com.exception.BadInputDataException;

import java.util.Scanner;

public class ConsoleService {
    public void readLine() throws BadInputDataException {

        Scanner scanner = new Scanner(System.in);


        ValidationCheckService validationService = new ValidationCheckService(scanner.nextLine());
        validationService.replaceToValidate();
    }

    public void printResult(String result) {
        System.out.println("Ответ: " + result);
    }
}
