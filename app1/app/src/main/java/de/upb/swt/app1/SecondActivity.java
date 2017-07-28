package de.upb.swt.app1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
/**
 * Created by linghui on 28.07.2017.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent activityThatCalled = getIntent();
        String info = activityThatCalled.getExtras().getString("manufacturer");
        TextView infoFromMain = (TextView) findViewById(R.id.infoFromMain);
        infoFromMain.append(" manufacturer "+ info);
        //interclass flow example;
        if(!info.equals("Google"))
        {
            System.out.print(info);
        }
    }

    public void onSendUsersName(View view) {
        EditText usersName = (EditText) findViewById(R.id.usersName);
        String name = String.valueOf(usersName.getText());
        Intent goingBack = new Intent();
        goingBack.putExtra("UsersName", name);
        setResult(RESULT_OK, goingBack);
        finish();
    }
}
