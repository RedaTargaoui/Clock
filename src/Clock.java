/**
 * Represent the clock class
 * @author Reda TARGAOUI
 * @since 05/10/2023
 */

import java.time.LocalTime;
import java.util.ArrayList;

public class Clock {
    // Attributes :
    private LocalTime time;
    private static Clock instance;
    private final ArrayList<Observer> observers;// To contain observers (FrenchClock and AngloSaxonClock)

    /**
     * Initialize object
     */
    private Clock() {
        observers = new ArrayList<>();
        setTime();
    }

    /**
     * To assure only one instance of this class (Singleton pattern)
     * @return the instance of the class
     */
    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    /**
     * Get time
     * @return time
     */
    public LocalTime getTime() {
        return this.time;
    }

    /**
     * To set the time
     */
    private void setTime() {
        this.time = LocalTime.now();
    }

    /**
     * Add an observer
     * @param observer the observer to add
     */
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    /**
     * Notify every observer
     */
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.updateDisplay();
        }
    }

    /**
     * To move the time and notify observers
     */
    public void synchronize() {
        this.time = time.plusSeconds(1);
        notifyObservers();
    }
}
