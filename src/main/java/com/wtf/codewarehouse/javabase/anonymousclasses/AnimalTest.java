package com.wtf.codewarehouse.javabase.anonymousclasses;

/**
 * @author wangtengfei
 * @since 2020/8/3 14:16
 */
public class AnimalTest {
    private final String Animal = "动物";
    public void accessTest(){
        System.out.println("匿名内部类访问其外部类方法");
    }
    Animal bird=new Animal("布谷鸟"){
      @Override
      public void printAnimalName(){
        accessTest();
        System.out.println(Animal);
        super.printAnimalName();
      }
    };
    public void print(){
        bird.printAnimalName();
    }
    class Animal{
        private String name;
        public Animal (String name){
            this.name=name;
        }

        public void printAnimalName(){
            System.out.println(bird.name);
        }
    }

    public static void main(String[] args) {
        AnimalTest animalTest = new AnimalTest();
        animalTest.print();
    }
}
