package com.doranco.tp6notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.doranco.canal.App;

public class MainActivity extends AppCompatActivity {
private NotificationManagerCompat notificationManagerCompat;
    private EditText editTextTitre;
    private EditText editTextMessage;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotifCanal1();

            }
        });
    }
    private void initComponents(){
        notificationManagerCompat = notificationManagerCompat.from(this);
        editTextTitre = findViewById(R.id.editTextTitreNotification);
        editTextMessage = findViewById(R.id.editTextMessageNotification);
        button = findViewById(R.id.buttonSendNotifCanal1);

        }

    private void sendNotifCanal1(){

        Notification notification = new NotificationCompat
                .Builder(this, App.CANAL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_message_24)
                .setContentTitle(editTextTitre.getText())
                .setContentText(editTextMessage.getText())
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1,notification);
    }
    private void sendNotifCanal2(){

        Notification notification = new NotificationCompat
                .Builder(this, App.CANAL_2_ID)
                .setSmallIcon(R.drawable.ic_baseline_message_24)
                .setContentTitle(editTextTitre.getText())
                .setContentText(editTextMessage.getText())
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1,notification);
    }
}