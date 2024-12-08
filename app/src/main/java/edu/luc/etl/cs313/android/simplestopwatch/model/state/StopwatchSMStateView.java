package edu.luc.etl.cs313.android.simplestopwatch.model.state;

/**
 * The restricted view states have of their surrounding state machine.
 * This is a client-specific interface in Peter Coad's terminology.
 *
 * @author laufer
 */
interface StopwatchStateView {

    // transitions
    void transitionToRunningState();
    void transitionToStoppedState();
    void transitionToLapRunningState();
    void transitionToLapStoppedState();

    // actions
    void initialize();
    void resetTime();
    void startClock();
    void stopClock();
    void incrementTime();
    void decrementTime();
    void updateView();

    // state-dependent UI updates
    void refreshUIForRunningState();
    void activateAlarm();
    int getTime();
}
