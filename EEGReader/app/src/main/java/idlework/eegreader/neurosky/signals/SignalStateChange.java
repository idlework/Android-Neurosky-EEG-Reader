package idlework.eegreader.neurosky.signals;

import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;

public class SignalStateChange extends GenericSignal implements Runnable, SignalSettable {
  @Override
  public void run() {
    if (EEGDeviceHandler.getDeviceStates().containsKey(level)) {
      EEGDeviceHandler.getDeviceStates().get(level).run();
    }
  }
}