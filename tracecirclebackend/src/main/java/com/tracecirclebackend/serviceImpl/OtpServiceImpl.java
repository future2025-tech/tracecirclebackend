package com.tracecirclebackend.serviceImpl;

import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Service
public class OtpServiceImpl {
	
    private final SecureRandom random = new SecureRandom();
    private final Map<String, OtpData> otpStore = new ConcurrentHashMap<>();

    static class OtpData {
        String otp;
        LocalDateTime expiry;
    }

    public String generateOtp(String email) {
        String otp = String.valueOf(100000 + random.nextInt(900000));
        OtpData data = new OtpData();
        data.otp = otp;
        data.expiry = LocalDateTime.now().plusMinutes(5);
        otpStore.put(email, data);
        return otp;
    }

    public boolean validateOtp(String email, String otp) {
        OtpData data = otpStore.get(email);
        if (data == null || LocalDateTime.now().isAfter(data.expiry)) {
            otpStore.remove(email);
            return false;
        }
        return data.otp.equals(otp);
    }
}
