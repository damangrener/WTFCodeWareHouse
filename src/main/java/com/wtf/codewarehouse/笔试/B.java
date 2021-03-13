package com.wtf.codewarehouse.笔试;

public class B extends A {
//    private void methodA(int y){}
//    void methodA(int y){}
//    protect void methodA(int y){
//    }
//            public void methodA(int y){}
void method(){
//    System.out.println(x);
    System.out.println(y);
    System.out.println(z);
}
    public void methodA ()
    {
        System.out.println(10/3) ;
    }

    public static void main(String[] args) {
//        B b=new B();
//        b.method();
//        A a = new B() ;
//        a. methodA () ;
        int v1=10,v2=99,v3=0;
        int a=v2/v3;
//        System.out.println((v1<0)&&(v2/v3)==3);
        System.out.println(a);

        int[] arr={1,3,5,7,9,0,2,4,6,8};
for(int i=0;i<arr.length-1;i++){
for(int j=0;j<arr.length-1-i;j++){
if(arr[j]>arr[j+1]){
int temp=arr[j];
arr[j]=arr[j+1];
arr[j+1]=temp;
}
}
}
    }
}
