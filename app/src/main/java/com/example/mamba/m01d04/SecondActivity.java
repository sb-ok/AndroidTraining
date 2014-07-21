package com.example.mamba.m01d04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.mamba.m01d04.R;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void SendMsg(View view)
    {
        EditText edUserName = (EditText) findViewById(R.id.targetText);
        EditText edDiscription = (EditText) findViewById(R.id.discriptionText);

        Intent intent = new Intent(SecondActivity.this, TargetMsgActivity.class);

        intent.putExtra("username", edUserName.getText().toString());
        intent.putExtra("message", edDiscription.getText().toString());

        startActivity(intent);
    }
}
