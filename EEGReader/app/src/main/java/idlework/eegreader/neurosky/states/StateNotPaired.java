package idlework.eegreader.neurosky.states;

import idlework.eegreader.R;
import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.utils.LogUtils;
import idlework.eegreader.utils.StringUtils;

public class StateNotPaired implements Runnable {
  private static final String TAG = LogUtils.makeLogTag(StateNotPaired.class);

  @Override
  public void run() {
    String message = StringUtils.getStringFromResources(R.string.device_not_paired);
    LogUtils.LOGD(TAG, message);
    EEGDeviceHandler.getActivityViewContract().setMessageFromDevice(message);
  }
}
