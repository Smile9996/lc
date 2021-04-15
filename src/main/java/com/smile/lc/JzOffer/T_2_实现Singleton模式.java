package com.smile.lc.JzOffer;

public class T_2_实现Singleton模式 {

    public T_2_实现Singleton模式() {
    }

    /**
     * 懒汉式加载
     */
    public synchronized T_2_实现Singleton模式 getInstance() {
        return new T_2_实现Singleton模式();
    }

    /**
     * 静态内部类方式加载
     */
    public static class SingletonHandler{
        private static T_2_实现Singleton模式 t2 = new T_2_实现Singleton模式();
    }

    public T_2_实现Singleton模式 getInstance2(){
        return SingletonHandler.t2;
    }
}
