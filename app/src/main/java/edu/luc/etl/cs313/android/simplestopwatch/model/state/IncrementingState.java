package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

public class IncrementingState implements StopwatchState{
    public IncrementingState(final StopwatchStateView stateView) {
        this.stateView = stateView;
    }

    // The state view associated with the stopwatch state
    private final StopwatchStateView stateView;
    
    // Counter for tracking ticks in the incrementing state
    private int tickCount = 0;

    @Override
    public void updateView() {
        stateView.refreshUIForRunningState(); // Update UI for incrementing state
    }

    @Override
    public int getId() {
        return R.string.Incrementing; // Return the ID for the incrementing state label
    }

    public void onStartStop() {
        stateView.incrementTime();  // Increment the time
        stateView.resetClock();     // Reset the clock
        tickCount = 0;
        
        // If the time reaches 99, trigger the alarm and transition to running state
        if (stateView.getTime() == 99) {
            stateView.activateAlarm();   // Start the alarm
            stateView.transitionToRunningState(); // Transition to running state
        }
    }

    @Override
    public void onTick() {
        // If five ticks have passed and the time is not zero, trigger the alarm and stop incrementing
        if (tickCount == 5 && stateView.getTime() != 0) {
            stateView.activateAlarm();   // Start the alarm
            stateView.transitionToRunningState(); // Transition to running state
            tickCount = 0;  // Reset tick count
        } else {
            tickCount++;  // Otherwise, increment the tick count
        }
    }
}
