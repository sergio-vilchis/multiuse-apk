package com.multiuse_project.multiuse_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView originSelected = null;
    private ImageView destinationSelected = null;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Origen
        ImageView originSpotify = findViewById(R.id.originSpotify);
        ImageView originYoutube = findViewById(R.id.originYoutube);
        ImageView originApple = findViewById(R.id.originApple);
        ImageView originDeezer = findViewById(R.id.originDeezer);
        // Destino
        ImageView destinationSpotify = findViewById(R.id.destinationSpotify);
        ImageView destinationYoutube = findViewById(R.id.destinationYoutube);
        ImageView destinationApple = findViewById(R.id.destinationApple);
        ImageView destinationDeezer = findViewById(R.id.destinationDeezer);
        // Botón
        startButton = findViewById(R.id.startButton);

        View.OnClickListener originListener = v -> {
            if (originSelected != null) {
                originSelected.setBackground(null);
            }
            originSelected = (ImageView) v;
            originSelected.setBackground(ContextCompat.getDrawable(this, R.drawable.selected_service_bg));
            checkEnableStart();
        };
        View.OnClickListener destinationListener = v -> {
            if (destinationSelected != null) {
                destinationSelected.setBackground(null);
            }
            destinationSelected = (ImageView) v;
            destinationSelected.setBackground(ContextCompat.getDrawable(this, R.drawable.selected_service_bg));
            checkEnableStart();
        };

        originSpotify.setOnClickListener(originListener);
        originYoutube.setOnClickListener(originListener);
        originApple.setOnClickListener(originListener);
        originDeezer.setOnClickListener(originListener);
        destinationSpotify.setOnClickListener(destinationListener);
        destinationYoutube.setOnClickListener(destinationListener);
        destinationApple.setOnClickListener(destinationListener);
        destinationDeezer.setOnClickListener(destinationListener);
    }

    private void checkEnableStart() {
        startButton.setEnabled(originSelected != null && destinationSelected != null && originSelected != destinationSelected);
    }
}