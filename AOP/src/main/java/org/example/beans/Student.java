package org.example.beans;

public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String   say(String text){
        System.out.println("我是"+name+"今年"+age+",我说"+text);
        return  text;
    }
    @Deprecated
    public void sayBefore(){
        System.out.println("我是过时的方法");
    }

    public void  getAround(){
        System.out.println("调用了环绕方法");
    }
}
