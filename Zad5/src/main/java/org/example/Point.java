package org.example;

public class Point extends Figure {
    protected double x;
    protected double y;
    public Point() {
        this.x=0;
        this.y=0;
    }
    public Point(double x, double y) {
        this.x =x;
        this.y = y;
    }public Point(double x, double y,String label) {
        this.x =x;
        this.y = y;
        this.label = label;
    }

    public Point(Point pkt){
        this.x = pkt.x;
        this.y = pkt.y;

    }public Point(Point pkt,String label){
        this.x = pkt.x;
        this.y = pkt.y;
        this.label = label;
    }
    public void move(double dx, double dy){
        this.x += dx;
        this.y += dy;
    }
    public int getArea(){
        return 0;
    }
    @Override
    public String toString() {
        return "Point["+label+"]" +
                "(x=" + x +
                ", y=" + y +
                ')';
    }
}
