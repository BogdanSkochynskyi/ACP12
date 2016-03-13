package ua.artcode.week5.common_resource;

/**
 * Created by serhii on 12.03.16.
 */
// Petterson Lock, also DekkerLock,
public class MyLock {

    private volatile boolean taken1;
    private volatile boolean taken2;
    private volatile int victim = 0;

    public void lockA() {
        taken1 = true;
        victim = 1;
        while (taken2 && victim == 1) ;
    }

    public void lockB() {
        taken2 = true;
        victim = 0;
        while (taken1 && victim == 0) ;
    }

    public void unlockA() {
        taken1 = false;
    }

    public void unlockB() {
        taken2 = false;
    }

}
