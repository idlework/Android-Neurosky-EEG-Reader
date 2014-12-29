package idlework.eegreader.neurosky.brainwaves;

import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;
import idlework.eegreader.utils.LogUtils;

public class BrainwaveAlphaLow extends GenericSignal implements Runnable, SignalSettable {
  private static final String TAG = LogUtils.makeLogTag(BrainwaveAlphaLow.class);

  @Override
  public void run() {
    EEGDeviceHandler.getActivityViewContract().setLowAlpha(level);
    LogUtils.LOGD(TAG, "Control signal - Low Alpha wave: " + level);
  }
}
