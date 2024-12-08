package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

public class AlarmState {
    // Constructor to initialize the state with the state view
    public AlarmState(final StopwatchStateView stateView) {
        this.stateView = stateView;
    }
  
  private final StopwatchStateView stateView;

  @Override
  public void onStartStop() {
      stateView.stopClock();   // Stop the clock
      stateView.transitionToStoppedState(); // Transition to stopped state
  }

  @Override
  public void onTick() {
      stateView.activateAlarm();  // Trigger the alarm
  }

  public void updateView() {
      stateView.refreshUIForRunningState();  // Update UI for the alarming state
  }

  @Override
  public int getId() {
      return R.string.ALARMING;  // Return the ID for the alarming state string
  }
}
