package com.multiuse_project.multiuse_app;

import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

import android.content.Intent;
import android.os.Build;

import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.P)
public class SplashActivityTest {
    private ActivityController<SplashActivity> controller;
    private SplashActivity splashActivity;

    @Before
    public void setUp() {
        controller = Robolectric.buildActivity(SplashActivity.class).create().start().resume();
        splashActivity = controller.get();
    }

    @After
    public void tearDown() {
        controller.pause().stop().destroy();
    }

    @Test
    public void splashScreen_ShowsLogoAndTitle() {
        assertNotNull(splashActivity.findViewById(R.id.splashLogo));
        assertNotNull(splashActivity.findViewById(R.id.splashTitle));
    }

    @Test
    public void splashScreen_NavigatesToMainActivityAfterDelay() {
        // Avanza el tiempo simulado 4 segundos
        shadowOf(splashActivity.getMainLooper()).idleFor(4000, java.util.concurrent.TimeUnit.MILLISECONDS);
        Intent nextStartedActivity = shadowOf(splashActivity).getNextStartedActivity();
        assertNotNull(nextStartedActivity);
        assertEquals(MainActivity.class.getName(), nextStartedActivity.getComponent().getClassName());
    }
}

