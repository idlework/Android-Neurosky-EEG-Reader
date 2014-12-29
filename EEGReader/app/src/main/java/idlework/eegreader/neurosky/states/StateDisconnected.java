package idlework.eegreader.neurosky.states;

import idlework.eegreader.R;
import idlework.eegreader.utils.LogUtils;
import idlework.eegreader.utils.StringUtils;

public class StateDisconnected implements Runnable {
  private static final String TAG = LogUtils.makeLogTag(StateDisconnected.class);

  @Override
  public void run() {
    String message = StringUtils.getStringFromResources(R.string.disconnected_from_device);
    LogUtils.LOGD(TAG, message);
  }
}