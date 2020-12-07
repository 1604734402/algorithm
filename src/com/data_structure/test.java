package com.data_structure;

public class test {

    public static void main(String[] args) {

        int x;
        for (x = 5; x > 0; x--) {

            if(x--<5){
                System.out.printf("%d",x);
            }else {
                System.out.printf("%d",x++);
            }

        }
    }
}

class Testaaa<Testbbb> {

    private Testbbb node;

    public Testaaa(Testbbb a){
        this.node = a;
    }


    public Testbbb getNode() {
        return node;
    }

    public void setNode(Testbbb node) {
        this.node = node;
    }
}

class Testbbb<B>{
    private B node;

    public Testbbb(B node){
        this.node = node;
    }


    public B getNode() {
        return node;
    }

    public void setNode(B node) {
        this.node = node;
    }
}