package idlework.eegreader.neurosky.brainwaves;

import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;
import idlework.eegreader.utils.LogUtils;

public class BrainwaveGammaHigh extends GenericSignal implements Runnable, SignalSettable {
  private static final String TAG = LogUtils.makeLogTag(BrainwaveGammaHigh.class);

  @Override
  public void run() {
    EEGDeviceHandler.getActivityViewContract().setMidGamma(level);
    LogUtils.LOGD(TAG, "Control signal - High Gamma wave: " + level);
  }
}
