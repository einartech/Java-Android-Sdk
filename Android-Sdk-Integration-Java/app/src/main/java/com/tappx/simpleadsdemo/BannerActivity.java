package com.tappx.simpleadsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tappx.sdk.android.AdRequest;
import com.tappx.sdk.android.TappxBanner;
import com.tappx.simpleadsdemo.Utils.setListeners;

public class BannerActivity extends AppCompatActivity {
    //todo borrar comentarios
    //todo añadir el test parameter load test=1

    /*---------------------//Props & Atributes//---------------------*/
    ViewGroup bannerContainer;
    TappxBanner banner;
    String BannerTypeSelected;
    /*-----------------//Methods & Functionalityes//-----------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        BannerTypeSelected = this.getIntent().getStringExtra("BannerType");
    }

    /*onClickloadAndshowBanner f() << onSwitchDevice f()
     * Create context and add Listeners.
     * Find and fill the banner container with the specific Tappx Banner having in count the selection of the human.
     * Show action information & error handler
     * */
    public void onClickloadAndshowBanner(View view) {
        TextView loadBanLogs = (TextView) findViewById(R.id.LogsBanner);

        bannerContainer = (ViewGroup) findViewById(R.id.banner_container);
        Context context = this;
        try {
            banner = new TappxBanner(context, "pub-64702-android-0194");
            banner.setListener(setListeners.CreateBannerListener(loadBanLogs));

            try {
                if (BannerTypeSelected != null && BannerTypeSelected != "") {

                    if (BannerTypeSelected.equals("phone")) {
                        banner.setAdSize(TappxBanner.AdSize.BANNER_320x50);
                        TextView loadBanText = (TextView) findViewById(R.id.banner_text);
                        loadBanText.setText("You have selected a specific BANNER ad for phone with size 320x50");

                    } else if (BannerTypeSelected.equals("tablet")) {
                        banner.setAdSize(TappxBanner.AdSize.BANNER_728x90);
                        TextView loadBanText = (TextView) findViewById(R.id.banner_text);
                        loadBanText.setText("You have selected a specific BANNER ad for tablet with size 728x90");


                    } else if (BannerTypeSelected.equals("mrec")) {
                        banner.setAdSize(TappxBanner.AdSize.BANNER_300x250);
                        TextView loadBanText = (TextView) findViewById(R.id.banner_text);
                        loadBanText.setText("You have selected a specific BANNER MREC for phone/tablet ad with size 300x250");

                    } else {
                        Toast.makeText(this, "SMART_BANNER", Toast.LENGTH_LONG).show();
                        banner.setAdSize(TappxBanner.AdSize.SMART_BANNER);
                    }
                } else {
                    TextView loadBanText = (TextView) findViewById(R.id.banner_text);
                    loadBanText.setText("You haven't selected a specific BANNER ad, so here we have one with automatic size, SMART_BANNER");
                }

            } catch (Exception e) {
                Toast.makeText(this, "Something went wrong with the Banner functionality load and show, please try again...", Toast.LENGTH_LONG).show();
            }
            bannerContainer.addView(banner);
            banner.setRefreshTimeSeconds(45);
            banner.loadAd(new AdRequest().useTestAds(true).setEndpoint("sdk1234test"));

        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong with Banner creation, please try again...", Toast.LENGTH_LONG).show();
        }
    }

    /*onClickFromBannerToMain f()
     *Change from Banner to Main Activity.
     * */
    public void onClickFromBannerToMain(View view) {
        Intent screenToPrincipal = new Intent(getBaseContext(), MainActivity.class);
        startActivity(screenToPrincipal);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (banner != null) banner.destroy();
    }
}
