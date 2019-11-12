package edu.liceococito.esempio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    /*
    // build.gradle (Module: app)

    dependencies {
	...
        implementation 'com.google.android.material:material:1.0.0'
	...
    }
*/

    public static final String EXTRA_MESSAGE = "edu.liceococito.esempio2.MESSAGE";
    private TextView tvName;
    private Button btSecond;
    private Button btThird;

    private static final String TAG = "MainActivity";

    private View.OnClickListener btListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btSecond: {
                    String mex = "Click su NEXT";

                    // Scrive una riga nei log, taggando il messaggio col nome dell'Activity
                    Log.d(TAG, mex);

                    /* Scrive lo stesso messaggio a video in una SnackBar
                    Una volta copiata la riga, AS chiede in automatico di aggiungere una dipendenza
                    per Gradle
                    */
                    Snackbar.make(btSecond, "Leggo il json da remoto [TODO]...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                    /* Chiama il metodo per far aprire la seconda schermata, passando parametri
                            senza aspettarsi alcuna risposta
                    */
                    openSecondActivity();

                    break;
                }
                case R.id.btThird: {
                    String mex = "Click su DELETE";

                    // Scrive una riga nei log, taggando il messaggio col nome dell'Activity
                    Log.d(TAG, mex);

                    /* Scrive lo stesso messaggio a video in una SnackBar
                    Una volta copiata la riga, AS chiede in automatico di aggiungere una dipendenza
                    per Gradle
                    */
                    Snackbar.make(btSecond, "Leggo il json da remoto [TODO]...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    break;
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);

        btSecond = findViewById(R.id.btSecond);
        btThird = findViewById(R.id.btThird);

        btSecond.setOnClickListener(btListener);
        btThird.setOnClickListener(btListener);
    }

    private void openSecondActivity() {

        String outputMex = "Starting another activity...";
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, tvName.getText());
        Log.d(TAG, outputMex);
        startActivity(intent);
    }
}
