package com.espe.reloj.demo.service;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Service
public class NtpSyncService {

    private static final String NTP_SERVER = "time.google.com";  // Servidor NTP de ejemplo

    public synchronized TimeSyncResponse getNtpTime(String timezone) {
        try {
            // Crear un cliente NTP
            NTPUDPClient client = new NTPUDPClient();
            InetAddress hostAddr = InetAddress.getByName(NTP_SERVER);  // Obtener la dirección IP del servidor NTP
            TimeInfo info = client.getTime(hostAddr);  // Obtener la hora desde el servidor NTP
            long returnTime = info.getReturnTime();  // Obtener el tiempo de respuesta

            // Verificar si el tiempo de respuesta es válido
            if (returnTime == 0) {
                return new TimeSyncResponse(timezone, "Error", "Error");
            }

            // Formatear el tiempo obtenido a una fecha legible
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String syncedTime = sdf.format(new Date(returnTime));  // Hora sincronizada

            // Obtener la hora local en la zona horaria seleccionada
            TimeZone tz = TimeZone.getTimeZone(timezone);
            sdf.setTimeZone(tz);
            String localTime = sdf.format(new Date());

            // Crear y retornar el objeto de respuesta
            return new TimeSyncResponse(timezone, localTime, syncedTime);
        } catch (Exception e) {
            e.printStackTrace();
            return new TimeSyncResponse(timezone, "Error", "Error: " + e.getMessage());
        }
    }

    public static class TimeSyncResponse {
        private String timezone;
        private String localTime;
        private String syncedTime;

        public TimeSyncResponse(String timezone, String localTime, String syncedTime) {
            this.timezone = timezone;
            this.localTime = localTime;
            this.syncedTime = syncedTime;
        }

        public String getTimezone() {
            return timezone;
        }

        public String getLocalTime() {
            return localTime;
        }

        public String getSyncedTime() {
            return syncedTime;
        }
    }
}
