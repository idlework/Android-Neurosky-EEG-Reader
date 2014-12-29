package idlework.eegreader.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import idlework.eegreader.R;
import idlework.eegreader.activities.contracts.ActivityConnectContract;
import idlework.eegreader.activities.controllers.ConnectController;
import idlework.eegreader.generics.GenericActivity;
import idlework.eegreader.generics.GenericApplication;
import idlework.eegreader.generics.contracts.GenericActivitySignalContract;
import idlework.eegreader.utils.StringUtils;

public class ConnectActivity extends GenericActivity implements ActivityConnectContract, GenericActivitySignalContract {

  private ConnectController connectController;

  private Handler nextActivityHandler;

  private ImageView bluetoothConnect;
  private TextView labelConnect;

  private Runnable startNextActivity = new Runnable() {
    @Override
    public void run() {
      finish();
      startActivity(new Intent(GenericApplication.getContext(), MainActivity.class));
    }
  };

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Log.d("ConnectActivity", "onCreate");

    nextActivityHandler = new Handler();
    bluetoothConnect = (ImageView)findViewById(R.id.bluetooth_connect);
    labelConnect = (TextView)findViewById(R.id.label_connect);
  }

  @Override
  protected void onResume() {
    super.onResume();
    connectController = new ConnectController(this);

    if (!GenericApplication.getEegDeviceUtils().initializeBlueToothAdapter()) {
      Toast.makeText(this, StringUtils.getStringFromResources(R.string.bluetooth_is_not_available), Toast.LENGTH_LONG).show();
    } else {
      GenericApplication.getEegDeviceUtils().setActivityViewContract(this);
    }
  }

  public void bluetoothConnectClickHandler(View view) {
    if (GenericApplication.getEegDeviceUtils().isBluetoothTurnedOn()) {
      GenericApplication.getEegDeviceUtils().connectToDevice();
    } else {
      Toast.makeText(this, StringUtils.getStringFromResources(R.string.please_activate_bluetooth), Toast.LENGTH_LONG).show();
    }
  }

  @Override
  public ImageView getBluetoothConnect() {
    return bluetoothConnect;
  }

  @Override
  public Handler getNextActivityHandler() {
    return nextActivityHandler;
  }

  @Override
  public TextView getLabel() {
    return labelConnect;
  }

  @Override
  public void setMessageFromDevice(String string) {
    labelConnect.setText(string);
    connectController.establishConnection(string, startNextActivity);
  }

  @Override
  public void setAttentionLevel(int level) {

  }

  @Override
  public void setMeditationLevel(int level) {

  }

  @Override
  public void setBlinkLevel(int level) {

  }

  @Override
  public void setRawData(int level) {

  }

  @Override
  public void setDelta(int level) {

  }

  @Override
  public void setTheta(int level) {

  }

  @Override
  public void setLowAlpha(int level) {

  }

  @Override
  public void setHighAlpha(int level) {

  }

  @Override
  public void setLowBeta(int level) {

  }

  @Override
  public void setHighBeta(int level) {

  }

  @Override
  public void setLowGamma(int level) {

  }

  @Override
  public void setMidGamma(int level) {

  }
}
