package com.doranco.canal;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class App extends Application {
    public static final String CANAL_1_ID = "canal1MessageImportant";
    public static final String CANAL_2_ID = "canal2Message";
    @Override
    public void onCreate() {
        super.onCreate();
        //Configuration du canal très important
        NotificationChannel canal1 = new NotificationChannel(CANAL_1_ID,
                "Canal Message Important", NotificationManager.IMPORTANCE_HIGH);
    canal1.setDescription("Ceci est la description d'un canal de notification très important ");

        NotificationChannel canal2 = new NotificationChannel(CANAL_2_ID,
                "Canal Message Important", NotificationManager.IMPORTANCE_HIGH);
        canal1.setDescription("Ceci est la description d'un canal de notification très important ");

        //Creation canal avec NotificationManager
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(canal1);
        manager.createNotificationChannel(canal2);

    }
}
