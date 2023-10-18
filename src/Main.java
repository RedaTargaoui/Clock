/**
 * Represent the main class
 * @author Reda TARGAOUI
 * @since 05/10/2023
 */

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClockUI();
            }
        });
    }
}
