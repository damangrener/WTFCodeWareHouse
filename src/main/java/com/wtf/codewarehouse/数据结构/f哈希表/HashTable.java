package com.wtf.codewarehouse.数据结构.f哈希表;

public class HashTable {
    private static StudentInfo[] data=new StudentInfo[100];

    public void put(StudentInfo studentInfo){
        int index=studentInfo.hashCode();
        data[index]=studentInfo;
    }

    public static StudentInfo get(StudentInfo studentInfo){
        return data[studentInfo.hashCode()];
    }

    public static void main(String[] args) {
        StudentInfo stu1=new StudentInfo(16,3);
        StudentInfo stu2=new StudentInfo(17,11);
        StudentInfo stu3=new StudentInfo(18,23);
        StudentInfo stu4=new StudentInfo(19,24);
        StudentInfo stu5=new StudentInfo(20,9);

        HashTable ht=new HashTable();
        ht.put(stu1);
        ht.put(stu2);
        ht.put(stu3);
        ht.put(stu4);
        ht.put(stu5);

        StudentInfo target=new StudentInfo(18);
        StudentInfo result=get(target);
        System.out.println(result);
    }
}
