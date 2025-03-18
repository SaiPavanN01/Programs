package io.pavan.inheritance;

public class BoxWeight extends Box{
    double weight;

    public BoxWeight() {
        this.weight=-1;
    }

    public BoxWeight(double weight){
        this.weight=weight;
    }

    public BoxWeight(double l, double w, double h, double weight) {
        // this will call the parent constructor, to initialize values present in the parent class
        super(l, w, h);
        this.weight = weight;
    }

}
