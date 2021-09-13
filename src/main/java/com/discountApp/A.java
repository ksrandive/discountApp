package com.discountApp;

public class A {
    public void display(){
        System.out.println("A");
    }
}

class B extends A{
    public void display(){
        System.out.println("B");
    }

    public void print(){
        System.out.println("print B");
    }
}

class C extends B{
    public void display(){
        System.out.println("C");
    }
}
class main{
    public static void main(String[] args){
        A a = new A();
        a.display();

        A a1 = new B();
        a1.display();

        B b = new C();
        b.display();
    }
}
