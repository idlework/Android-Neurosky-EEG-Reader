package idlework.eegreader.neurosky.brainwaves;

import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;
import idlework.eegreader.utils.LogUtils;

public class BrainwaveBetaLow extends GenericSignal implements Runnable, SignalSettable {
  private static final String TAG = LogUtils.makeLogTag(BrainwaveBetaLow.class);

  @Override
  public void run() {
    EEGDeviceHandler.getActivityViewContract().setLowBeta(level);
    LogUtils.LOGD(TAG, "Control signal - Low Beta wave: " + level);
  }
}
