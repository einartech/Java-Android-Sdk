package com.tappx.simpleadsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tappx.sdk.android.AdRequest;
import com.tappx.sdk.android.TappxInterstitial;
import com.tappx.simpleadsdemo.Utils.setListeners;

public class IntersitialActivity extends AppCompatActivity {
    //todo añadir el test parameter load test=1

    /*---------------------//Props & Atributes//---------------------*/
    TappxInterstitial tappxInterstitial;
    static boolean adIntersitialLoaded=false;

    /*-----------------//Methods & Functionalityes//-----------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intersitial);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /*onClickloadInterstitial f()
     * Create context, add Listeners and set specific atributes.
     * Find and fill the banner container with the specific Tappx Banner having in count the selection of the human.
     * Load Add with specific data
     * Show action information & error handler
     * */
    public void onClickloadInterstitial(View view) {
        TextView loadIntLogs  = (TextView) findViewById(R.id.LogsIntersitial);
        try{
            tappxInterstitial  = new TappxInterstitial(getBaseContext(), "pub-64702-android-0194");
            tappxInterstitial.setListener(setListeners.CreateInterstitialListener(loadIntLogs));
            tappxInterstitial.setAutoShowWhenReady(false);
            tappxInterstitial.loadAd(new AdRequest().useTestAds(true).setEndpoint("sdk1234test"));
            TextView loadIntText = (TextView) findViewById(R.id.intersitial_text);
            loadIntText.setText("You have selected an specific INTERSITIAL ad");
            adIntersitialLoaded=true;
        }
        catch (Exception e) {
            Toast.makeText(this, "Something went wrong with the Intesitial functionality load, please try again...", Toast.LENGTH_LONG).show();
        }
    }

    /*onClickshowInterstitial f()
     * If add is correctly loaded, show it
     * Error handler
     * */
    public void onClickshowInterstitial(View view) {
        if(adIntersitialLoaded==true){
            if (tappxInterstitial.isReady()) {
            tappxInterstitial.setAutoShowWhenReady(true);
            tappxInterstitial.show();
            } else {
            Toast.makeText(this, "Something went wrong with the Intesitial functionality show, please try again...", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "Please press the load button to be able to show the Interstitial ad...", Toast.LENGTH_LONG).show();
        }
    }

    /*onClickFromInterstitialToMain f()
     *Change from Intersitial to Main Activity.
     * */
    public void onClickFromInterstitialToMain(View view) {
        Intent screenToPrincipal = new Intent(getBaseContext(), MainActivity.class);
        startActivity(screenToPrincipal);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (tappxInterstitial != null) tappxInterstitial.destroy();
    }
}