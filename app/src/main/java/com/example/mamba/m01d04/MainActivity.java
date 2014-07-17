package com.example.mamba.m01d04;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Intent;


public class MainActivity extends Activity {

    private TextView mTextViewInfo;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRelativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
        mTextViewInfo = (TextView)findViewById(R.id.textView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    public void onClick(View view) {
            switch (view.getId()) {
            case R.id.buttonRed:
                mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.redColor));
                mTextViewInfo.setText(R.string.redLight);
                break;
            case R.id.buttonGreen:
                mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.greenColor));
                mTextViewInfo.setText(R.string.greenLight);
                break;
            case R.id.buttonYellow:
                mRelativeLayout.setBackgroundColor(getResources().getColor(R.color.yellowColor));
                mTextViewInfo.setText(R.string.yellowLight);
                break;
        }
    }

    public void openAboutPage(View view)
    {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }
}
