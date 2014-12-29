package idlework.eegreader.neurosky.signals;

import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;
import idlework.eegreader.utils.LogUtils;

public class SignalSleepStage extends GenericSignal implements Runnable, SignalSettable {
  private static final String TAG = LogUtils.makeLogTag(SignalSleepStage.class);

  @Override
  public void run() {
    LogUtils.LOGD(TAG, "Control signal - Sleep Stage level: " + level);
  }
}
