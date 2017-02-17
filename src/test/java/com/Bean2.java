package com;

/**
 * Created by pine on 2016/12/28.
 */
public class Bean2 {
    private int a;
    private String b;
    private String c;
    private String d;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public Bean2(int a, String b, String c,String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bean2{");
        sb.append("a=").append(a);
        sb.append(", b='").append(b).append('\'');
        sb.append(", c='").append(c).append('\'');
        sb.append(", d='").append(d).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
