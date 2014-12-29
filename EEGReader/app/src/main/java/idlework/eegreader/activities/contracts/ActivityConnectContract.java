package idlework.eegreader.activities.contracts;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public interface ActivityConnectContract {
  ImageView getBluetoothConnect();

  Handler getNextActivityHandler();

  TextView getLabel();
}
