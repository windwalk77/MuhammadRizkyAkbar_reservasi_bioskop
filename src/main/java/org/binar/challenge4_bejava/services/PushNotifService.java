package org.binar.challenge4_bejava.services;

import org.binar.challenge4_bejava.dto.PushNotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;


@Service
public class PushNotifService {

    private Logger logger = LoggerFactory.getLogger(PushNotifService.class);
    private FirebaseNotifService firebaseNotifService;

    public PushNotifService(FirebaseNotifService firebaseNotifService) {
        this.firebaseNotifService = firebaseNotifService;
    }


    public void sendPushNotificationToToken(PushNotificationRequest request) {
        try {
            firebaseNotifService.sendMessageToToken(request);
        } catch (InterruptedException | ExecutionException e) {
            logger.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }


}
