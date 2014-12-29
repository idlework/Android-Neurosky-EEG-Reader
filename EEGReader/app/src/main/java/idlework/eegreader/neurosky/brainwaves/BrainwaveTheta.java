package idlework.eegreader.neurosky.brainwaves;

import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;
import idlework.eegreader.utils.LogUtils;

public class BrainwaveTheta extends GenericSignal implements Runnable, SignalSettable {
  private static final String TAG = LogUtils.makeLogTag(BrainwaveTheta.class);

  @Override
  public void run() {
    EEGDeviceHandler.getActivityViewContract().setTheta(level);
    LogUtils.LOGD(TAG, "Control signal - Theta wave: " + level);
  }
}
