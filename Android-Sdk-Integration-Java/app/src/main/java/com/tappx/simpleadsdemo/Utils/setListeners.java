package com.tappx.simpleadsdemo.Utils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tappx.sdk.android.TappxAdError;
import com.tappx.sdk.android.TappxBanner;
import com.tappx.sdk.android.TappxBannerListener;
import com.tappx.sdk.android.TappxInterstitial;
import com.tappx.sdk.android.TappxInterstitialListener;
import com.tappx.sdk.android.TappxRewardedVideo;
import com.tappx.sdk.android.TappxRewardedVideoListener;

public class setListeners {

/*
*ADD INTERSITIAL LOGS
*tappxInterstitial.setListener(setListeners.CreateInterstitialListener(loadIntLogs));
*/
public static TappxInterstitialListener CreateInterstitialListener  (TextView loadIntLogs) {
    TappxInterstitialListener IntersitialListener = new TappxInterstitialListener() {
        @Override
                public void onInterstitialLoaded(TappxInterstitial tappxInterstitial) {
                     loadIntLogs.setText("Interstitial add has been correctly loaded");
                     Log.v("Tappx", "Tappx: onInterstitialLoaded");
                }

                @Override
                public void onInterstitialLoadFailed(TappxInterstitial tappxInterstitial, TappxAdError tappxAdError) {
                    loadIntLogs.setText("Interstitial add hasn't been correctly loaded");
                    Log.v("Tappx", "Tappx: onInterstitialLoadFailed");
                }

                @Override
                public void onInterstitialShown(TappxInterstitial tappxInterstitial) {
                    loadIntLogs.setText("Interstitial add has been correctly shown");
                    Log.v("Tappx", "Tappx: onInterstitialShown");
                }

                @Override
                public void onInterstitialClicked(TappxInterstitial tappxInterstitial) {
                    loadIntLogs.setText("Interstitial add has been correctly clicked");
                    Log.v("Tappx", "Tappx: onInterstitialClicked");
                }

                @Override
                public void onInterstitialDismissed(TappxInterstitial tappxInterstitial) {
                    loadIntLogs.setText("Interstitial add has been correctly dismissed");
                    Log.v("Tappx", "Tappx: onInterstitialDismissed");
                }
            };
    return IntersitialListener;
}

/*
*ADD BANNER LOGS
*banner.setListener(setListeners.CreateBannerListener(loadBanLogs));
*/

    public static TappxBannerListener CreateBannerListener  (TextView loadBanLogs) {

        TappxBannerListener BannerListener = new TappxBannerListener() {

            @Override
            public void onBannerLoaded(TappxBanner tappxBanner) {
                loadBanLogs.setText("Banner add has been correctly loaded");
                Log.v("Tappx", "Tappx: onBannerLoaded");
            }

            @Override
            public void onBannerLoadFailed(TappxBanner tappxBanner, TappxAdError tappxAdError) {
                loadBanLogs.setText("Banner add hasn't been correctly loaded");
                Log.v("Tappx", "Tappx: onBannerLoadFailed " + tappxAdError);
            }

            @Override
            public void onBannerClicked(TappxBanner tappxBanner) {
                loadBanLogs.setText("Banner add has been correctly clicked");
                Log.v("Tappx", "Tappx: onBannerClicked");
            }

            @Override
            public void onBannerExpanded(TappxBanner tappxBanner) {
                loadBanLogs.setText("Banner add has been correctly expanded");
                Log.v("Tappx", "Tappx: onBannerExpanded");
            }

            @Override
            public void onBannerCollapsed(TappxBanner tappxBanner) {
                loadBanLogs.setText("Banner add has been correctly collapsed");
                Log.v("Tappx", "Tappx: onBannerCollapsed");
            }
        };
        return BannerListener;
    }

    /*
     *ADD REWARDEDVIDEO LOGS
     *rewardedVideo.setListener(setListeners.CreateRewardedVideoListener(loadRwdLogs));
     */

    public static TappxRewardedVideoListener CreateRewardedVideoListener (TextView loadRwdLogs) {

        TappxRewardedVideoListener RewardedVideoListener = new TappxRewardedVideoListener() {

            @Override
            public void onRewardedVideoLoaded(TappxRewardedVideo rewardedVideo) {
                loadRwdLogs.setText("Rewarded Video add has been correctly Loaded");
                Log.v("Tappx", "Tappx: onRewardedVideoLoaded");
            }

            @Override
            public void onRewardedVideoLoadFailed(TappxRewardedVideo rewardedVideo, TappxAdError tappxAdError) {
                loadRwdLogs.setText("Rewarded Video add hasn't been correctly loaded");
                Log.v("Tappx", "Tappx: onRewardedLoadFailed");
            }

            @Override
            public void onRewardedVideoStart(TappxRewardedVideo rewardedVideo) {
                loadRwdLogs.setText("Rewarded Video add has been correctly started");
                Log.v("Tappx", "Tappx: onRewardedVideoStart ");
            }

            @Override
            public void onRewardedVideoClicked(TappxRewardedVideo rewardedVideo) {
                loadRwdLogs.setText("Rewarded Video add has been correctly clicked");
                Log.v("Tappx", "Tappx: onRewardedVideoClicked");
            }

            @Override
            public void onRewardedVideoPlaybackFailed(TappxRewardedVideo rewardedVideo) {
                loadRwdLogs.setText("Rewarded Video add playback failed");
                Log.v("Tappx", "Tappx: onRewardedVideoPlaybackFailed");
            }

            @Override
            public void onRewardedVideoClosed (TappxRewardedVideo rewardedVideo) {
                loadRwdLogs.setText("Rewarded Video add closed");
                Log.v("Tappx", "Tappx: onRewardedVideoClosed");
            }

            @Override
            public void onRewardedVideoCompleted (TappxRewardedVideo rewardedVideo) {
                loadRwdLogs.setText("Rewarded Video add completed");
                Log.v("Tappx", "Tappx: onRewardedVideoCompleted");
            }

        };
        return RewardedVideoListener;
    }

    }//setListeners
