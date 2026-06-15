package com.kago.vpnapp.service;

import com.kago.vpnapp.service.ICallbackInterface;
import com.kago.vpnapp.service.IEventInterface;
import com.kago.vpnapp.service.IResultInterface;
import com.kago.vpnapp.service.IVoidInterface;
import com.kago.vpnapp.service.models.NotificationParams;
import com.kago.vpnapp.service.models.VpnOptions;

interface IRemoteInterface {
    void invokeAction(in String data, in ICallbackInterface callback);

    void quickStart(in String initParamsString,
                    in String paramsString,
                    in String stateParamsString,
                    in ICallbackInterface callback,
                    in IVoidInterface onStarted);

    void updateNotificationParams(in NotificationParams params);

    void startService(in VpnOptions options, in long runTime, in IResultInterface result);

    void stopService(in IResultInterface result);

    void setEventListener(in IEventInterface event);

    void setState(in String state);

    void updateDns(in String dns);

    String getAndroidVpnOptions();

    String getCurrentProfileName();

    String getRunTime();

    String getTraffic();

    String getTotalTraffic();

    void startListener();

    void stopListener();
}
