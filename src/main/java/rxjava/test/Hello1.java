package rxjava.test;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by linjs on 2016/3/31.
 */
public class Hello1 {
    public static void main(String[] args) {
        //Observable发送“Hello,world!”消息然后完成
        Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello World!");
                subscriber.onCompleted();
            }
        });
        //创建Subscriber来消费这个数据
        Subscriber<String> mySubscriber = new Subscriber<String>() {
            public void onCompleted() {
//                System.out.println("completed");
            }

            public void onError(Throwable throwable) {

            }

            public void onNext(String s) {
                System.out.println(s);
            }
        };
        //关联
        myObservable.subscribe(mySubscriber);


        //更简洁的代码
        Observable<String> myObservable2 = Observable.just("Hello,world!");
        Action1<String> onNextAction = new Action1<String>() {
            public void call(String s) {
                System.out.println(s);
            }
        };
        myObservable2.subscribe(onNextAction);
        myObservable2.subscribe(new Action1<String>() {
            public void call(String s) {
                System.out.println(s);
            }
        });
        //lambdas表达式
        System.out.println("---lambdas----");
        Observable.just("Hello,World!").subscribe(s -> System.out.println(s));

        //Operators简单的
        Observable.just("Hello,World!").map(new Func1<String, Object>() {
            @Override
            public Object call(String s) {
                return s + " -Dan";
            }
        }).subscribe(s -> System.out.println(s));

        Observable.just("Hello,World!").map(s -> s + "-Don2")
                .map(s -> s.hashCode())
                .subscribe(System.out::print);
    }
}
