package uk.co.dekoorb.android.signalstrength;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText mMilliWatts;
    private EditText mDbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMilliWatts = (EditText) findViewById(R.id.et_mw);
        mDbm = (EditText) findViewById(R.id.et_dbm);

        Button btnToDbm = (Button) findViewById(R.id.btn_to_dbm);
        btnToDbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDbm();
            }
        });

        Button btnToMw = (Button) findViewById(R.id.btn_to_mw);
        btnToMw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateMilliWatts();
            }
        });
    }

    private void calculateDbm() {
        int milliWatts = Integer.parseInt(mMilliWatts.getText().toString());
        double dBm = 10 * Math.log10(milliWatts);
        mDbm.setText(String.format(Locale.UK, "%.3fdBm", dBm));
    }

    private void calculateMilliWatts() {
        int dBm = Integer.parseInt(mDbm.getText().toString());
        double milliWatts = Math.pow(10, dBm / 10.0);
        mMilliWatts.setText(String.format(Locale.UK, "%.3fmW", milliWatts));
    }
}
