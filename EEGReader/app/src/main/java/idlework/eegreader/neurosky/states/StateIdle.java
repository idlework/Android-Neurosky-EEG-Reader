package idlework.eegreader.neurosky.states;

import idlework.eegreader.R;
import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.utils.LogUtils;
import idlework.eegreader.utils.StringUtils;

public class StateIdle implements Runnable {
  private static final String TAG = LogUtils.makeLogTag(StateIdle.class);

  @Override
  public void run() {
    String message = StringUtils.getStringFromResources(R.string.device_is_idle);
    LogUtils.LOGD(TAG, message);
    EEGDeviceHandler.getActivityViewContract().setMessageFromDevice(message);
  }
}
