package main.java.com.service;

import main.java.com.exception.BadInputDataException;

import java.util.LinkedList;
import java.util.Stack;

public class ParseService {
    private RPNCalcService rpnCalcService = new RPNCalcService();
    private LinkedList<String> rpnLinkedLIst = new LinkedList<>();
    private Stack<String> operations = new Stack<>();

    public void parse(String line) throws BadInputDataException {
        String[] symbols = line.split("\\s+");

        for (String element : symbols) {
            int priority = getPriority(element);
            if (priority == 0) {
                rpnLinkedLIst.add(element);
            } else if (priority == 1) {
                operations.push(element);
            } else if (priority > 1) {
                while (!operations.isEmpty()) {
                    if (getPriority(operations.peek()) >= priority) {
                        rpnLinkedLIst.add(operations.pop());
                    } else {
                        break;
                    }
                }
                operations.push(element);
            }

            if (priority == -1) {
                while (getPriority(operations.peek()) != 1) {
                    rpnLinkedLIst.add(operations.pop());
                }
                operations.pop();
            }
        }

        while (!operations.empty()) {
            rpnLinkedLIst.add(operations.pop());
        }
        rpnCalcService.calculate(rpnLinkedLIst);
    }

    public int getPriority(String operation) {

        if (operation.equals("*") || operation.equals("/")) {
            return 3;
        } else if (operation.equals("+") || operation.equals("-")) {
            return 2;
        } else if (operation.equals("(")) {
            return 1;
        } else if (operation.equals(")")) {
            return -1;
        } else {
            return 0;
        }
    }
}
