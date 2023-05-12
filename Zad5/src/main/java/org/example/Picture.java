package org.example;

import java.text.DecimalFormat;
import java.util.*;


public class Picture {
//    private List<Point> pointList;
//    private List<Section> sectionList;
//    private List<Circle> circleList;
    ArrayList<Figure> objects = new ArrayList<Figure>();
//    public Picture() {
//        pointList = new ArrayList<>();
//        sectionList = new ArrayList<>();
//        circleList = new ArrayList<>();
//    }

    public String toStringSortedByLabel(List<Figure> objects){
        //alfabetycznie sortuje
//        Collections.sort(objects, Comparator.comparing(Figure::getLabel));
//        List<String> sortedStrings = new ArrayList<>();
//
//        for(Figure obj: objects){
//            sortedStrings.add(obj.getLabel());
//        }
//        return String.join(", ",sortedStrings);
        StringBuilder sb = new StringBuilder();
       objects.sort(new Comparator<Figure>() {
           @Override
           public int compare(Figure o1, Figure o2) {
               return Integer.compare(o1.getLabel().length(),o2.getLabel().length());
           }
       });
        for(Figure p: objects){
            sb.append(p.toString()).append("\n");
        }

       return sb.toString();
    }
    public boolean add(Figure fig){
        if(fig instanceof Point){
            addPoint((Point) fig);
            return true;
        }
        if(fig instanceof Section){
            addSection((Section) fig);
            return true;
        }
        if(fig instanceof Circle){
            addCircle((Circle) fig);
            return true;
        }
        return false;
    }
    public void addPoint (Point pkt){
        objects.add(pkt);
    }
    public void addSection(Section line){
        objects.add(line);
    }
    public void addCircle(Circle cir){
        objects.add(cir);
    }
    public double getArea() {
        double area = 0;

        for(Object object: objects){
            if(object instanceof Circle){
                area += ((Circle) object).getArea();
            }
        }
        return area;
    }

    public void movePic(double dx,double dy){
    for(Object move: objects){
        if(move instanceof Point){
            ((Point) move).move(dx,dy);
        }if(move instanceof Section){
            ((Section) move).move(dx,dy);
        }if(move instanceof Circle){
            ((Circle) move).move(dx,dy);
        }
    }
    }
    @Override
    public String toString() {
        StringBuilder name = new StringBuilder();

        for(Object string : objects) {
            if (string instanceof Point)
                name.append(string).append("\n");
        }

        for(Object string : objects) {
            if (string instanceof Section)
                name.append(string).append("\n");
        }

        for(Object string : objects) {
            if (string instanceof Circle)
                name.append(string).append("\n");
        }
        return name.toString();
    }
}
