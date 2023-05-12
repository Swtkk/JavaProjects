package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StandarizedPicture extends Picture{
    private Pattern pattern = Pattern.compile("^[A-Z][A-Z0-9]*$");

    public boolean add(Figure fig){
        Matcher matcher = pattern.matcher(fig.label);
        if(matcher.matches()){
            super.add(fig);
            return true;
        }
        return false;
    }
}
