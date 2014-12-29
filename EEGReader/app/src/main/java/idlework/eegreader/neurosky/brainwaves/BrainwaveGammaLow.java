package idlework.eegreader.neurosky.brainwaves;

import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;
import idlework.eegreader.utils.LogUtils;

public class BrainwaveGammaLow extends GenericSignal implements Runnable, SignalSettable {
  private static final String TAG = LogUtils.makeLogTag(BrainwaveGammaLow.class);

  @Override
  public void run() {
    EEGDeviceHandler.getActivityViewContract().setLowGamma(level);
    LogUtils.LOGD(TAG, "Control signal - Low Gamma wave: " + level);
  }
}