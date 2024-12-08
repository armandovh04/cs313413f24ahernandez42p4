package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

public class IncrementingState implements StopwatchState{
    public IncrementingState(final StopwatchStateView stateView) {
        this.stateView = stateView;
    }
}
