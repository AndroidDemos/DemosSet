package zeus.com.designpattern.abstractFactory;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/30 16:24
 * @change time
 * @class describe
 */
public abstract class CarFactory {

    public abstract Itire createTire();

    public abstract IEngine createEngine();

    public abstract IBrake createBrake();
}
