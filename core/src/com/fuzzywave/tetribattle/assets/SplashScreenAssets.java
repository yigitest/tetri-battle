package com.fuzzywave.tetribattle.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.I18NBundle;
import com.fuzzywave.core.CoreLogger;
import com.fuzzywave.tetribattle.TetriBattleGame;

import java.util.Locale;

public class SplashScreenAssets {

    public static BitmapFont splashLogoFont;
    public static BitmapFont splashLoadingFont;
    public static BitmapFont splashWaveFont;
    public static Color splashColor1 = Color.valueOf("fe8c00");
    public static Color splashColor2 = Color.valueOf("f83600");
    public static I18NBundle splashBundle;
    private static String splashLogoFontFileName = "fonts/FUZZYWAVE.TTF";
    private static int splashLogoFontSize;
    private static String splashLoadingFontFileName = "fonts/LOADING.ttf";
    private static int splashLoadingFontSize;
    private static String splashWaveFontFileName = "fonts/GRAPH.TTF";
    private static int splashWaveFontSize;

    public static void load(int width, int height, Locale locale) {

        TetriBattleGame.analytics.logEvent("SPLASH_SCREEN_ASSETS_LOAD", true);

        if (splashBundle == null) {
            if (locale == null) {
                locale = Locale.getDefault();
            }
            splashBundle = I18NBundle.createBundle(Gdx.files.internal("local/splash"), locale);
        } else {
            if (locale != null) {
                if (!splashBundle.getLocale().equals(locale)) {
                    splashBundle = I18NBundle.createBundle(Gdx.files.internal("local/splash"),
                                                           locale);
                }
            }
        }

        int size = getSplashWaveFontSize(width, height);
        if (splashWaveFontSize != size) {
            CoreLogger.logDebug("Loading Splash Wave Font for Size: " + size);
            if (splashWaveFont != null) {
                splashWaveFont.dispose();
            }
            splashWaveFont = Assets.loadFont(splashWaveFontFileName, size);
            splashWaveFontSize = size;
        }

        size = getSplashLogoFontSize(width, height);
        if (splashLogoFontSize != size) {
            CoreLogger.logDebug("Loading Splash Logo Font for Size: " + size);
            if (splashLogoFont != null) {
                splashLogoFont.dispose();
            }
            splashLogoFont = Assets.loadFont(splashLogoFontFileName, size);
            splashLogoFontSize = size;
        }

        size = getSplashLoadingFontSize(width, height);
        if (splashLoadingFontSize != size) {
            CoreLogger.logDebug("Loading Splash Loading Font for Size: " + size);
            if (splashLoadingFont != null) {
                splashLoadingFont.dispose();
            }
            splashLoadingFont = Assets.loadFont(splashLoadingFontFileName, size);
            splashLoadingFontSize = size;
        }

        CoreLogger.logDebug("Loaded Splash Screen Assets.");
        TetriBattleGame.analytics.endTimedEvent("SPLASH_SCREEN_ASSETS_LOAD");
    }

    public static int getSplashWaveFontSize(int width, int height) {

        int defaultWidth = 480;
        int defaultSize = 50;

        int size = width * defaultSize / defaultWidth;
        return size;

    }

    public static int getSplashLogoFontSize(int width, int height) {
        int defaultWidth = 480;
        int defaultSize = 70;

        int size = width * defaultSize / defaultWidth;
        return size;
    }

    public static int getSplashLoadingFontSize(int width, int height) {
        int defaultWidth = 480;
        int defaultSize = 50;

        int size = width * defaultSize / defaultWidth;
        return size;
    }

}