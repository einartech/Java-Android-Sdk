package com.tappx.simpleadsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.tappx.sdk.android.Tappx;

public class MainActivity extends AppCompatActivity {
    //todo borrar comentarios
    //todo controlar el switch

    /*---------------------//Props & Atributes//---------------------*/
    Switch typeOfDevice;
    Switch txtSwitchInfo;
    /*-----------------//Methods & Functionalityes//-----------------*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        txtSwitchInfo= findViewById(R.id.mobileOrTablet);
        typeOfDevice= findViewById(R.id.mobileOrTablet);

        TextView sdkVersion = (TextView) findViewById(R.id.sdk_version);
        sdkVersion.setText("SDK VERSION " + Tappx.getVersion());
    }

    /*onSwitchDevice f()
    *Grab & Hardcode data from switch if used device is a phone or tablet and grab this data to show the accurate banner.
    *@BannerType this is the main parameter wich allows to grab an specific BANNER size.
    * */
    public void onSwitchDevice(View view){
        try{
            Intent sendDataToBanner = new Intent(getBaseContext(),BannerActivity.class);
            if (typeOfDevice.isChecked()) {
                txtSwitchInfo.setText("Banner phone 320x50");
                sendDataToBanner.putExtra("BannerType","phone");
            } else{
                txtSwitchInfo.setText("Banner tablet 728x90");
                sendDataToBanner.putExtra("BannerType","tablet");
            }
            startActivity(sendDataToBanner);
        }
        catch (Exception e) {
            Toast.makeText(this, "Algo ha fallado en el switch, por favor, espera un momento...", Toast.LENGTH_LONG).show();
            //Todo el codigo de try deberia venir aqui, en realidad deberiamos intentar hacerlo de manera automatica...
        }
    }

    /*onClickBanner f()
     *Change from Main to Banner Activity & error handler.
     * */
    public void onClickBanner(View view) {
        try{
            Intent screenToBanner = new Intent(getBaseContext(), BannerActivity.class);
            startActivity(screenToBanner);
        }
        catch (Exception e) {
            finish();
            Toast.makeText(this, "Algo ha fallado accediendo a la funcionalidad de Banner, por favor, espera un momento...", Toast.LENGTH_LONG).show();
            Intent screenToBanner = new Intent(getBaseContext(), BannerActivity.class);
            startActivity(screenToBanner);
        }
    }

    /*onClickInterstitial f()
     *Change from Main to Banner Activity & error handler.
     * */
    public void onClickInterstitial(View view) {
        try{
            Intent screenToIntersitial = new Intent(getBaseContext(), IntersitialActivity.class);
            startActivity(screenToIntersitial);
        }
        catch (Exception e) {
            finish();
            Toast.makeText(this, "Algo ha fallado accediendo a la funcionalidad de Intersitial, por favor, espera un momento...", Toast.LENGTH_LONG).show();
            Intent screenToIntersitial = new Intent(getBaseContext(), IntersitialActivity.class);
            startActivity(screenToIntersitial);
        }
    }

    /*onClickMrec f()
     *Change from Main to Banner Activity & error handler.
     *@BannerType this is the main parameter wich allows to grab an specific BANNER size.
     * */
    public void onClickMrec(View view) {
        try{
            Intent sendDataToBanner = new Intent(getBaseContext(),BannerActivity.class);
            if (!typeOfDevice.isChecked()) {
                sendDataToBanner.putExtra("BannerType","mrec");
            } else{
                Toast.makeText(this, "Mrec Ad no ha podido coger correctamente el tamaño del Ad...", Toast.LENGTH_LONG).show();
            }
            startActivity(sendDataToBanner);
        }
        catch (Exception e) {
            Toast.makeText(this, "Algo ha fallado accediendo a la funcionalidad de Mrec, por favor, espera un momento...", Toast.LENGTH_LONG).show();
        }
    }

    /*onClickRewarded f()
     *Change from Main to Rewarded Video Activity & error handler.
     * */
    public void onClickRewarded(View view) {
        try{
            Intent screenToRewarded = new Intent(getBaseContext(), RewardedActivity.class);
            startActivity(screenToRewarded);
        }
        catch(Exception e) {
            Toast.makeText(this, "Algo ha fallado accediendo a la funcionalidad de Rewarded, por favor, espera un momento...", Toast.LENGTH_LONG).show();
        }
    }
}