package gr.wizzup.cordova.plugins.checkgps;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;

import android.location.LocationManager;
import android.provider.Settings;

public class CheckGps extends CordovaPlugin {

    @Override
    public boolean execute(String action, final JSONArray args, CallbackContext callbackContext) {
        
        PluginResult result = null;
        boolean gpsEnabled = false;
        boolean npEnabled = false;
        String GPSDetectionAction = "gpsDetection";
        String NPDetectionAction = "npDetection";
        
        if (action.equals(GPSDetectionAction)) {
            android.content.ContentResolver contentResolver = cordova.getActivity().getApplicationContext().getContentResolver();
            gpsEnabled = Settings.Secure.isLocationProviderEnabled(contentResolver, LocationManager.GPS_PROVIDER);
            result = new PluginResult(Status.OK, gpsEnabled);
        }
        
        else {
            if (action.equals(NPDetectionAction)) {
                android.content.ContentResolver contentResolver = cordova.getActivity().getApplicationContext().getContentResolver();
                npEnabled = Settings.Secure.isLocationProviderEnabled(contentResolver, LocationManager.NETWORK_PROVIDER);
                result = new PluginResult(Status.OK, npEnabled);
            }
            else {
                result = new PluginResult(Status.INVALID_ACTION);
            }
        }
        
        callbackContext.sendPluginResult(result);
        
        return true;
    }
}