package com.smile.lc.JzOffer;

public class T_1_赋值运算符函数 {

    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.setData("t1");
        T1 t2 = new T1();
        t2.setData("2");
        T1 t3 = new T1();
        t3.setData(":");
        t1.assign(t2).assign(t3);
        // a = b = c ==> a = c && b = b
        System.out.println(t1);
        System.out.println(t1.data);
        System.out.println("---------------------");
        System.out.println(t2);
        System.out.println(t2.data);
        System.out.println("---------------------");
        System.out.println(t3);
        System.out.println(t3.data);
    }

    public static class T1{

        private String data;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public T1() {
        }

        public T1 assignment(final String data) {
            //不操作传入的对象，仅在本身上修改
            if (this.data.equals(data)) {
                return this;
            }
            this.data = data;
            return this;
        }

        // 相当于等于号
        public T1 assign(final T1 t1) {
            if (this.equals(t1) || this.data.equals(t1.data)) {
                return this;
            }
            this.data = t1.data;
            return this;
        }
    }
}
