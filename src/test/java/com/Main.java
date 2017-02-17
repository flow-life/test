package com;


import com.google.common.hash.Hashing;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pine on 2016/12/14.
 */
public class Main {
    static void am(String a){
        a = "2";
    }
    public static void main(String[] args) {
//        boolean result = StringUtils.isEmpty("1");
//        System.out.println(StringUtils.substringMatch("abcde",1,"bcde"));
//        System.out.println(StringUtils.countOccurrencesOf("abcdeaxb","ab"));
//        System.out.println(StringUtils.containsWhitespace(new StringBuffer()));//false
//        System.out.println(StringUtils.containsWhitespace(""));//false
//        System.out.println(StringUtils.containsWhitespace(" "));//true
//        System.out.println(StringUtils.containsWhitespace(" 123"));//true
//        System.out.println(StringUtils.containsWhitespace("123"));//false
//        System.out.println(StringUtils.containsWhitespace("123 "));//true
//        System.out.println(StringUtils.containsWhitespace("12 3"));//true
//        String a = "         \u005Ct111 \u005Ct2222";
//        System.out.println(a);
//        System.out.println(StringUtils.trimLeadingWhitespace(a));
//        System.out.println(StringUtils.trimTrailingWhitespace(a));
//        System.out.println(StringUtils.replace("123456", "1", "2"));
//        System.out.println(StringUtils.deleteAny("1234516", "12345"));
//        System.out.println(StringUtils.quote("1234516"));
//        System.out.println(StringUtils.capitalize("abc.23.4516."));
//        System.out.println(StringUtils.applyRelativePath("tt.", "/22/33"));
//        System.out.println(StringUtils.cleanPath("core/../core/././io/Resource./class"));
//        System.out.println(deepArrayToString(StringUtils.tokenizeToStringArray("12,34, ,55",",",true,false)));
//        try {
//            Class c = Math.class;
//            Method m = c.getMethod("random",null);
////            System.out.println(m.getParameterTypes()[0].getName());
//            System.out.println(m.invoke(null,null));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(Math.abs(-2));
//        System.out.println(Void.class.getName());
//        System.out.println(Void.TYPE);
//        System.out.println(Byte.TYPE);
//        System.out.println(Character.TYPE);
//        System.out.println(Short.TYPE);
//        System.out.println(Integer.TYPE);
//        System.out.println(Float.TYPE);
//        System.out.println(Long.TYPE);
//        System.out.println(Double.TYPE);
//        System.out.println(Boolean.TYPE);
//        System.out.println(String.class);
//        System.out.println(Object.class.getName());
//        System.out.println(Main.class.getName());
//        System.out.println(((Integer)1).intValue());

//        System.out.println(WebUtils.extractFullFilenameFromUrlPath("a/b/index.html"));
//        Bean a = new Bean(1,"2","3");
//        Bean2 b = new Bean2(2,null,"null","4");
//        BeanUtils.copyProperties(a,b);
//        System.out.println(b);
//        sPlit("1,'2,2,2,',3,'4,4',5");
//        String[] sAry = new String[]{"1","2","3"};
//        System.out.println(StringUtils.collectionToDelimitedString(Arrays.asList(sAry),"|","[","]"));
//        System.out.println(new ToStringBuilder(new Bean(1,"2","3")).append("a","x").toString());
//        System.out.println(org.apache.commons.lang.StringUtils.stripStart("yxabc  ", "xyza"));
//        System.out.println(org.apache.commons.lang.StringUtils.join(new String[]{"1","2","5"},"x"));
//        System.out.println(org.apache.commons.lang.StringUtils.length("abcdaabe"));
//        apache_common_lang3();
//        jdk7file_nio();
//        guava_test();
//        apache_commons_beanutils();
//        apache_commons_codec();
        apache_commons_collections();
    }

    public static void apache_commons_collections(){
        List a = Arrays.asList(1,2,3);
        List b = Arrays.asList(4,5);
//        System.out.println(CollectionUtils.intersection(a,b));
//        System.out.println(Arrays.deepToString(new Object[]{1,2,3}));
    }

