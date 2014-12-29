package idlework.eegreader.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import idlework.eegreader.generics.GenericApplication;

public class SettingsSharedPreferences {
  public final static String keepScreenTurnedOn = "settingsKeepScreenTurnedOn";
  public final static String saveEegAndEyeBlinkingData = "settingsSaveEegAndEyeBlinkingData";
  public final static String enableVoiceFeedback = "settingsEnableVoiceFeedback";
  private final static String preferencesKey = "rhinofly.eegreader.preferences";
  private SharedPreferences sharedPreferences;
  private SharedPreferences.Editor sharedPreferencesEditor;

  public SettingsSharedPreferences() {
    sharedPreferences = GenericApplication.getContext().getSharedPreferences(preferencesKey, Context.MODE_PRIVATE);
    sharedPreferencesEditor = sharedPreferences.edit();
  }

  public void put(String key, boolean value) {
    sharedPreferencesEditor.putBoolean(key, value);
    sharedPreferencesEditor.commit();
  }

  public boolean get(String key) {
    return sharedPreferences.getBoolean(key, false);
  }
}
