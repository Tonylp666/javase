package jvm.reflect;

/**
 *  liping
 *
 */
public class GetClass {
    public static void main(String[] args) {

        //method 01
        Class<Student> aClass = Student.class;
        System.out.println(aClass.getName());

        //method 02
        Student student = new Student();

        Class<? extends Student> aClass1 = student.getClass();
        System.out.println(aClass1.getName());

        //method 03
        try {
            Class<?> aClass2 = Class.forName("jvm.reflect.Student");
            System.out.println("aClass.hashCode()"+aClass.hashCode());
            System.out.println("aClass1.hashCode()"+aClass1.hashCode());
            System.out.println("aClass2.hashCode()"+aClass2.hashCode());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
class Student{
    int age;
    String name;

    @Override
    public String toString() {
        return "student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
