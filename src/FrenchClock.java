/**
 * Represent the French clock class
 * @author Reda TARGAOUI
 * @since 05/10/2023
 */

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FrenchClock implements Observer {
    // Attributes :
    private final Clock clock;
    private final JLabel timeLabel;

    /**
     * Initialize object
     * @param clock clock object
     * @param timeLabel JLabel to display time in the UI
     */
    public FrenchClock(Clock clock, JLabel timeLabel) {
        this.clock = clock;
        this.timeLabel = timeLabel;
        this.clock.addObserver(this);
    }

    /**
     * Update and display the time
     */
    @Override
    public void updateDisplay() {
        LocalTime time = this.clock.getTime();
        this.timeLabel.setText(time.format(DateTimeFormatter.ofPattern("HH'h'mm")));// Update time in the UI
    }
}
