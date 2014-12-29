package idlework.eegreader.neurosky.signals;

import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;
import idlework.eegreader.utils.LogUtils;

public class SignalRawData extends GenericSignal implements Runnable, SignalSettable {
  private static final String TAG = LogUtils.makeLogTag(SignalRawData.class);

  @Override
  public void run() {
    EEGDeviceHandler.getActivityViewContract().setRawData(level);
    LogUtils.LOGD(TAG, "Control signal - Raw data: " + level);
  }
}
