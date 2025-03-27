package pl.edu.pjwstk.s30900.pawkoz.L1;

public class PlainOldJavaObject {

    private String name;
    private int age;

    public PlainOldJavaObject() {
    }

    public PlainOldJavaObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
