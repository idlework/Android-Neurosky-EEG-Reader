package idlework.eegreader.neurosky.states;

import idlework.eegreader.R;
import idlework.eegreader.generics.GenericApplication;
import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.utils.LogUtils;
import idlework.eegreader.utils.StringUtils;

public class StateConnected implements Runnable {
  private static final String TAG = LogUtils.makeLogTag(StateConnected.class);

  @Override
  public void run() {
    GenericApplication.getEegDeviceUtils().getDevice().start();
    String message = StringUtils.getStringFromResources(R.string.connected_to_device);
    LogUtils.LOGD(TAG, message);
    EEGDeviceHandler.getActivityViewContract().setMessageFromDevice(message);
  }
}