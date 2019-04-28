package zeus.com.designpattern.abstractFactory;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/30 16:23
 * @change time
 * @class describe
 */
public class SeniorBrake implements IBrake {
    @Override
    public void brake() {
        System.out.print("高级制动");
    }
}
