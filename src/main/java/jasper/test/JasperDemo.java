package jasper.test;

import org.apache.jasper.JspC;

/**
 * Created by pine on 2016/11/26.
 */
public class JasperDemo {

    public String jspcTest(){
        String error="";
        try {
            JspC jspc = new JspC();
            //第一种方式
            String[] arg0 = {"-uriroot", "E:\\WorkTools\\tomcat\\apache-tomcat-8.0.26_2\\webapps\\ROOT2", "-d", "E:\\WorkTools\\tomcat\\apache-tomcat-8.0.26_2\\webapps\\ROOT2\\tt",
                    "-p","abcd","-smap"};
            jspc.setArgs(arg0);
            //第二种方式
      /*jspc.setUriroot("F:/apache-tomcat-6.0.43/webapps/ROOT");//web应用的root目录
      jspc.setOutputDir("F:/test");//.java文件和.class文件的输出目录
      jspc.setJspFiles("index.jsp");//要编译的jsp  */
            jspc.setCompile(true);//是否编译 false或不指定的话只生成.java文件
            jspc.execute();
        }catch(Exception e){
            error=e.toString();
        }
        return error;
    }
    public static void main(String[] args) {
        JasperDemo demo = new JasperDemo();
        demo.jspcTest();
//        System.out.println(JspUtil.makeJavaPackage("WEB_INF"));
//        System.out.println(JspUtil.makeJavaIdentifier("W_E"));
    }
}
