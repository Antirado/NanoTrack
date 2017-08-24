package com.example.at.nanotrack;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by genessis on 24/08/17.
 */

public class Preferences {
    static final String ACTIVE= "active";
    static final String USERNAME= "username";
    static final String TRACKER = "tracker";
    static final String TRACKER_PASSWORD = "tracker_password";
    static final String REPETICION_ALARMA= "repeticion_alarma";
    static final String DISTANCIA_AUTORIZADA = "distancia_autorizada";
    static final String VELOCIDAD_MAXIMA= "velocidad_maxima";
    static final String SENSIBILIDAD= "sensibilidad";
    static final String TIEMPO_RASTREO_PRENDIDO= "tiempo_rastreo_prendido";
    static final String TIEMPO_RASTREO_APAGADO= "tiempo_rastreo_apagado";
    static final String REPETICION_RASTREO= "repeticion_rastreo";
    static final String ANGULO= "angulo";
    static final String CURRENT_ACTIVITY= "current_activity";

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    //CLEARS ALL SHARED PREFERENCES
    public static void clearAllPreferences(Context ctx){
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.clear();
        editor.apply();
    }

    // Active variable
    public static void setActive(Context ctx, String active) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(ACTIVE, active);
        editor.apply();
    }

    public static String getActive(Context ctx) {
        return getSharedPreferences(ctx).getString(ACTIVE, "");
    }

    public static void clearActive(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(ACTIVE, "");
        editor.apply();
    }

    // Username
    public static void setUsername(Context ctx, String username) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(USERNAME, username);
        editor.apply();
    }

    public static String getUsername(Context ctx) {
        return getSharedPreferences(ctx).getString(USERNAME, "");
    }

    public static void clearUsername(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(USERNAME, "");
        editor.apply();
    }

    // Tracker number
    public static void setTracker(Context ctx, String tracker) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(TRACKER, tracker);
        editor.apply();
    }

    public static String getTracker(Context ctx) {
        return getSharedPreferences(ctx).getString(TRACKER, "");
    }

    public static void clearTracker(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(TRACKER, "");
        editor.apply();
    }

    // Tracker Password
    public static void setTrackerPassword(Context ctx, String trackerPassword) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(TRACKER_PASSWORD, trackerPassword);
        editor.apply();
    }

    public static String getTrackerPassword(Context ctx) {
        return getSharedPreferences(ctx).getString(TRACKER_PASSWORD, "");
    }

    public static void clearTrackerPassword(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(TRACKER_PASSWORD, "");
        editor.apply();
    }

    // Repeticion alarma variable
    public static void setRepeticionAlarma(Context ctx, String repeticionAlarma) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(REPETICION_ALARMA, repeticionAlarma);
        editor.apply();
    }

    public static String getRepeticionAlarma(Context ctx) {
        return getSharedPreferences(ctx).getString(REPETICION_ALARMA, "");
    }

    public static void clearRepeticionAlarma(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(REPETICION_ALARMA, "");
        editor.apply();
    }

    // Distancia autorizada variable
    public static void setDistanciaAutorizada(Context ctx, String distAutorizada) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(DISTANCIA_AUTORIZADA, distAutorizada);
        editor.apply();
    }

    public static String getDistanciaAutorizada(Context ctx) {
        return getSharedPreferences(ctx).getString(DISTANCIA_AUTORIZADA, "");
    }

    public static void clearDistanciaAutorizada(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(DISTANCIA_AUTORIZADA, "");
        editor.apply();
    }

    // Velocidad Maxima variable
    public static void setVelocidadMaxima(Context ctx, String velMax) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(VELOCIDAD_MAXIMA, velMax);
        editor.apply();
    }

    public static String getVelocidadMaxima(Context ctx) {
        return getSharedPreferences(ctx).getString(VELOCIDAD_MAXIMA, "");
    }

    public static void clearVelocidadMaxima(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(VELOCIDAD_MAXIMA, "");
        editor.apply();
    }

    // Sensibilidad variable
    public static void setSensibilidad(Context ctx, String sensibilidad) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(SENSIBILIDAD, sensibilidad);
        editor.apply();
    }

    public static String getSensibilidad(Context ctx) {
        return getSharedPreferences(ctx).getString(SENSIBILIDAD, "");
    }

    public static void clearSensibilidad(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(SENSIBILIDAD, "");
        editor.apply();
    }

    // Tiempo de rastreo prendido variable
    public static void setTiempoRastreoPrendido(Context ctx, String tiempoRastreoPrendido) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(TIEMPO_RASTREO_APAGADO, tiempoRastreoPrendido);
        editor.apply();
    }

    public static String getTiempoRastreoPrendido(Context ctx) {
        return getSharedPreferences(ctx).getString(TIEMPO_RASTREO_PRENDIDO, "");
    }

    public static void clearTiempoRastreoPrendido(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(TIEMPO_RASTREO_APAGADO, "");
        editor.apply();
    }

    // Tiempo de rastreo apagado variable
    public static void setTiempoRastreoApagado(Context ctx, String tiempoRastreoApagado) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(TIEMPO_RASTREO_APAGADO, tiempoRastreoApagado);
        editor.apply();
    }

    public static String getTiempoRastreoApagado(Context ctx) {
        return getSharedPreferences(ctx).getString(TIEMPO_RASTREO_APAGADO, "");
    }

    public static void clearTiempoRastreoApagado(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(TIEMPO_RASTREO_APAGADO, "");
        editor.apply();
    }

    // Repeticion de rastreo variable
    public static void setRepeticionRastreo(Context ctx, String repRastreo) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(REPETICION_RASTREO, repRastreo);
        editor.apply();
    }

    public static String getRepeticionRastreo(Context ctx) {
        return getSharedPreferences(ctx).getString(REPETICION_RASTREO, "");
    }

    public static void clearRepeticionRastreo(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(REPETICION_RASTREO, "");
        editor.apply();
    }

    // Active variable
    public static void setAngulo(Context ctx, String angulo) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(ANGULO, angulo);
        editor.apply();
    }

    public static String getAngulo(Context ctx) {
        return getSharedPreferences(ctx).getString(ANGULO, "");
    }

    public static void clearAngulo(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(ANGULO, "");
        editor.apply();
    }

    // Current activity indicates from wich intent the sms is being sent
    // 1 --> MainActivity
    // 2 --> Rastreo
    // 3 --> Alarma
    // 4 --> Ajustes
    public static void setCurrentActivity(Context ctx, String currentActivity) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(CURRENT_ACTIVITY, currentActivity);
        editor.apply();
    }

    public static String getCurrentActivity(Context ctx) {
        return getSharedPreferences(ctx).getString(CURRENT_ACTIVITY, "");
    }

    public static void clearCurrentActivity(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(CURRENT_ACTIVITY, "");
        editor.apply();
    }


}
