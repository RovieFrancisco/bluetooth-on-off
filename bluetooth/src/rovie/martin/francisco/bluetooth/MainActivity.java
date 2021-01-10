package rovie.martin.francisco.bluetooth;

import android.app.Activity;
import android.os.Bundle;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt);
        Switch sw = (Switch) findViewById(R.id.sw);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton button, boolean isChecked) {
                if (isChecked) {
                    bluetooth();
                }
                else {
                    bluetooth();
                }
            }
        });
    }

    public void bluetooth() {
        BluetoothAdapter bAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bAdapter == null) {
            txt.setText("Bluetooth is not supported");
            Toast.makeText(getApplicationContext(), "Bluetooth is not supported", Toast.LENGTH_SHORT).show();
        }
        else {
            if (!bAdapter.isEnabled()) {
                startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE), 0);
                txt.setText("Bluetooth Turned ON");
                Toast.makeText(getApplicationContext(), "Bluetooth Turned ON", Toast.LENGTH_SHORT).show();
            }
            else {
                bAdapter.disable();
                txt.setText("Bluetooth Turned OFF");
                Toast.makeText(getApplicationContext(), "Bluetooth Turned OFF", Toast.LENGTH_SHORT).show();
            }
        }
    }
}