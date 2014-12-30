package idlework.eegreader.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import idlework.eegreader.R;
import idlework.eegreader.generics.GenericActivity;
import idlework.eegreader.generics.GenericApplication;

public class SplashScreenActivity extends GenericActivity {

  private Handler nextActivityHandler = new Handler();
  private Runnable startNextActivity = new Runnable() {
    @Override
    public void run() {
      finish();
      startActivity(new Intent(GenericApplication.getContext(), ConnectActivity.class));
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_splash_screen);
    nextActivityHandler.postDelayed(startNextActivity, 2500);
  }
}
