package ua.artcode.week5.common_resource;

/**
 * Created by serhii on 12.03.16.
 */
public class MyLock {

    private volatile boolean isLocked;

    public void lock(){
        while(isLocked){}

        isLocked = true;
    }

    public void unlock(){
        isLocked = false;
    }

}
