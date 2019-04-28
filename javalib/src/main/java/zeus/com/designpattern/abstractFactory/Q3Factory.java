package zeus.com.designpattern.abstractFactory;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/30 16:26
 * @change time
 * @class describe
 */
public class Q3Factory extends CarFactory {
    @Override
    public Itire createTire() {
        return new NormalTire();
    }

    @Override
    public IEngine createEngine() {
        return new DomesticEngine();
    }

    @Override
    public IBrake createBrake() {
        return new NormalBrake();
    }
}
