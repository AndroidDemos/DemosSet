package zeus.com.designpattern.abstractFactory;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/30 16:27
 * @change time
 * @class describe
 */
public class Q7Factory extends CarFactory {
    @Override
    public Itire createTire() {
        return new SuvTire();
    }

    @Override
    public IEngine createEngine() {
        return new ImportEngine();
    }

    @Override
    public IBrake createBrake() {
        return new SeniorBrake();
    }
}
