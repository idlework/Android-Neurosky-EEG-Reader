package idlework.eegreader.neurosky.signals;

import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;
import idlework.eegreader.utils.LogUtils;

public class SignalPoorSignal extends GenericSignal implements Runnable, SignalSettable {
  private static final String TAG = LogUtils.makeLogTag(SignalPoorSignal.class);

  @Override
  public void run() {
    EEGDeviceHandler.getActivityViewContract().setSignalLevel(level);
    LogUtils.LOGD(TAG, "Control signal - Signal level: " + level);
  }
}
