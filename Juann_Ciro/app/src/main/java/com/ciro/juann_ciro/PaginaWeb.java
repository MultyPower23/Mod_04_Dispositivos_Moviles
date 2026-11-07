package com.ciro.juann_ciro;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PaginaWeb extends AppCompatActivity {

    WebView wvPagina;
    WebSettings webSettings;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pagina_web);

        // Inicializar Variable
        wvPagina = findViewById(R.id.wvPagina);
        webSettings = wvPagina.getSettings();

        // Utilizar la Herramienta
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        wvPagina.loadUrl("https://github.com/MultyPower23/Tecnica");
        wvPagina.setWebViewClient(new WebViewClient());
    }

    @SuppressLint("GestureBackNavigation")
    @Override
    public void onBackPressed() {
        if (wvPagina.canGoBack()) {
            wvPagina.goBack();
        } else {
            super.onBackPressed();
        }
    }
}