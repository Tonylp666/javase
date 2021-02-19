package designModel.prototype;

// 具体原型类
 class Realizetype  implements Cloneable{
    public Realizetype() {
        System.out.println("原型创建成功！！！！！！");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("原型复制成功。。。。。。。。。。。。。");
        return (Realizetype)super.clone();
    }
}

public class RealizetypeTest{
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype obj01 = new Realizetype();
        Realizetype obj02 = (Realizetype)obj01.clone();

        System.out.println("obj01 == obj02 : " + (obj01 == obj02));

    }
}
