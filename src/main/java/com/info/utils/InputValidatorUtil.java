package com.info.utils;

import java.util.Scanner;

public class InputValidatorUtil {
    Scanner prompt = new Scanner(System.in);

    public String newPrompt(String txt) {
        System.out.println(txt);
        String input = prompt.nextLine().toUpperCase();
        return input;
    }

    // Ints
    public int validateInt(String txt, String alertTxt, int min, int max) {
        String input = newPrompt(txt);
        while (!isValidNumber(input, min, max)) {
            input = newPrompt(alertTxt);
        }

        return Integer.parseInt(input);
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidNumber(String input, int min, int max) {
        if (isNumber(input)) {
            int intInput = Integer.parseInt(input);
            if (intInput >= min && intInput <= max) {
                return true;
            }
        }
        return false;
    }

    // Strings
    public String validateString(String txt, String alertTxt, int min, int max) {
        String input = newPrompt(txt);
        while (!isValidString(input, min, max)) {
            input = newPrompt(alertTxt);
        }
        return input;
    }

    private boolean isValidString(String input, int min, int max) {
        if (input.matches("^[a-zA-Z ]+$") && input.length() >= min && input.length() <= max) {
            return true;
        }
        return false;
    }
}
