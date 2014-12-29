package idlework.eegreader.neurosky.states;

import idlework.eegreader.R;
import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.utils.LogUtils;
import idlework.eegreader.utils.StringUtils;

public class StateConnecting implements Runnable {
  private static final String TAG = LogUtils.makeLogTag(StateConnecting.class);

  @Override
  public void run() {
    String message = StringUtils.getStringFromResources(R.string.connecting_to_device);
    LogUtils.LOGD(TAG, message);
    EEGDeviceHandler.getActivityViewContract().setMessageFromDevice(message);
  }
}
