package zeus.com.designpattern.abstractFactory;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/30 16:17
 * @change time
 * @class describe
 */
public class NormalBrake implements IBrake {
    @Override
    public void brake() {
        System.out.print("普通制动");
    }
}
