package hackeru.edu.gps;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by hackeru on 02/07/2017.
 */

public class MyLocationListener implements LocationListener {

    @Override
    public void onLocationChanged(Location location) {
        Log.d("TAG", "location changed");
        Log.d("TAG", location.toString());
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
