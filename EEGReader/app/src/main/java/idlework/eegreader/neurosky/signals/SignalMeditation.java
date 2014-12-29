package idlework.eegreader.neurosky.signals;

import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;
import idlework.eegreader.utils.LogUtils;

public class SignalMeditation extends GenericSignal implements Runnable, SignalSettable {
  private static final String TAG = LogUtils.makeLogTag(SignalMeditation.class);

  @Override
  public void run() {
    EEGDeviceHandler.getActivityViewContract().setMeditationLevel(level);
    LogUtils.LOGD(TAG, "Control signal - Meditation level: " + level);
  }
}