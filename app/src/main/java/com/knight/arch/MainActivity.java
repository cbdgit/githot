package com.knight.arch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.knight.arch.api.ApiClient;
import com.knight.arch.model.AllPersonlInfos;


import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onTestClick(View view) {
        ApiClient.getTestDemoApiClient().getData2(new Callback<AllPersonlInfos>() {
            @Override
            public void success(AllPersonlInfos personInfos, Response response) {
                Log.e("TAG_success", personInfos.getData().get(1).getUsername());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("TAG_failure", error.toString());
            }
        });
    }


    //=============================================================================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}