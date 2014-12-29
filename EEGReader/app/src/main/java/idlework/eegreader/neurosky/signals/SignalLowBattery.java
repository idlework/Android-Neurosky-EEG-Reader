package idlework.eegreader.neurosky.signals;

import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;
import idlework.eegreader.utils.LogUtils;

public class SignalLowBattery extends GenericSignal implements Runnable, SignalSettable {
  private static final String TAG = LogUtils.makeLogTag(SignalLowBattery.class);

  @Override
  public void run() {
    LogUtils.LOGD(TAG, "Battery level is low.");
  }
}