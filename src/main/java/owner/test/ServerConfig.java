package owner.test;

import org.aeonbits.owner.Config;

/**
 * Created by linjs on 2016/3/29.
 * 不加@Config.Sources 默认寻找同等类路径下的同名的文件
 */
//@Config.Sources("classpath:ServerConfig.properties")
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:ServerConfig.properties","classpath:ServerConfig2.properties"})
public interface ServerConfig extends Config {
    @Key("port")  //对应属性文件里面的key 没有的话默认方法名 当然如果key不存在还是去获取default（default值没设置则会报nullpoint）
    @DefaultValue("8080") //没有的话--》默认值
    int port();
}
