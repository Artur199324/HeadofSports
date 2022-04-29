package com.robtopx.geometr;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageGo, imageStra, imageViewget;
    ConstraintLayout cons;
    Display display;
    TextView textViewH, textViewG, textViewWon, textViewLost, textViewRest, textViewlogin,
            textViewRegistration, textViewLog, textViewPassword, textViewOK, textViewName;
    EditText editTextTextPersonName, editTextTextPassword;
    Handler handler;
    ImageView imageBl;
    ArrayList<ImageView> arrayListBoll;
    int ff = 0;
    String nameHS = "w";
    String passwordHS = "w";
    String nameHSD = "w";
    String passwordHSD = "w";
    WebView webViewFullAppHS;

    public static ValueCallback<Uri> vsgh;
    public static Uri bdre = null;
    public static ValueCallback<Uri[]> vfdr;
    public static String vfdew;
    public static final int vfew = 1;

    @Override
    public void onBackPressed() {
        if (webViewFullAppHS.isFocused() && webViewFullAppHS.canGoBack()) {
            webViewFullAppHS.goBack();
        }
    }

    public static String decodeHS(String csza){
        byte[] bfdw = android.util.Base64.decode(csza, Base64.DEFAULT);
        return new String(bfdw);
    }

    @Override
    protected void onActivityResult(int csas, int cdsssdih, @Nullable Intent vdqa) {
        if (csas != vfew || vfdr == null) {
            super.onActivityResult(csas, cdsssdih, vdqa);
            return;
        }
        Uri[] csc = null;
        if (cdsssdih == Activity.RESULT_OK) {
            if (vdqa == null) {
                if (vfdew != null) {
                    csc = new Uri[]{Uri.parse(vfdew)};
                }
            } else {
                String hhg = vdqa.getDataString();
                if (hhg != null) {
                    csc = new Uri[]{Uri.parse(hhg)};
                }
            }
        }
        vfdr.onReceiveValue(csc);
        vfdr = null;
        if (vsgh == null) {
            super.onActivityResult(csas, cdsssdih, vdqa);
            return;
        }
        Uri csa = null;
        try {
            if (cdsssdih != RESULT_OK) {
                csa = null;
            } else {
                csa = vdqa == null ? bdre : vdqa.getData();
            }
        } catch (Exception e) {
        }
        vsgh.onReceiveValue(csa);
        vsgh = null;
    }

    private void setWebHS(){

        webViewFullAppHS.getSettings().setJavaScriptEnabled(true);
        webViewFullAppHS.getSettings().setDomStorageEnabled(true);
        webViewFullAppHS.getSettings().setLoadWithOverviewMode(true);
        webViewFullAppHS.clearCache(false);
        webViewFullAppHS.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webViewFullAppHS, true);
        webViewFullAppHS.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (url.contains(decodeHS("ZXJyb3I9YXBwYWZBczNm")) || url.contains(decodeHS("ZGlzYWJsZWQuaHRtbA=="))) {

                    webViewFullAppHS.setVisibility(View.INVISIBLE);
                    Log.d("weq","bot");
                }
            }
        });
        webViewFullAppHS.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onShowFileChooser(WebView view,
                                             ValueCallback<Uri[]> filePath,
                                             FileChooserParams fileChooserParams) {
                if (vfdr != null) {
                    vfdr.onReceiveValue(null);
                }
                vfdr = filePath;
                Intent cscsa = new Intent(Intent.ACTION_GET_CONTENT);
                cscsa.addCategory(Intent.CATEGORY_OPENABLE);
                cscsa.setType("*/*");
                Intent[] ggf = new Intent[0];
                Intent bbbbv = new Intent(Intent.ACTION_CHOOSER);
                bbbbv.putExtra(Intent.EXTRA_INTENT, cscsa);
                bbbbv.putExtra(Intent.EXTRA_TITLE, decodeHS("U2VsZWN0IE9wdGlvbjo="));
                bbbbv.putExtra(Intent.EXTRA_INITIAL_INTENTS, ggf);
                startActivityForResult(bbbbv, 1);
                return true;
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initHS();
        setWebHS();
        if (!getIntent().getBooleanExtra("bul",false)){
            webViewFullAppHS.setVisibility(View.INVISIBLE);
        }else {
            webViewFullAppHS.setVisibility(View.VISIBLE);
            webViewFullAppHS.loadUrl(getIntent().getStringExtra("llll"));
        }

        handler = new Handler();
        arrayListBoll = new ArrayList<>();
        nameHSD = getSharedPreferences(getPackageName(), MODE_PRIVATE).getString("nameHS", "w");
        passwordHSD = getSharedPreferences(getPackageName(), MODE_PRIVATE).getString("nameHS", "w");
        if (!nameHSD.equals("w")) {
            textViewlogin.setVisibility(View.VISIBLE);
        } else {
            textViewRegistration.setVisibility(View.VISIBLE);
        }

        kf();
        movePlayerHS();
        editTextTextPersonName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                nameHS = editable.toString();
            }
        });

        editTextTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                passwordHS = editable.toString();
            }
        });

        textViewOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!passwordHS.equals("w") && !nameHS.equals("w")) {

                    if (nameHSD.equals("w")) {
                        getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putString("nameHS", nameHS).apply();
                        getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putString("passwordHS", passwordHS).apply();
                        ufu();
                    } else {

                        if (!nameHS.equals(nameHSD) && !passwordHS.equals(passwordHSD)) {
                            ufu();
                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(), "Incorrect password or login", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }

                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Fill in all the fields", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        cons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nnn) {
                    goB();
                }

            }
        });

        textViewRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textViewLost.setVisibility(View.INVISIBLE);
                textViewWon.setVisibility(View.INVISIBLE);
                textViewRest.setVisibility(View.INVISIBLE);
                io = 0;
                ff = 0;
                imageGo.setVisibility(View.VISIBLE);
                imageStra.setVisibility(View.VISIBLE);
                nnn = false;
                cou1 = 0;
                cou2 = 0;
                textViewH.setText("0");
                textViewG.setText("0");
                movePlayerHS();
            }
        });


    }

    private void ufu() {
        textViewOK.setVisibility(View.INVISIBLE);
        editTextTextPassword.setVisibility(View.INVISIBLE);
        editTextTextPersonName.setVisibility(View.INVISIBLE);
        textViewlogin.setVisibility(View.INVISIBLE);
        textViewRegistration.setVisibility(View.INVISIBLE);
        textViewLog.setVisibility(View.INVISIBLE);
        textViewPassword.setVisibility(View.INVISIBLE);
        textViewName.setVisibility(View.VISIBLE);
        textViewName.setText(nameHS);
        imageViewget.setVisibility(View.VISIBLE);
        imageGo.setVisibility(View.VISIBLE);
        imageStra.setVisibility(View.VISIBLE);
        nnn = false;
    }

    boolean hhhh = false;
    boolean nnn = true;
    int io = 0;
    int cou1 = 0;
    int cou2 = 0;

    private void goB() {
        hhhh = false;
        nnn = true;
        Random random = new Random();
        imageBl = new ImageView(this);
        ConstraintLayout.LayoutParams constrainBl = new ConstraintLayout.LayoutParams(vdr / 6, vdr / 6);
        imageBl.setLayoutParams(constrainBl);
        cons.addView(imageBl, constrainBl);
        imageBl.setImageResource(R.drawable.boll);
        imageBl.setX(imageStra.getX());
        imageBl.setY(nhgy - imageStra.getWidth() - 200);
        arrayListBoll.add(imageBl);

        handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrayListBoll.size(); i++) {
                    ImageView imageView = arrayListBoll.get(i);
                    imageView.setRotation(imageView.getRotation() + 30);

                    if (!hhhh) {
                        imageView.setY(imageView.getY() - 10);
                    } else {
                        imageView.setY(imageView.getY() + 10);
                    }


                    switch (random.nextInt(2)) {
                        case 0:
                            imageView.setX(imageView.getX() - 15);
                            break;
                        case 1:
                            imageView.setX(imageView.getX() + 15);
                            break;
                    }

                    if (imageView.getY() < 10 | imageView.getX() < 0 | imageView.getX() > vdr) {
                        cons.removeView(imageView);
                        arrayListBoll.remove(i);
                        nnn = false;

                    }

                    if (imageView.getY() > nhgy - 20) {
                        cons.removeView(imageView);
                        arrayListBoll.remove(i);
                        nnn = false;
                        cou2++;
                        textViewG.setText(cou2 + "");

                    }


                    Rect myViewRect = new Rect();
                    imageView.getHitRect(myViewRect);

                    Rect otherViewRect3 = new Rect();
                    imageViewget.getHitRect(otherViewRect3);

                    Rect otherViewRect1 = new Rect();
                    imageGo.getHitRect(otherViewRect1);

                    Rect otherViewRect2 = new Rect();
                    imageStra.getHitRect(otherViewRect2);

                    if (Rect.intersects(myViewRect, otherViewRect1)) {
                        hhhh = true;

                    }

                    if (Rect.intersects(myViewRect, otherViewRect2)) {
                        hhhh = false;

                    }
                    boolean grds = false;
                    if (Rect.intersects(myViewRect, otherViewRect3)) {
                        grds = true;

                        cons.removeView(imageView);
                        arrayListBoll.remove(i);
                        nnn = false;

                    }

                    if (grds) {
                        cou1++;
                        textViewH.setText(cou1 + "");
                    }

                    if (cou1 == 3) {
                        textViewWon.setVisibility(View.VISIBLE);
                        textViewRest.setVisibility(View.VISIBLE);
                        io = 1;
                        ff = 1;
                        imageGo.setVisibility(View.INVISIBLE);
                        imageStra.setVisibility(View.INVISIBLE);
                        nnn = false;
                    }

                    if (cou2 == 3) {
                        textViewLost.setVisibility(View.VISIBLE);
                        textViewRest.setVisibility(View.VISIBLE);
                        io = 1;
                        ff = 1;
                        imageGo.setVisibility(View.INVISIBLE);
                        imageStra.setVisibility(View.INVISIBLE);
                        nnn = false;
                    }


                }


                if (io != 1) {
                    handler.postDelayed(this::run, 50);
                }
            }
        });
    }

    private void initHS() {
        webViewFullAppHS = findViewById(R.id.webViewFullAppHS);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        textViewName = findViewById(R.id.textViewName);
        textViewOK = findViewById(R.id.textViewOK);
        textViewPassword = findViewById(R.id.textViewPassword);
        textViewLog = findViewById(R.id.textViewLog);
        textViewRegistration = findViewById(R.id.textViewRegistration);
        textViewlogin = findViewById(R.id.textViewlogin);
        imageGo = findViewById(R.id.imageGo);
        imageStra = findViewById(R.id.imageStra);
        cons = findViewById(R.id.cons);
        display = getWindowManager().getDefaultDisplay();
        textViewH = findViewById(R.id.textViewH);
        textViewG = findViewById(R.id.textViewG);
        imageViewget = findViewById(R.id.imageViewget);
        textViewWon = findViewById(R.id.textViewWon);
        textViewLost = findViewById(R.id.textViewLost);
        textViewRest = findViewById(R.id.textViewRest);
    }

    int vdr;
    int nhgy;

    private void kf() {
        vdr = display.getWidth();
        nhgy = display.getHeight();
    }


    boolean fgf = false;
    boolean ree = false;
    int spidGo = 30;
    int spidSTr = 10;

    private void movePlayerHS() {
        Random random = new Random();
        handler.post(new Runnable() {
            @Override
            public void run() {

                if (!fgf) {
                    imageGo.setX(imageGo.getX() + spidGo);
                } else {
                    imageGo.setX(imageGo.getX() - spidGo);
                }


                if (imageGo.getX() >= vdr - imageGo.getWidth()) {
                    fgf = true;
                    switch (random.nextInt(3)) {
                        case 0:
                            spidGo = 30;
                            break;
                        case 1:
                            spidGo = 50;
                            break;
                        case 2:
                            spidGo = 70;
                            break;

                    }

                } else if (imageGo.getX() <= 0) {
                    fgf = false;
                    switch (random.nextInt(3)) {
                        case 0:
                            spidGo = 10;
                            break;
                        case 1:
                            spidGo = 20;
                            break;
                        case 2:
                            spidGo = 30;
                            break;

                    }
                }
                if (ff != 1) {
                    handler.postDelayed(this::run, 50);
                }


            }
        });

        handler.post(new Runnable() {
            @Override
            public void run() {

                if (!ree) {
                    imageStra.setX(imageStra.getX() - spidSTr);
                } else {
                    imageStra.setX(imageStra.getX() + spidSTr);
                }


                if (imageStra.getX() >= vdr - imageStra.getWidth()) {
                    ree = false;
                    switch (random.nextInt(3)) {
                        case 0:
                            spidSTr = 15;
                            break;
                        case 1:
                            spidSTr = 25;
                            break;
                        case 2:
                            spidSTr = 35;
                            break;

                    }

                } else if (imageStra.getX() <= 0) {
                    ree = true;
                    switch (random.nextInt(3)) {
                        case 0:
                            spidSTr = 15;
                            break;
                        case 1:
                            spidSTr = 25;
                            break;
                        case 2:
                            spidSTr = 35;
                            break;

                    }
                }


                if (ff != 1) {
                    handler.postDelayed(this::run, 50);
                }
            }
        });

    }
}