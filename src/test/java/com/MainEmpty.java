package com;


import java.util.Stack;

/**
 * Created by pine on 2017/1/13.
 */
public class MainEmpty {

    public static void main(String[] args) throws Exception {
        Stack<String> a = new Stack<>();
        a.push("1");
        a.push("2");
        a.push("3");
        for(String t : a){
            System.out.println(t);
        }
        System.out.println(a.pop());
        System.out.println(a);
    }


    public static String deepArrayToString(String[] a){
        if(a == null){
            return null;
        }
        int  length = a.length;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length;i++){
            sb.append(a[i]);
            if(i < length - 1){
                sb.append("|");
            }
        }
        System.out.println(sb);
        return sb.toString();
    }
}
