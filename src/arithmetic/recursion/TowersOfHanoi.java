package arithmetic.recursion;

public class TowersOfHanoi {
    long count = 0;
    public static void main(String[] args) {
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
        towersOfHanoi.hanoi(3,'A','B','C');
        System.out.println(towersOfHanoi.count);
    }
    public void hanoi(int num,char from,char temp,char to){
        if (num == 0){
            return;
        }
        hanoi(num - 1, from, to, temp);// 将 n-1 个从 A 塔 移动到 B 塔
        move(num,from,to);//将第 n 个 移动到 C 塔
        hanoi(num - 1, temp, from, to); // 将 n-1 个从 B 塔 移动到 C 塔

    }
    public void move(int index,char form,char to ){
        count++;
        System.out.println("第 "+count+" 次移动， 将 " +index +" 从 "+ form +" 移动到 " + to);
    }
}