    public static void apache_commons_codec(){
        System.out.println(DigestUtils.md5("abcd"));
    }

    public static void apache_commons_beanutils(){
        Bean bean = new Bean(1,"a","c");
        Bean bean2 = new Bean(2,"2","2");
        try {
//            PropertyUtils.setProperty(bean,"b","232");
//            PropertyUtils.setSimpleProperty(bean, "b", "2321");
//            System.out.println(PropertyUtils.getProperty(bean, "b"));
//            System.out.println(PropertyUtils.getSimpleProperty(bean, "b"));
            BeanUtils.copyProperties(bean2, bean);
            System.out.println(bean2);
            System.out.println(bean);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void guava_test(){
//        List a = Arrays.asList(new String[]{"a", "b", "cd"});
//        System.out.println(Joiner.on('|').join("1", "2", "3"));
//        Optional<Integer> possible = Optional.of(5);
//        Optional<Integer> possible = Optional.fromNullable(5);
//        System.out.println(possible.isPresent());
//        System.out.println(possible.get());
        System.out.println(Hashing.md5());
    }
    //http://blog.csdn.net/u012152619/article/details/41721521
    public static void jdk7file_nio(){
        Path p = Paths.get("C:\\Users\\linjs\\Desktop\\test.txt");
        //相对于工作目录logs目录下的access.log;
//        Path p2 = FileSystems.getDefault().getPath("logs","access.log");
        try {
            BufferedReader reader = Files.newBufferedReader(p, StandardCharsets.UTF_8);
//            Files.newBufferedWriter() //write file BufferedWriter.write
//            System.out.println(reader.readLine());
            //delete file by path throw exception when file is not exists
//            Files.delete(p);
            //delete file by path not throw exception when file is not exists
//            Files.deleteIfExists(p);
            //copy
//            Files.copy(p,Paths.get("C:\\Users\\linjs\\Desktop\\test3.txt"));
            //read and write file
//            byte[] bb = Files.readAllBytes(p);
//            System.out.println("--->" + new String(bb));
//            System.out.println("/////");
//            List<String> list =Files.readAllLines(p, StandardCharsets.UTF_8);
//            list.forEach(System.out::println);
            //createFile
//            Files.create**();
            //loop file tree
            Files.walkFileTree(Paths.get("C:\\Users\\linjs\\Desktop"),new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("File:" + file.toString());
                    return super.visitFile(file, attrs);
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    System.out.println("Dir:" + dir.toString());
                    return super.postVisitDirectory(dir, exc);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void apache_common_lang3(){
//        System.out.println(IEEE754rUtils.min(1,2,3,4,5));
//        System.out.println(NumberUtils.isDigits("0x12"));
//        System.out.println(NumberUtils.isCreatable("+0X12F"));
//        MutableInt mi = new MutableInt();
//        mi.increment();
//        mi.add(2);
//        System.out.println(mi.getValue());
//        System.out.println(ArrayUtils.toString(new Object[]{1, 2, "34"}));
        System.out.println(RandomStringUtils.randomAscii(4));
        System.out.println(RandomStringUtils.random(4));
        System.out.println(RandomStringUtils.randomAlphabetic(4));
        System.out.println(RandomStringUtils.randomGraph(4));
        System.out.println(RandomStringUtils.randomNumeric(4));
        System.out.println(RandomStringUtils.randomPrint(4));
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
        return sb.toString();
    }

    public static void sPlit(String s){
        String[] ins = s.split(",");
        int ls = ins.length;
        for(int i = 0; i < ins.length; i++){
            if((ins[i].charAt(0) == 39 && !ins[i].endsWith("\'")) || (ins[i].charAt(0) == 39 && ins[i].length() == 1)){
                StringBuilder tsb = new StringBuilder(ins[i]);
                while(i < ls){
                    tsb.append(",");
                    i++;
                    tsb.append(ins[i]);
                    if(ins[i].endsWith("\'")){
                        break;
                    }
                }
                System.out.println("-->"+tsb);
                continue;
            }
            System.out.println(ins[i]);
        }
    }

}
