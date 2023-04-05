package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class zadanie {

   private double ileLitrow;
   double pojemnosc = 20;
    zadanie(double ileLitrow){
        this.ileLitrow = ileLitrow;
    }
    double getIleLitrow(){
        return  ileLitrow;
    }
    void wlej(double ilosc){

        if(pojemnosc < ilosc){
            this.ileLitrow += pojemnosc - ileLitrow;
        }else if(pojemnosc > ilosc){
        this.ileLitrow += ilosc;
        if(this.ileLitrow >pojemnosc) {
            this.ileLitrow = 20;
        }
        }
        }

    boolean wylej(double ilosc){
        if(ilosc < ileLitrow)
        this.ileLitrow -= ilosc;
        else return false;

        return true;
    }
    void przelej(double ilosc, zadanie gdzie){
       if(this.wylej(ilosc)) {
//           this.wylej((ilosc));
           gdzie.wlej((ilosc));
       }
    }
    public static void main(String[] args)  {

        zadanie[] zadanie = new zadanie[3];
        zadanie[0] = new zadanie(10);
        zadanie[1] = new zadanie(11);
        zadanie[2] = new zadanie(19);

        zadanie[1].przelej(10,zadanie[2]);
        System.out.println(zadanie[0].getIleLitrow());
        System.out.println(zadanie[1].getIleLitrow());
        System.out.println(zadanie[2].getIleLitrow());
    }
}

