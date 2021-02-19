package guava.basicUtilities;


import com.google.common.base.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Student student = new Student();
//        student.setName("xiaohua");
        /**
         *  Optional.of(T)	创建指定引用的Optional实例，若引用为 null 则快速失败
         *  Optional.fromNullable(T)	创建指定引用的Optional实例，若引用为 null 则表示缺失
         *
         *  Optional.absent()	创建引用缺失的Optional实例
         */
        String name = student.getName();
        Optional<String> optional = Optional.fromNullable(name);
//        Optional<String> optional = Optional.of(name);
        if (optional.isPresent()){
            // not null
            System.out.println(name);
        }else {
            System.out.println("NUll");
        }
    }

    private static class Student {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
