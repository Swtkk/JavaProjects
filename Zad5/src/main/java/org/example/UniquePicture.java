package org.example;

public class UniquePicture extends Picture{
    public boolean add(Figure fig) {
        for(Object object: objects){
            if (fig.label.equals(((Figure) object).label))
            return false;
        }
        super.add(fig);
        return true;
    }
}
