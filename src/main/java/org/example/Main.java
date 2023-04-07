package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Picture picture = new Picture();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Dodaj punkt");
            System.out.println("2. Dodaj odcinek");
            System.out.println("3. Dodaj okrąg");
            System.out.println("4. Wyświetl obraz");
            System.out.println("5. Przesuń obraz");
            System.out.println("6. Wyświetl sumę pól");
            System.out.println("0. Wyjście");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Podaj x: ");
                    double x = scanner.nextDouble();
                    System.out.print("Podaj y: ");
                    double y = scanner.nextDouble();
                    scanner.nextLine();

                    Point point = new Point(x, y);
                    picture.addPoint(point);
                    break;
                case 2:
                    System.out.println("Podaj punkt początkowy:");
                    System.out.print("x1: ");
                    double x1 = scanner.nextDouble();
                    System.out.print("y1: ");
                    double y1 = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Podaj punkt końcowy:");
                    System.out.print("x2: ");
                    double x2 = scanner.nextDouble();
                    System.out.print("y2: ");
                    double y2 = scanner.nextDouble();
                    scanner.nextLine();

                    Point start = new Point(x1, y1);
                    Point end = new Point(x2, y2);
                    Section section = new Section(start, end);
                    picture.addSection(section);
                    break;
                case 3:
                    System.out.print("Podaj środek okręgu:\n");
                    System.out.print("x: ");
                    double cx = scanner.nextDouble();
                    System.out.print("y: ");
                    double cy = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Podaj promień: ");
                    double r = scanner.nextDouble();
                    scanner.nextLine();

                    Point center = new Point(cx, cy);
                    Circle circle = new Circle(center, r);
                    picture.addCircle(circle);
                    break;
                case 4:
                    System.out.println(picture.toString());
                    break;
                case 5:
                    System.out.print("Podaj wektor przesunięcia:\n");
                    System.out.print("dx: ");
                    double dx = scanner.nextDouble();
                    System.out.print("dy: ");
                    double dy = scanner.nextDouble();
                    scanner.nextLine();

                    picture.move(dx, dy);
                    break;
                case 6:
                    System.out.println("Suma pól obiektów w obrazie: " + picture.getArea());
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja");
                    break;
            }
        }
    }

}


class Point{

    private double x;
    private double y;

    public Point(){
        this.x = 0;
        this.y = 0;

    }
    public Point(double x, double y){
    this.x = x;
    this.y = y;
    }

    public Point(Point pkt){
       this.x= pkt.x;
       this.y = pkt.y;
    }

    public void move(double dx,double dy){
        this.x += dx;
        this.y +=dy;
    }
    public String toString(){
        return "Point :("+this.x+","+this.y+")";
    }
    public double getArea(){
        return 0;
    }

}

class Section{
    private Point p1;
    private Point p2;
    public Section(){
        this.p1 = new Point();
        this.p2 = new Point();
    }

    public Section(Point p1,Point p2){
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
    }
    public Section(Section sec){
        this.p1 = new Point(sec.p1);
        this.p2 = new Point(sec.p2);
    }
    public void move(double dx,double dy){
        p1.move(dx,dy);
        p2.move(dx,dy);
    }
    public String toString(){
        return "Section:["+this.p1.toString()+","+this.p2.toString()+"]";
    }
    public double getArea(){
        return 0;
    }
}

class Circle{
    private Point o;

    public double getR() {
        return this.r;
    }

    private double r;
    public Circle(){
        this.o = new Point();
        this.r = 0;
    }
    public Circle(Point o, double r){
        this.o = o;
        this.r = r;
    }
    public Circle(Circle cir){
        this.o = new Point(cir.o);
        this.r = cir.r;
    }
    public void move(double dx,double dy){
        this.o.move(dx,dy);
    }
    public String toString(){
        return "Circle center:"+this.o.toString()+" Circle radius:"+this.r;
    }
    public double getArea(){
        return Math.PI*this.r*this.r;
    }
}

class Picture{

    private List<Point> pointList;
    private List<Section> sectionList;
    private List<Circle> circleList;

    public Picture(){
        this.pointList = new ArrayList<>();
        this.sectionList = new ArrayList<>();
        this.circleList = new ArrayList<>();
    }
    public void addPoint(Point pkt){
        this.pointList.add(pkt);
    }public void addSection(Section sect){
        this.sectionList.add(sect);
    }public void addCircle(Circle circ){
        this.circleList.add(circ);
    }

    public List<Point> getPointList() {
        return this.pointList;
    }


    public List<Section> getSectionList() {
        return this.sectionList;
    }

    public List<Circle> getCircleList() {
        return this.circleList;
    }
    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public void setCircleList(List<Circle> circleList) {
        this.circleList = circleList;
    }

    public void move(double dx,double dy){
        for(Point pkt: pointList){
            pkt.move(dx,dy);
        }
        for(Section sec: sectionList){
            sec.move(dx,dy);
        }
        for(Circle cir: circleList){
            cir.move(dx,dy);
        }
    }
    public String toString(){
        StringBuilder string = new StringBuilder();
        for(Point pkt: pointList){
            string.append(pkt).append("\n");
        }for(Section sec: sectionList){
            string.append(sec).append("\n");
        }for(Circle cir: circleList){
            string.append(cir).append("\n");
        }

        return string.toString();
    }
    public double getArea(){
        double area=0;
        //Pominieto klasy Point i Section ze wzgledu na zerowe powierzchnie
        for(Circle cir: this.circleList){
            area+= Math.PI*cir.getR()* cir.getR();
        }
        return area;
    }
}







