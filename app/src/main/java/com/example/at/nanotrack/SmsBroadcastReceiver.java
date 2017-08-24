package com.example.at.nanotrack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Created by genessis on 24/08/17.
 */

public class SmsBroadcastReceiver extends BroadcastReceiver {

    public static final String SMS_BUNDLE = "pdus";

    public void onReceive(Context context, Intent intent) {
        Bundle intentExtras = intent.getExtras();

        if (intentExtras != null) {
            Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);
            //String smsMessageStr = "";
            String smsBody ="", address = "";
            for (int i = 0; i < sms.length; ++i) {
                String format = intentExtras.getString("format");
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i], format);

                smsBody = smsMessage.getMessageBody().toString();
                address = smsMessage.getOriginatingAddress();

                //smsMessageStr += "SMS From: " + address + "\n";
                //smsMessageStr += smsBody + "\n";
            }

            if(Preferences.getCurrentActivity(context).equals("1")){
                MainActivity inst = MainActivity.instance();
                inst.updateInbox(address, smsBody);
            }

            if(Preferences.getCurrentActivity(context).equals("2")){
                Rastreo inst = Rastreo.instance();
                inst.updateInbox(address, smsBody);
            }

            if(Preferences.getCurrentActivity(context).equals("3")){
                Alarma inst = Alarma.instance();
                inst.updateInbox(address, smsBody);
            }

            if(Preferences.getCurrentActivity(context).equals("4")){
                Ajustes inst = Ajustes.instance();
                inst.updateInbox(address, smsBody);
            }

        }
    }
}
