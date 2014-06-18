package gr.wizzup.cordova.plugins.checkgps;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.location.LocationManager;
import android.provider.Settings;

public class CheckGps extends CordovaPlugin {

    @Override
    public boolean execute(String action, final JSONArray args, CallbackContext callbackContext) {
        
        PluginResult result = null;
        boolean gpsEnabled = false;
        boolean npEnabled = false;
        String AllDetectionAction = "allDetection";
        String GPSDetectionAction = "gpsDetection";
        String NPDetectionAction = "npDetection";
        JSONObject settings = new JSONObject();
        
        if (action.equals(AllDetectionAction)) {
            android.content.ContentResolver contentResolver = cordova.getActivity().getApplicationContext().getContentResolver();
            gpsEnabled = Settings.Secure.isLocationProviderEnabled(contentResolver, LocationManager.GPS_PROVIDER);
            npEnabled = Settings.Secure.isLocationProviderEnabled(contentResolver, LocationManager.NETWORK_PROVIDER);
            try {
                settings.put("gps", gpsEnabled);
                settings.put("np",  npEnabled);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            result = new PluginResult(Status.OK, settings.toString());
        } else {
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
        }
        
        callbackContext.sendPluginResult(result);
        
        return true;
    }
}