package zeus.com.designpattern.singleton;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/30 17:38
 * @change time
 * @class describe  懒汉单例模式
 */
public class LazySingleton {
    private static LazySingleton mInstance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (mInstance == null) {
            mInstance = new LazySingleton();
        }
        return mInstance;
    }
}
