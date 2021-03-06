// @Github: https://github.com/PetrelPine/ontario-auto-screening-android

package com.example.ScreeningTool;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String msg = "\nI confirm that ALL the following information is CORRECT and I am RESPONSIBLE for the confirmation and the information I provided.\n\n\n" +
                "1. I am taking this screening as a student/child.\n\n" +
                "2. In the last 14 days, I did NOT travel outside of Canada and was NOT told to quarantine.\n\n" +
                "3. In the last 14 days, I did NOT travel outside of Canada and was NOT told to not attend school/child care.\n\n" +
                "4. In the last 10 days, I have NOT experienced any of these symptoms: fever and/or chills, cough or barking cough (croup), shortness of breath, decrease or loss of taste or smell, muscle aches/joint pain, extreme tiredness, sore throat, runny or stuffy/congested nose, headache, nausea, vomiting, and/or diarrhea.\n\n" +
                "5. In the last 10 days, I have NOT been tested positive on a lab-based PCR test, rapid antigen test, or home-based self-testing kit.\n\n" +
                "6. I do NOT live with someone who is currently isolating because of a positive COVID-19 test.\n\n" +
                "7. I do NOT live with someone who is currently isolating because of COVID-19 symptoms.\n\n" +
                "8. I do NOT live with someone who is waiting for COVID-19 test results.\n\n" +
                "9. There are NOT any doctors, health care providers, or public health units told me that I should currently be isolating (staying at home).\n\n" +
                "10. I have NOT been identified as a ???close contact??? of someone who currently has COVID-19 and been advised to self-isolate.\n\n" +
                "\n*This project is posted on Github (https://github.com/PetrelPine/ontario-auto-screening-android)\n\n";
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Screening Confirmation");
        alertDialog.setMessage(msg);

        alertDialog.setPositiveButton("DECLINE", new DialogInterface.OnClickListener() {  //??????????????????
            @Override
            public void onClick(DialogInterface dialog, int which) {  //???????????????????????????
                finish();
            }
        });

        alertDialog.setNegativeButton("CONFIRM", new DialogInterface.OnClickListener() {  //??????????????????
            @SuppressLint("SetJavaScriptEnabled")
            @Override
            public void onClick(DialogInterface dialog, int which) {  //???????????????????????????
                dialog.dismiss();
                WebView webView = findViewById(R.id.webView);
                WebSettings settings = webView.getSettings();
                //????????????????????????url
                webView.loadUrl("file:///android_asset/approved.html");  //???????????????assets????????????html????????????????????????????????????????????????????????????????????????????????????????????????android_asset??????????????????assets????????????????????????
                webView.setHorizontalScrollBarEnabled(false);
                settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);  //???????????????
                settings.setLoadWithOverviewMode(true);  //???????????????
                settings.setUseWideViewPort(true);  //???????????????
                settings.setSupportZoom(true);  //????????????
                // settings.setBuiltInZoomControls(true);  //??????????????????????????????

                // ??????????????????????????????Javascript????????????webView??????????????????Javascript
                settings.setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient(){
                    public boolean shouldOverrideUrlLoading(WebView view, String url){
                        view.loadUrl(url);
                        return true;
                    }
                });
            }
        });

        alertDialog.show();  //???????????????

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
