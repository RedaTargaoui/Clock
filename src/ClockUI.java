/**
 * Represent the user interface UI class
 * @author Reda TARGAOUI
 * @since 18/10/2023
 */

import javax.swing.*;
import java.awt.*;

public class ClockUI {
    private final Clock clock;
    private final FrenchClock frenchClock;
    private final AngloSaxonClock angloSaxonClock;
    private final JLabel frenchTimeLabel;
    private final JLabel angloSaxonTimeLabel;

    /**
     * Initialize object and creates an instance of the Clock and sets up the French and Anglo-Saxon time labels
     */
    public ClockUI() {
        clock = Clock.getInstance();// Get the only instance of the Clock class
        // Create labels to display the time formats :
        this.frenchTimeLabel = new JLabel();
        this.angloSaxonTimeLabel = new JLabel();
        // Create the time format classes :
        this.frenchClock = new FrenchClock(clock, this.frenchTimeLabel);
        this.angloSaxonClock = new AngloSaxonClock(clock, this.angloSaxonTimeLabel);
        // Create UI and start updating the time :
        createUI();
        synchronizeClock();
    }

    /**
     * Creates the graphical user interface for displaying the French and Anglo-Saxon time formats
     */
    private void createUI() {
        // Create the frame :
        JFrame frame = new JFrame("Clock UI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));

        // Create a panel for every time format :
        JPanel frenchPanel = new JPanel();
        frenchPanel.add(new JLabel("French Time: "));
        frenchPanel.add(this.frenchTimeLabel);
        frame.add(frenchPanel);

        JPanel angloSaxonPanel = new JPanel();
        angloSaxonPanel.add(new JLabel("Anglo-Saxon Time: "));
        angloSaxonPanel.add(this.angloSaxonTimeLabel);
        frame.add(angloSaxonPanel);

        // Set the size and position of the window :
        frame.setSize(400, 100);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    /**
     * Starts a thread to update the clock time continuously
     */
    private void synchronizeClock() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000); // Sleep for 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    clock.synchronize();// Update the time
                }
            }
        });
        thread.start();
    }

}