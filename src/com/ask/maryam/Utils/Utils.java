package com.ask.maryam.Utils;

public class Utils {

    /**
     * Java method to return random integer between 0 and
     * given number.
     * @param max the given number.
     * @return random integer between 0 and given number.
     */
    public static int getRandom(int max){
        return (int) (Math.random()*max);
    }


    /**
     * Returns random integer between minimum and maximum range
     * @param maximum
     * @param minimum
     * @return
     */
    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

    //String str = String.format("%04d", 9);

}
