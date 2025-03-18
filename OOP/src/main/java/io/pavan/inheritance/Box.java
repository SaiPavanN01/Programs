package io.pavan.inheritance;

public class Box {
    double l;
    double w;
    double h;

    Box(){
        this.w=-1;
        this.h=-1;
        this.l=-1;
    }

    Box(Box box){
        this.w= box.w;
        this.l= box.l;
        this.h= box.h;
    }

    Box(double l, double w, double h){
        this.w=w;
        this.h=h;
        this.l=l;
    }
}
