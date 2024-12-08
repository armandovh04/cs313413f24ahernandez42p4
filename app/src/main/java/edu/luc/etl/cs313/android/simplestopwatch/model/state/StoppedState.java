package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import android.util.Log;
import edu.luc.etl.cs313.android.simplestopwatch.R;

class StoppedState implements StopwatchState {

    public StoppedState(final StopwatchStateView stateView) {
        this.stateView = stateView;
    }

    private final StopwatchStateView stateView;

    @Override
    public void onStartStop() {
        stateView.transitionToIncrementingState();  // Transition to incrementing state
        stateView.incrementTime();                   // Increment time
        stateView.startClock();                      // Start the clock
    }

    @Override
    public void onTick() {
        // No action needed on tick in the stopped state
        System.out.println(111);
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.STOPPED;
    }
}
