package idlework.eegreader.activities.controllers;

import android.util.Log;
import android.view.View;

import idlework.eegreader.R;
import idlework.eegreader.activities.contracts.ActivityConnectContract;
import idlework.eegreader.utils.StringUtils;

public class ConnectController {

  private ActivityConnectContract activity;

  public ConnectController(ActivityConnectContract activity) {
    setActivity(activity);
  }

  public void setActivity(ActivityConnectContract activity) {
    this.activity = activity;
  }

  private boolean isConnectedToDeviceMessageReceived(String message) {
    return message.equals(StringUtils.getStringFromResources(R.string.connected_to_device));
  }

  private boolean isConnectingToDeviceMessageReceived(String message) {
    return message.equals(StringUtils.getStringFromResources(R.string.connecting_to_device));
  }

  private boolean isConnectionErrorMessageReceived(String message) {
    return (message.equals(StringUtils.getStringFromResources(R.string.device_not_paired)) ||
      message.equals(StringUtils.getStringFromResources(R.string.device_is_idle)) ||
      message.equals(StringUtils.getStringFromResources(R.string.device_not_found)));
  }

  public void establishConnection(String message, Runnable startNextActivity) {
    if (isConnectingToDeviceMessageReceived(message)) {
      activity.getBluetoothConnect().setImageResource(R.drawable.activity_connect_bluetooth_yellow);
    }

    if (isConnectedToDeviceMessageReceived(message)) {
      activity.getBluetoothConnect().setImageResource(R.drawable.activity_connect_bluetooth_green);
      activity.getLabel().setVisibility(View.VISIBLE);
      activity.getNextActivityHandler().postDelayed(startNextActivity, 2500);
    } else if (isConnectionErrorMessageReceived(message)) {
      activity.getBluetoothConnect().setImageResource(R.drawable.activity_connect_bluetooth_red);
    }
  }
}
