package idlework.eegreader.neurosky.brainwaves;

import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;
import idlework.eegreader.utils.LogUtils;

public class BrainwaveDelta extends GenericSignal implements Runnable, SignalSettable {
  private static final String TAG = LogUtils.makeLogTag(BrainwaveDelta.class);

  @Override
  public void run() {
    EEGDeviceHandler.getActivityViewContract().setDelta(level);
    LogUtils.LOGD(TAG, "Control signal - Delta wave: " + level);
  }
}
