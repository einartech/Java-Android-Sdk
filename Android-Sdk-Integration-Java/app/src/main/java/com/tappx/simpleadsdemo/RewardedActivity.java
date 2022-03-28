package com.tappx.simpleadsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tappx.sdk.android.AdRequest;
import com.tappx.sdk.android.TappxRewardedVideo;
import com.tappx.simpleadsdemo.Utils.setListeners;

public class RewardedActivity extends AppCompatActivity {
    //todo add comment at a function
    /*---------------------//Props & Atributes//---------------------*/
    TappxRewardedVideo rewardedVideo;
    Boolean loading=false;
    Boolean isLoad=false;
    Button adLoadView;
    Button adShowView;
    static boolean adRewardedVideoLoaded=false;

    /*-----------------//Methods & Functionalityes//-----------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewarded);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        adLoadView=(Button) findViewById(R.id.btnLoadRewarded);
        adShowView=(Button) findViewById(R.id.btnShowRewarded);

        adLoadView.findViewById(R.id.btnLoadRewarded).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadRewarded();
            }
        });
        adShowView.findViewById(R.id.btnShowRewarded).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rewardedVideo != null & adRewardedVideoLoaded==true) {
                        rewardedVideo.show();
                }else{
                        Toast.makeText(getBaseContext(), "Please press the load button to be able to show the Rewarded Video ad...", Toast.LENGTH_LONG).show();
                    }
            }});
        }

    /*loadRewarded f()
     *.
     *@.
     * */
        private void loadRewarded(){
            TextView loadRwdLogs  = (TextView) findViewById(R.id.logsRewardedVideo);

            try{
                if (loading) return;
                loading = true;
                isLoad = false;
                adRewardedVideoLoaded=true;
                    if (rewardedVideo != null) {
                    rewardedVideo.destroy();
                    }
                rewardedVideo = new TappxRewardedVideo(this, "pub-xxxx-android-xxxx");
                rewardedVideo.loadAd(new AdRequest().useTestAds(true).setEndpoint("sdk1234test"));
                rewardedVideo.setListener(setListeners.CreateRewardedVideoListener(loadRwdLogs));
                TextView loadRwrdVText = (TextView) findViewById(R.id.Tappx_monster2);
                loadRwrdVText.setText("You have selected an specific REWARDED VIDEO ad");
            }
                catch (Exception e) {
                Toast.makeText(this, "Something went wrong with the Rewarded Video functionality load, please try again...", Toast.LENGTH_LONG).show();
                }
        }

    /*onClickFromVideoRewardedToMain f()
     *Change from Video Rewarded to Main Activity.
     * */
    public void onClickFromVideoRewardedToMain(View view) {
        Intent screenToPrincipal = new Intent(getBaseContext(), MainActivity.class);
        startActivity(screenToPrincipal);
    }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            if (rewardedVideo!= null) rewardedVideo.destroy();
        }
    }


