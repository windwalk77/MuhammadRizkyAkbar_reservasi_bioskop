package org.binar.challenge4_bejava.controllers;

import org.binar.challenge4_bejava.dto.PushNotificationRequest;
import org.binar.challenge4_bejava.dto.PushNotificationResponse;
import org.binar.challenge4_bejava.services.PushNotifService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private PushNotifService pushNotificationService;

    public NotificationController(PushNotifService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }


    @PostMapping("/token")
    public ResponseEntity<PushNotificationResponse> sendTokenNotification(@RequestBody PushNotificationRequest request) {
        pushNotificationService.sendPushNotificationToToken(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }



}

