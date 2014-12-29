package idlework.eegreader.utils;

import idlework.eegreader.generics.GenericApplication;

public class StringUtils {
  public static String getStringFromResources(int resourcesId) {
    return GenericApplication.getContext().getResources().getString(resourcesId);
  }
}
