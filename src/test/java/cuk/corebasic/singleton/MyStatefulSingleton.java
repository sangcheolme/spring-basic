package cuk.corebasic.singleton;

public class MyStatefulSingleton {

    private static MyStatefulSingleton instance;
    private int count; //상태 유지 필드

    private MyStatefulSingleton() {}

    public static MyStatefulSingleton getInstance() {
        if (instance == null) {
            instance = new MyStatefulSingleton();
        }
        return instance;
    }

    public void incrementCount() {
        count++; //여기가 문제
    }

    public int getCount() {
        return count;
    }
}
