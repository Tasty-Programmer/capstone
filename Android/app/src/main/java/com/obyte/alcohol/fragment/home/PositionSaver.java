package com.obyte.alcohol.fragment.home;

public class PositionSaver {
    private static int realPosition = 1000;

    public static void setRealPosition(int realPosition) {
        PositionSaver.realPosition = realPosition;
    }

    public static int getRealPosition() {
        return realPosition;
    }
}
