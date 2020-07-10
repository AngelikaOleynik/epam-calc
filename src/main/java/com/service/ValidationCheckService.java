package main.java.com.service;

import main.java.com.exception.BadInputDataException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationCheckService {
    private ParseService parseService = new ParseService();
    private String string;

    public ValidationCheckService(String string) {
        this.string = string;
    }

    public void replaceToValidate() throws BadInputDataException {
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            string = matcher.replaceAll(" ");
        }
        parseService.parse(string);
    }
}
