package idlework.eegreader.neurosky.signals;

import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;
import idlework.eegreader.utils.LogUtils;

public class SignalAttention extends GenericSignal implements Runnable, SignalSettable {
  private static final String TAG = LogUtils.makeLogTag(SignalAttention.class);

  @Override
  public void run() {
    EEGDeviceHandler.getActivityViewContract().setAttentionLevel(level);
    LogUtils.LOGD(TAG, "Control signal - Attention level: " + level);
  }
}
