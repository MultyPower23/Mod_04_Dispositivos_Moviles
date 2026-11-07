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

        wvPagina.loadUrl("https://www.reddit.com/r/youtube/comments/1h8cpb3/how_to_download_videos_from_any_webpage_on/?tl=es-419");
        wvPagina.setWebViewClient(new WebViewClient());
    }
}