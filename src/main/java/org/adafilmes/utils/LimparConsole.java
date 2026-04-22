package org.adafilmes.utils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LimparConsole {
    public static void limparConsole() {
        limparConsole(0);
    }

    ;

    public static void limparConsole(int tempo) {

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        if (tempo > 0) {
            delay(tempo);
        }
    }

    public static void delay(int tempo) {
        try {
            Thread.sleep(tempo); /* 2000 ms = 2 segundos */
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
