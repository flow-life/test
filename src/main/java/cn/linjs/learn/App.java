package cn.linjs.learn;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // 1
        StringJoiner stringJoiner = new StringJoiner(",");
        stringJoiner.add("name");
        stringJoiner.add("sex");
        System.out.println(stringJoiner.toString());
        // 2
        stringJoiner = new StringJoiner(",", "[", "]");
        stringJoiner.add("name");
        stringJoiner.add("sex");
        System.out.println(stringJoiner.toString());
        // 3
        stringJoiner = new StringJoiner(",").add("name").add("sex");
        System.out.println(stringJoiner.toString());

        // 4
        String collect = Arrays.asList("name", "sex").stream().collect(Collectors.joining(","));
        System.out.println(collect);
    }
}
