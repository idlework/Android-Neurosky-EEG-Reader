package idlework.eegreader.neurosky.signals;

import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;
import idlework.eegreader.utils.LogUtils;

public class SignalBlink extends GenericSignal implements Runnable, SignalSettable {
  private static final String TAG = LogUtils.makeLogTag(SignalBlink.class);

  @Override
  public void run() {
    EEGDeviceHandler.getActivityViewContract().setBlinkLevel(level);
    LogUtils.LOGD(TAG, "Control signal - Blink level: " + level);
  }
}