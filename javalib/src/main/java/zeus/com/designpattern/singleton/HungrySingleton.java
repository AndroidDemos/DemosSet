package zeus.com.designpattern.singleton;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/30 16:53
 * @change time
 * @class describe  饿汉单例模式,在声明静态对象的时候就初始化了实例
 */
public class HungrySingleton {
    private static HungrySingleton mInstance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return mInstance;
    }
}
