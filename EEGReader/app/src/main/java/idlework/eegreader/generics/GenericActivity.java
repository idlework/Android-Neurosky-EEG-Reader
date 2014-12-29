package idlework.eegreader.generics;

import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

import idlework.eegreader.preferences.SettingsSharedPreferences;

public abstract class GenericActivity extends FragmentActivity {

  protected SettingsSharedPreferences settingsSharedPreferences;

  @Override
  protected void onResume() {
    super.onResume();
    settingsSharedPreferences = new SettingsSharedPreferences();
    keepScreenOnIfNecessary();
  }

  protected void keepScreenOnIfNecessary() {
    if (settingsSharedPreferences.get(SettingsSharedPreferences.keepScreenTurnedOn)) {
      getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    } else {
      getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
  }
}
