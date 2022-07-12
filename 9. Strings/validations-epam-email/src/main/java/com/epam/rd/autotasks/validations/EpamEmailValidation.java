package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {
    public static boolean validateEpamEmail(String email) {
        if (email == null)
            return false;
        String emails = "([a-zA-Z]+_[a-zA-Z]+[0-9]*@epam\\.com)";
        Pattern pattern = Pattern.compile(emails);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}





