package com.kago.vpnapp.service;

import com.kago.vpnapp.service.IAckInterface;

interface IEventInterface {
    oneway void onEvent(in String id, in byte[] data, in boolean isSuccess, in IAckInterface ack);
}
