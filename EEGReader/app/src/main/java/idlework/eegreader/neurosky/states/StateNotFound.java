package idlework.eegreader.neurosky.states;

import idlework.eegreader.R;
import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.utils.LogUtils;
import idlework.eegreader.utils.StringUtils;

public class StateNotFound implements Runnable {
  private static final String TAG = LogUtils.makeLogTag(StateNotFound.class);

  @Override
  public void run() {
    String message = StringUtils.getStringFromResources(R.string.device_not_found);
    LogUtils.LOGD(TAG, message);
    EEGDeviceHandler.getActivityViewContract().setMessageFromDevice(message);
  }
}