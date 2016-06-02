package rxjava.test;

import rx.Observable;
import rx.Subscriber;

import java.util.Arrays;
import java.util.List;

/**
 * Created by linjs on 2016/4/13.
 */
public class Hello2 {
    //示例 没有实现 仅作参考 了解Rx
    //方法用处：这个方法根据输入的字符串返回一个网站的url列表（啊哈，搜索引擎）
   public Observable<List<String>> query(final String text){
       return Observable.create(new Observable.OnSubscribe<List<String>>() {
           @Override
           public void call(Subscriber<? super List<String>> subscriber) {
               List<String> abc = Arrays.asList(text + "a", text + "b", text + "c");
               subscriber.onNext(abc);
               subscriber.onCompleted();
           }
       });
   }
    // 返回网站的标题，如果404了就返回null
    public Observable<String> getTitle(String URL){
        if("url1b".equals(URL)){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       return Observable.just(URL+"title");
    }

    public static void main(String[] args) {
        Hello2 hello2 = new Hello2();
        //查询字符串并且显示结果
//        hello2.query("hello World1!").subscribe(urls -> {
////            for(String u : urls){
////                System.out.println(u);
////            }
//             urls.forEach(System.out::println);
//        });
//        System.out.println("-----------");
        //Observable.from()方法，它接收一个集合作为输入，然后每次输出一个元素给subscriber
//        hello2.query("hello World2!").subscribe(urls -> {
//            Observable.from(urls).subscribe(System.out::println);
//        });
//        System.out.println("-----------");
        //虽然去掉了for each循环，但是代码依然看起来很乱。
        // 多个嵌套的subscription不仅看起来很丑，难以修改，更严重的是它会破坏某些我们现在还没有讲到的RxJava的特性。
        //使用flatMap()
        //Observable.flatMap()接收一个Observable的输出作为输入，同时输出另外一个Observable
//        hello2.query("hello World3!").flatMap(new Func1<List<String>, Observable<?>>() {
//            @Override
//            public Observable<?> call(List<String> strings) {
//                return Observable.from(strings);
//            }
//        }).subscribe(url -> System.out.println(url));
        //使用lambda可以大大简化代码长度：
//        hello2.query("hello World3!").flatMap(urls -> Observable.from(urls)).subscribe(System.out::println);
//        hello2.query("hello World3!").flatMap(Observable::from).subscribe(System.out::println);
        //还可以更好
        //flatMap()实在不能更赞了，它可以返回任何它想返回的Observable对象。
//        hello2.query("url1").flatMap(urls->Observable.from(urls)).flatMap(url -> hello2.getTitle(url))
//                .subscribe(s -> System.out.println(s));
//        hello2.query("url1").flatMap(Observable::from).flatMap(hello2::getTitle).subscribe(System.out::println);

        //错误处理
        Observable<Integer> os =  Observable.just(1, 2);
        os.map(s->s+1).subscribe(System.out::println);
        System.out.println("is not change..");
        os.subscribe(System.out::println);
//        Observable.just(1,2).map(s -> hello2.error(s)).subscribe(new Subscriber<Integer>() {
//            @Override
//            public void onCompleted() {
//                System.out.println("Completed");
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                System.out.println("error:"+throwable.getCause());
//            }
//
//            @Override
//            public void onNext(Integer integer) {
//                System.out.println("integer:"+integer);
//            }
//        });
    }

    public static int error(int i){
        if(i == 2){
            throw new NullPointerException("1---error");
        }
        return i;
    }
}
