package idlework.eegreader.neurosky.brainwaves;

import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;
import idlework.eegreader.utils.LogUtils;

public class BrainwaveBetaHigh extends GenericSignal implements Runnable, SignalSettable {
  private static final String TAG = LogUtils.makeLogTag(BrainwaveBetaHigh.class);

  @Override
  public void run() {
    EEGDeviceHandler.getActivityViewContract().setHighBeta(level);
    LogUtils.LOGD(TAG, "Control signal - High Beta wave: " + level);
  }
}