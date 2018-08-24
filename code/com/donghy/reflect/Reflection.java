package com.donghy.reflect;

import java.lang.reflect.*;

import java.util.*;

class Reflection{
     public static void main(String []args){
        System.out.println("----------------------------");
        System.out.println("Java Reflection start.");
        // getClass
        System.out.println("----------------------------");
        System.out.println("Java Reflection. getClass start.");
        System.out.println("Java Reflection getClass. part1 by getClass");
        Car car = new Car();
        Class clazz1 = car.getClass();
        System.out.println("Java Reflection getClass. part2 by .class");
        Class clazz2 = Car.class;
        Class cls1 = int.class;
        Class cls2 = String.class;

        System.out.println("Java Reflection getClass. part3 by forName");

        try {
            Class clz = Class.forName("com.donghy.reflect.Car");
            System.out.println("forName success!");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Java Reflection. getClass end.");
        System.out.println("----------------------------");
        System.out.println("Java Reflection. getName start.");
        Class name1 = null;
        try {
            name1 = Class.forName("com.donghy.reflect.Car");
            System.out.println("forName success!");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Class name2 = float.class;

        Class name3 = Void.class;

        Class name4 = new int[]{}.getClass();

        Class name5 = new Car[]{}.getClass();

        System.out.println("Java Reflection. getName start. part1 by getName.");
        System.out.println(name1.getName());
        System.out.println(name2.getName());
        System.out.println(name3.getName());
        System.out.println(name4.getName());
        System.out.println(name5.getName());
        
        System.out.println("Java Reflection. getName start. part2 by getSimpleName.");
        System.out.println(name1.getSimpleName());
        System.out.println(name2.getSimpleName());
        System.out.println(name3.getSimpleName());
        System.out.println(name4.getSimpleName());
        System.out.println(name5.getSimpleName());

        System.out.println("Java Reflection. getName start. part2 by getCanonicalName.");
        System.out.println(name1.getCanonicalName());
        System.out.println(name2.getCanonicalName());
        System.out.println(name3.getCanonicalName());
        System.out.println(name4.getCanonicalName());
        System.out.println(name5.getCanonicalName());

        System.out.println("Java Reflection. getName end.");
        System.out.println("----------------------------");

        System.out.println("Java Reflection. getModifiers start.");

        System.out.println("modifiers value:"+name1.getModifiers());
        System.out.println("modifiers :" + Modifier.toString(name1.getModifiers()));

        System.out.println("Java Reflection. getModifiers end.");
        System.out.println("----------------------------");

        System.out.println("Java Reflection. getField start.");

        Class fieldClass = Son.class;
        Son son = new Son();

        try {
            Field field = fieldClass.getDeclaredField("b");

        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("getDeclaredField "+e.getMessage());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("getDeclaredField "+e.getMessage());
        }

        try {
            Field field = fieldClass.getField("b");
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("getField "+e.getMessage());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("getField "+e.getMessage());
        }

        try {
            Field fieldc = fieldClass.getDeclaredField("c");
            fieldc.setAccessible(true);
            int rc = fieldc.getInt(son);
            System.out.println("getField.getInt : "+ rc);
            fieldc.setInt(son, 20);
            System.out.println("getField.getInt after setInt: "+ son.c);
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("getField "+e.getMessage());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("getField "+e.getMessage());
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("getField "+e.getMessage());
        }

        Field[] filed1 = fieldClass.getDeclaredFields();

        for ( Field f : filed1 ) {
            System.out.println("Declared Field :"+f.getName());
            System.out.println("Field type:"+f.getType());
            System.out.println("Field generic type:"+f.getGenericType());
        }

        Field[] filed2 = fieldClass.getFields();

        for ( Field f : filed2 ) {
            System.out.println("Field :"+f.getName());
            System.out.println("Field type:"+f.getType());
            System.out.println("Field generic type:"+f.getGenericType());
        }

        System.out.println("Java Reflection. getField end.");
        System.out.println("----------------------------");


        System.out.println("Java Reflection. getMethod start.");


        Class carClass = car.getClass();
        Method methods[] = carClass.getDeclaredMethods();

        for ( Method m : methods ) {
            System.out.println("Car method name:"+m.getName());
        } 


        System.out.println("Java Reflection. getMethod end.");
        System.out.println("----------------------------");

        System.out.println("Java Reflection. getParameters start.");

        for ( Method m : methods ) {
            System.out.println("method name:"+m.getName());

            Parameter[] paras = m.getParameters();

            for ( Parameter p : paras ) {
                System.out.println(" parameter :"+p.getName()+" "+p.getType().getName());
            }

            Class[] pTypes = m.getParameterTypes();

            System.out.println("method para types:");
            for ( Class type : pTypes ) {
                System.out.print(" "+ type.getName());
            }
            System.out.println();

            Type[] gTypes = m.getGenericParameterTypes();
            System.out.println("method para generic types:");
            for ( Type type : gTypes ) {
                System.out.print(" "+ type.getTypeName());
            }
            System.out.println();
            System.out.println("==========================================");

        } 

        System.out.println("Java Reflection. getParameters end.");
        System.out.println("----------------------------");

        System.out.println("Java Reflection. invoke start.");

        Class testCls = TestMethod.class;

        try {
            Method mStatic = testCls.getMethod("testStatic",null);
            // 测试静态方法
            mStatic.invoke(null, null);
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        TestMethod t = new TestMethod();

        try {
            Method mAdd = testCls.getDeclaredMethod("add",int.class,int.class);
            // 通过这句代码才能访问 private 修饰的 Method
            mAdd.setAccessible(true);
            int result = (int) mAdd.invoke(t, 1,2);
            System.out.println("add method result:"+result);
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            Method testExcep = testCls.getMethod("testException",null);

            try {
                testExcep.invoke(t, null);
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();

                // 通过 InvocationTargetException.getCause() 获取被包装的异常
                System.out.println("testException occur some error,Error type is :"+e.getCause().getClass().getName());
                System.out.println("Error message is :"+e.getCause().getMessage());
            }


        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    System.out.println("Java Reflection. invoke end.");
    System.out.println("----------------------------");
    }
}

final class Car {

    public int a;

    private int b;

    public void drive(int speed) {
        System.out.println("di di di,开车了！");
    }

    @Override
    public String toString() {
        return "Car toString";
    }

    public void test(String[] paraa,List<String> b,HashMap<Integer,Son> maps) {}
    
}

class Father  {
    public int a;

    private int b;
}

class Son extends Father {
    int c = 10;

    private String d;

    protected float e;

    public List<Car> cars;

    public HashMap<Integer,String> map;
}

class TestMethod {

    public static void testStatic () {
        System.out.println("test static");
    }

    private  int add (int a,int b ) {
        return a + b;
    }

    public void testException () throws IllegalAccessException {
        throw new IllegalAccessException("You have some problem.");
    }

}