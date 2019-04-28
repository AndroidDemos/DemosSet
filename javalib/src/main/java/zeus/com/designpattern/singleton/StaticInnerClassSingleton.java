package zeus.com.designpattern.singleton;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/30 17:44
 * @change time
 * @class describe  静态内部类单例模式
 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {
    }

    private static class StaticInnerClassSingletonHolder {
        private static final StaticInnerClassSingleton mInstance = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return StaticInnerClassSingletonHolder.mInstance;
    }
}
