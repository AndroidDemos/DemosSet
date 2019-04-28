package zeus.com.designpattern.builder;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/30 11:22
 * @change time
 * @class describe Builder模式
 */
public class MyData {
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id: " + this.id + ", name: " + this.name;
    }

    public static class Builder {
        private int id;
        private String name;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public MyData create() {
            MyData myData = new MyData();
            myData.setId(this.id);
            myData.setName(this.name);
            return myData;
        }
    }

    public static void main(String[] args) {
        System.out.print(new MyData.Builder().setId(1).setName("瑟瑟琵琶").create().toString());
    }
}
