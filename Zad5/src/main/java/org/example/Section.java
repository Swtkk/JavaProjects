package org.example;

public class Section extends Figure{
    private Point p1;
    private Point p2;
    public Section() {
    }
    public Section(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }public Section(Point p1, Point p2,String label) {
        this.p1 = p1;
        this.p2 = p2;
        this.label = label;
    }
    public Section(Section other,String label){
        this.p1 = new Point(other.p1);
        this.p2 = new Point(other.p2);
        this.label = label;
    }
    public void move (double dx, double dy){
        this.p1.move(dx,dy);
        this.p2.move(dx,dy);
    }
    public int getArea(){
        return 0;
    }
    @Override
    public String toString() {
        return "Section{" +
                "p1=" + p1.toString() +
                ", p2=" + p2.toString() +
                '}';
    }
}
