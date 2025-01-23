package com.espe.reloj.demo.controller;

import com.espe.reloj.demo.service.NtpSyncService;
import com.espe.reloj.demo.service.NtpSyncService.TimeSyncResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NtpSyncController {

    @Autowired
    private NtpSyncService ntpSyncService;

    @GetMapping("/sync-time")
    public TimeSyncResponse syncTime(@RequestParam String timezone) {
        return ntpSyncService.getNtpTime(timezone);
    }
}
