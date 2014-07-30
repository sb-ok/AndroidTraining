package ru.sbdev.orientation;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button btn;
    static final String ORIENTATION_PORTRAIT = "Портретный режим";
    static final String ORIENTATION_LANDSCAPE = "Альбомный режим";

    //Определяем изменение ориентации экрана
    boolean mState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // запускает приложение в альбомной ориентации

        btn = (Button) findViewById(R.id.changeOrintation);

        // установим положение по умолчанию
        btn.setText(ORIENTATION_LANDSCAPE);
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

    public String getScreenorientation(){
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            return "Портретная ориетация";
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            return "Альбомная ориентация";
        else
            return "лажа";
    }

    private String  mOrientation = "";
    private boolean isLandscapeMode(Activity activity)
    {
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();

        boolean isLandscape = width > height;

        if(isLandscape)
            mOrientation = "Альбомная";
        else mOrientation = "Портретная";

        return isLandscape;
    }

    private String getRotateOrientation()
    {
        int rotate = getWindowManager().getDefaultDisplay().getRotation();
        switch (rotate){
            case Surface.ROTATION_0:
                return "Не поварачивали";
            case Surface.ROTATION_90:
                return "Повернули на 90 градусов по часовой стрелке";
            case Surface.ROTATION_180:
                return "Повернули на 180 градусов";
            case Surface.ROTATION_270:
                return "Повернули на 270 градусов";
            default:
                return "Не понятно куда повернули";
        }
    }

    public void onClick(View v)
    {
        // если mState FALSE - переключаемся в альбомный режим
        if(!mState){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            btn.setText(ORIENTATION_LANDSCAPE);
        }
        // если mState TRUE - переключаемся в портретный режим
        else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            btn.setText(ORIENTATION_PORTRAIT);

            mState = !mState;
        }
    }

}
