package com.examination;
interface A {
    final Double PI = 3.14;
    double area();
}
interface B {
    void setColor(String c);
}
interface C extends A, B {
    void volume();
}
class Cylinder implements C {
    Double radius;
    Double height;
    String color;
    @Override
    public double area() {
        return (2*radius*PI*height) + (radius*radius*PI*2);
    }
    @Override
    public void setColor(String c) {
        this.color = c;
    }
    @Override
    public void volume() {
        System.out.println("圆柱体体积为："+radius * radius * PI * height);
    }
}
public class Main {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        cylinder.height = 10.0;
        cylinder.radius = 5.0;
        cylinder.setColor("Blue");
        cylinder.volume();
        System.out.println("圆柱体表面积为:"+cylinder.area());
        System.out.println("圆柱体颜色为:"+cylinder.color);
    }
}

