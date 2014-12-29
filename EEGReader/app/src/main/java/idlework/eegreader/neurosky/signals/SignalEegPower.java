package idlework.eegreader.neurosky.signals;

import android.os.Message;

import com.neurosky.thinkgear.TGEegPower;

import idlework.eegreader.neurosky.EEGDeviceHandler;
import idlework.eegreader.neurosky.GenericSignal;
import idlework.eegreader.neurosky.SignalSettable;

public class SignalEegPower extends GenericSignal implements Runnable, SignalSettable {

  public static int DELTA = 1, THETA = 2, LOW_ALPHA = 3, HIGH_ALPHA = 4, LOW_BETA = 5, HIGH_BETA = 6, LOW_GAMMA = 7, MID_GAMMA = 8;
  private TGEegPower tgEegPower;
  private Message message;
  private GenericSignal genericSignal;

  @Override
  public void run() {
    message = new Message();
    tgEegPower = (TGEegPower) object;
    setBrainWave(DELTA, tgEegPower.delta);
    setBrainWave(THETA, tgEegPower.theta);
    setBrainWave(LOW_ALPHA, tgEegPower.lowAlpha);
    setBrainWave(HIGH_ALPHA, tgEegPower.highAlpha);
    setBrainWave(LOW_BETA, tgEegPower.lowBeta);
    setBrainWave(HIGH_BETA, tgEegPower.highBeta);
    setBrainWave(LOW_GAMMA, tgEegPower.lowGamma);
    setBrainWave(MID_GAMMA, tgEegPower.midGamma);
  }

  private void setBrainWave(int brainWaveType, int brainWaveValue) {
    message.arg1 = brainWaveValue;
    EEGDeviceHandler.getBrainWaves().get(brainWaveType).message(message).run();
  }
}