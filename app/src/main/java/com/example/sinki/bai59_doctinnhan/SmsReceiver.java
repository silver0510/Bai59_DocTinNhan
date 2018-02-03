package com.example.sinki.bai59_doctinnhan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sinki on 9/4/2017.
 */

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Object[] arrpdus = (Object[]) bundle.get("pdus");
        for(int i = 0;i < arrpdus.length;i++)
        {
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) arrpdus[i]);
            String noidung = smsMessage.getMessageBody();
            String phone = smsMessage.getOriginatingAddress();
            long time = smsMessage.getTimestampMillis();

            Date date = new Date(time);
            DateFormat format = new SimpleDateFormat("HH:mm:ss:SSS");
            String dateFormatted = format.format(date);

            Toast.makeText(context,
                            "Số phone: " + phone +
                            "\nNội dung: "+noidung +
                            "\n Nhận lúc: "+dateFormatted,Toast.LENGTH_SHORT).show();

        }
    }
}
