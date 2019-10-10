package com.cn.test;

/**
 * 在类的内部,变量定义的先后顺序决定了初始化的顺序.即使变量定义散布于方法定义之间,它们仍然会在任何方法(包括构造器)被调用之前得到初始化
 * 静态数据初始化,在调用前进行初始化,并且只会初始化一次
 */
public class OrderOfInitialization {
    static class Window{
        Window(int marker){
            System.out.println("Window(" + marker + ")");
        }
    }

    static class House{
        Window w1 = new Window(1);
        House(){
            System.out.println("House()");
            w3 = new Window(33);
        }
        Window w2 = new Window(2);
        void f(){
            System.out.println("f()");
        }
        Window w3 = new Window(3);
    }

    public static void main(String[] args) {
        House house = new House();
        house.f();
    }
}
