package zeus.com.designpattern.singleton;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/30 17:48
 * @change time
 * @class describe
 */

interface EnumSingleton {
    void doSomething();
}

public enum SingletonEnum implements EnumSingleton {

    INSTANCE {
        @Override
        public void doSomething() {
        }
    };

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
