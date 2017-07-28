package de.upb.swt.app1;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final int sdk = Build.VERSION.SDK_INT;
    final String manufacturer = Build.MANUFACTURER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView firstTextView = (TextView) findViewById(R.id.firstText);
        final Button firstButton = (Button) findViewById(R.id.firstButton);
        final Button secondButton = (Button) findViewById(R.id.secondButton);
        //simple if-branch example
        if (sdk >= 20) {
            System.out.print("sdk>=20");
        } else {
            System.out.print("sdk<20");
        }
        //loop example
        for (int i = 0; i < 5; i++) {
            if (!manufacturer.equals("HTC")) {
                System.out.print(manufacturer);
            }
        }
        //mulitiple if-branches example
        if (!manufacturer.equals("HTC")) {
            if (sdk >= 20) {
                if (manufacturer.contains("Google")) {
                    System.out.print(manufacturer);
                }
            }
        }

        //callback example
        final String dummyText = getResources().getString(R.string.first_text);
        firstButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (firstTextView.getText().equals(dummyText)) {
                            if (sdk >= 20) {
                                firstTextView.setText("SDK Version " + sdk);
                            } else {
                                firstTextView.setText("SDK Version < 20");
                            }
                            firstButton.setText("Back");
                        } else {
                            firstTextView.setText(R.string.first_text);
                            firstButton.setText(R.string.first_button);
                        }
                    }
                }
        );
        secondButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (firstTextView.getText().equals(dummyText)) {
                            if (!manufacturer.equals("HTC")) {
                                firstTextView.setText("MANUFACTURER " + manufacturer);
                            } else {
                                firstTextView.setText("MANUFACTURER HTC");
                            }
                            secondButton.setText("Back");
                        } else {
                            firstTextView.setText(R.string.first_text);
                            secondButton.setText(R.string.second_button);
                        }
                    }
                }
        );
    }
   public void onGoToNextViewClick(View view)
   {
       //callback example
       if(manufacturer.equals("Google")) {
           Intent getNextViewIntent = new Intent(this, SecondActivity.class);
           final int result = 1;
           getNextViewIntent.putExtra("manufacturer", manufacturer);
           startActivityForResult(getNextViewIntent, result);
       }
   }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView usersNameText=(TextView)findViewById(R.id.firstText);
        String nameSentBack=data.getStringExtra("UsersName");
        usersNameText.setText("Hi "+nameSentBack+"!");
    }
}
