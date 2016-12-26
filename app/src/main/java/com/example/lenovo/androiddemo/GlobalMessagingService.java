package com.example.lenovo.androiddemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by admin on 12/26/2016.
 */

public class GlobalMessagingService extends FirebaseMessagingService {

    private static final String TAG = GlobalMessagingService.class.getName();
    private int NOTIFICATION_ID = 1;  // 1 order assigned

    String notificationTitle;
    String notificationMessage;
    String from;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getData().size() > 0) {

              Log.e(TAG, "Message data payload: " + remoteMessage.getData());

            if (remoteMessage.getNotification() != null) {

              Log.e(TAG, "Message Notification Title: " + remoteMessage.getNotification().getTitle() );
              Log.e(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody() );
              Log.e(TAG, "Message Notification Sent Time: " + remoteMessage.getSentTime());
              Log.e(TAG, "Message Notification From: " + remoteMessage.getFrom());
              Log.e(TAG, "Message Notification To: " + remoteMessage.getTo());

                notificationTitle = remoteMessage.getNotification().getTitle();
                notificationMessage = remoteMessage.getNotification().getBody();
                from = remoteMessage.getFrom();

                sendNotification(notificationTitle,notificationMessage,from);



            }
            else
                Log.e(TAG, "Notification is null" );

        }
        else
        Log.e(TAG, "Message data payload: NO DATA");

    }



    private void sendNotification(String title, String message, String from) {

        Intent intent = new Intent(GlobalMessagingService.this, Class.class);
        intent.putExtra("msg", message);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                NOTIFICATION_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationBuilder.setContentText(message);
        notificationBuilder.setContentTitle("AndroidApp " + title);
        notificationBuilder.setSound(defaultSoundUri);
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setContentIntent(pendingIntent);

        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());


    }



}
