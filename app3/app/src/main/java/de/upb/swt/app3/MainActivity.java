package de.upb.swt.app3;

import android.bluetooth.BluetoothManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean onlyWifi = isConfig();
        if (onlyWifi) {
            System.out.print("ONLY WIFI");
        }
        onlyWifi = false;
        LocationManager location = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (location.getAllProviders().size() > 0) {
            return;
        }
        int sdk= Build.VERSION.SDK_INT;
        if(sdk>20)
            if(sdk<30)
                return;
    }

    public boolean isConfig() {
        WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        boolean wifi_on = wifi.isWifiEnabled();
        if (wifi_on) {
            BluetoothManager bluetooth = (BluetoothManager) getSystemService(BLUETOOTH_SERVICE);
            boolean bluetooth_on = bluetooth.getAdapter().isEnabled();
            if (!bluetooth_on) {
                return true;
            }
        }
        return false;
    }
}
