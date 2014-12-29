package idlework.eegreader.utils;

import android.bluetooth.BluetoothAdapter;

import com.neurosky.thinkgear.TGDevice;

import idlework.eegreader.contracts.GenericActivitySignalContract;
import idlework.eegreader.neurosky.EEGDeviceHandler;

public class EEGDeviceUtils {
  private static TGDevice tgDevice;
  private BluetoothAdapter bluetoothAdapter;
  private EEGDeviceHandler tgDeviceHandler;
  private boolean isTGDeviceRawSignalEnabled = true;

  private boolean isDeviceConnecting() {
    return tgDevice.getState() == TGDevice.STATE_CONNECTING;
  }

  public boolean isDeviceConnected() {
    return tgDevice.getState() == TGDevice.STATE_CONNECTED;
  }

  public boolean initializeBlueToothAdapter() {
    tgDeviceHandler = new EEGDeviceHandler();
    bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (bluetoothAdapter == null) {
      return false;
    } else {
      setDevice(new TGDevice(bluetoothAdapter, tgDeviceHandler));
      return true;
    }
  }

  public TGDevice getDevice() {
    return tgDevice;
  }

  public void setDevice(TGDevice tgDevice) {
    EEGDeviceUtils.tgDevice = tgDevice;
  }

  public void reconnectToDevice() {
    initializeBlueToothAdapter();
    connectToDevice();
  }

  public void connectToDevice() {
    if (!isDeviceConnecting() && !isDeviceConnected()) {
      tgDevice.connect(isTGDeviceRawSignalEnabled);
    }
  }

  public void disconnectFromDevice() {
    if (tgDevice != null) {
      tgDevice.close();
      tgDevice = null;
    }
  }

  public boolean isBluetoothTurnedOn() {
    BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    return (mBluetoothAdapter != null && mBluetoothAdapter.isEnabled());
  }

  public void setActivityViewContract(GenericActivitySignalContract activity) {
    tgDeviceHandler.setActivityViewContract(activity);
  }
}