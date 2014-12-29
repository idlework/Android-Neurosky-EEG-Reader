package idlework.eegreader.neurosky;

import android.os.Handler;
import android.os.Message;

import com.neurosky.thinkgear.TGDevice;

import java.util.HashMap;
import java.util.Map;

import idlework.eegreader.generics.contracts.GenericActivitySignalContract;
import idlework.eegreader.generics.GenericApplication;
import idlework.eegreader.neurosky.brainwaves.BrainwaveAlphaHigh;
import idlework.eegreader.neurosky.brainwaves.BrainwaveAlphaLow;
import idlework.eegreader.neurosky.brainwaves.BrainwaveBetaHigh;
import idlework.eegreader.neurosky.brainwaves.BrainwaveBetaLow;
import idlework.eegreader.neurosky.brainwaves.BrainwaveDelta;
import idlework.eegreader.neurosky.brainwaves.BrainwaveGammaHigh;
import idlework.eegreader.neurosky.brainwaves.BrainwaveGammaLow;
import idlework.eegreader.neurosky.brainwaves.BrainwaveTheta;
import idlework.eegreader.neurosky.signals.SignalAttention;
import idlework.eegreader.neurosky.signals.SignalBlink;
import idlework.eegreader.neurosky.signals.SignalEegPower;
import idlework.eegreader.neurosky.signals.SignalHeartRate;
import idlework.eegreader.neurosky.signals.SignalLowBattery;
import idlework.eegreader.neurosky.signals.SignalMeditation;
import idlework.eegreader.neurosky.signals.SignalPoorSignal;
import idlework.eegreader.neurosky.signals.SignalRawCount;
import idlework.eegreader.neurosky.signals.SignalRawData;
import idlework.eegreader.neurosky.signals.SignalRawMulti;
import idlework.eegreader.neurosky.signals.SignalSleepStage;
import idlework.eegreader.neurosky.signals.SignalStateChange;
import idlework.eegreader.neurosky.states.StateConnected;
import idlework.eegreader.neurosky.states.StateConnecting;
import idlework.eegreader.neurosky.states.StateDisconnected;
import idlework.eegreader.neurosky.states.StateIdle;
import idlework.eegreader.neurosky.states.StateNotFound;
import idlework.eegreader.neurosky.states.StateNotPaired;

public final class EEGDeviceHandler extends Handler {

  private static Map<Integer, Runnable> deviceStates;
  private static Map<Integer, GenericSignal> deviceSignals;
  private static Map<Integer, GenericSignal> brainWaves;
  private static GenericActivitySignalContract activityViewContract;

  public EEGDeviceHandler() {
    initializeDeviceStates();
    initializeDeviceSignals();
    initializeBrainWaves();
  }

  public static Map<Integer, Runnable> getDeviceStates() {
    return deviceStates;
  }

  public static Map<Integer, GenericSignal> getBrainWaves() {
    return brainWaves;
  }

  public static GenericActivitySignalContract getActivityViewContract() {
    return activityViewContract;
  }

  public void setActivityViewContract(GenericActivitySignalContract activityForUiUpdates) {
    this.activityViewContract = activityForUiUpdates;
  }

  private void initializeDeviceStates() {
    deviceStates = new HashMap<Integer, Runnable>();
    deviceStates.put(TGDevice.STATE_IDLE, new StateIdle());
    deviceStates.put(TGDevice.STATE_CONNECTING, new StateConnecting());
    deviceStates.put(TGDevice.STATE_CONNECTED, new StateConnected());
    deviceStates.put(TGDevice.STATE_NOT_FOUND, new StateNotFound());
    deviceStates.put(TGDevice.STATE_NOT_PAIRED, new StateNotPaired());
    deviceStates.put(TGDevice.STATE_DISCONNECTED, new StateDisconnected());
  }

  private void initializeDeviceSignals() {
    deviceSignals = new HashMap<Integer, GenericSignal>();
    deviceSignals.put(TGDevice.MSG_STATE_CHANGE, new SignalStateChange());
    deviceSignals.put(TGDevice.MSG_POOR_SIGNAL, new SignalPoorSignal());
    deviceSignals.put(TGDevice.MSG_ATTENTION, new SignalAttention());
    deviceSignals.put(TGDevice.MSG_MEDITATION, new SignalMeditation());
    deviceSignals.put(TGDevice.MSG_BLINK, new SignalBlink());
    deviceSignals.put(TGDevice.MSG_SLEEP_STAGE, new SignalSleepStage());
    deviceSignals.put(TGDevice.MSG_LOW_BATTERY, new SignalLowBattery());
    deviceSignals.put(TGDevice.MSG_RAW_COUNT, new SignalRawCount());
    deviceSignals.put(TGDevice.MSG_RAW_DATA, new SignalRawData());
    deviceSignals.put(TGDevice.MSG_HEART_RATE, new SignalHeartRate());
    deviceSignals.put(TGDevice.MSG_RAW_MULTI, new SignalRawMulti());
    deviceSignals.put(TGDevice.MSG_EEG_POWER, new SignalEegPower());
  }

  private void initializeBrainWaves() {
    brainWaves = new HashMap<Integer, GenericSignal>();
    brainWaves.put(SignalEegPower.DELTA, new BrainwaveDelta());
    brainWaves.put(SignalEegPower.THETA, new BrainwaveTheta());
    brainWaves.put(SignalEegPower.LOW_ALPHA, new BrainwaveAlphaLow());
    brainWaves.put(SignalEegPower.HIGH_ALPHA, new BrainwaveAlphaHigh());
    brainWaves.put(SignalEegPower.LOW_BETA, new BrainwaveBetaLow());
    brainWaves.put(SignalEegPower.HIGH_BETA, new BrainwaveBetaHigh());
    brainWaves.put(SignalEegPower.LOW_GAMMA, new BrainwaveGammaLow());
    brainWaves.put(SignalEegPower.MID_GAMMA, new BrainwaveGammaHigh());
  }

  @Override
  public void handleMessage(Message msg) {
    if (GenericApplication.getEegDeviceUtils().getDevice() != null) {
      if (deviceSignals.containsKey(msg.what)) {
        deviceSignals.get(msg.what).message(msg).run();
      }
    }
  }
}
