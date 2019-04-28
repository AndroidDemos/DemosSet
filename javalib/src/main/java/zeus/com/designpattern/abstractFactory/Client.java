package zeus.com.designpattern.abstractFactory;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/30 16:28
 * @change time
 * @class describe
 */
public class Client {
    public static void main(String[] args) {
        //构造一个生产Q3的工厂
        CarFactory q3Factory= new Q3Factory();
        q3Factory.createBrake().brake();
        q3Factory.createEngine().engine();
        q3Factory.createTire().tire();

        System.out.print("\n");
        System.out.print("-----------------");
        System.out.print("\n");
        //构造一个生产Q7的工厂
        CarFactory q7Factory= new Q7Factory();
        q7Factory.createBrake().brake();
        q7Factory.createEngine().engine();
        q7Factory.createTire().tire();
    }
}
