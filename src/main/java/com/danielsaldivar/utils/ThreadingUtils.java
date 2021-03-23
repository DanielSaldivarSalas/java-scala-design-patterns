package com.danielsaldivar.utils;

public class ThreadingUtils {
    public static boolean sleep(int ms){
        try {
            Thread.sleep(1000);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
