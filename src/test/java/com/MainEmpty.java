package com;


/**
 * Created by pine on 2017/1/13.
 */
public class MainEmpty {
    public static void main(String[] args) {
//        String json = "{\"@type\":\"java.lang.Runtime\",\"$ref\":\"$.runtime.exec\"}";
//        String json = "{\"@type\":\"com.AS\",\"test\":{\"@type\":\"com.BS\",\"name\":\"zzzzzzxx\"}}";
//        String json = "{\"@type\":\"com.AS\",\"test\":{\"@type\":\"com.xx.xx\"}}";
//        Object obj = JSON.parseObject(json,AS.class);
//        System.out.println(obj);
//        System.out.println(obj);
//        String a = "\r";
//        String b = "\u0001";
//        System.out.println(a == b);

//        try {
//            Runtime.getRuntime().exec("calc");
//            new ProcessBuilder("calc").start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        getLong();
    }

    private static long getLong(){
        return 0l;
    }

//    {
        //        Throwable ex = new Throwable();
//        System.out.println(Thread.currentThread().getStackTrace()[1].getLineNumber());
//        StackTraceElement[] stackElements = ex.getStackTrace();
//
//        if(stackElements != null)
//        {
//            for(int i = 0; i < stackElements.length; i++)
//            {
//                System.out.println(stackElements[i].getClassName());
//                System.out.println(stackElements[i].getFileName());
//                System.out.println(stackElements[i].getLineNumber());
//                System.out.println(stackElements[i].getMethodName());
//                System.out.println("-----------------------------------");
//            }
//        }
//    }

//    public static String deepArrayToString(String[] a){
//        if(a == null){
//            return null;
//        }
//        int  length = a.length;
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < length;i++){
//            sb.append(a[i]);
//            if(i < length - 1){
//                sb.append("|");
//            }
//        }
//        System.out.println(sb);
//        return sb.toString();
//    }

}
//class AS{
//    private String a;
////    @JSONCreator
////    public AS(@JSONField String a,@JSONField int b){
////        System.out.println("init...");
////    }
//    public void setTest(Object obj){
//        System.out.println("invoke Set msg:" + obj);
//    }
//}
//class BS{
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}