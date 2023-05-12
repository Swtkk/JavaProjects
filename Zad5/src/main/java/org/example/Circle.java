package org.example;

public class Circle extends Figure{
    private double r;
    private Point o;
    public Circle(){

    }
    public Circle(Point o, double r){
        this.o = new Point(o);
        this.r = r;
    } public Circle(Point o, double r,String label){
        this.o = new Point(o);
        this.r = r;
        this.label = label;
    }
    public Circle(Circle other){
        this.o = new Point(other.o);
        this.r = other.r;
    }public Circle(Circle other,String label){
        this.o = new Point(other.o);
        this.r = other.r;
        this.label = label;
    }
    public void move(double dx,double dy){
        this.o.move(dx,dy);
    }
    public double getArea(){
        return  Math.PI*r*r;
    }
    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                ", o=" + o +
                '}';
    }
}
