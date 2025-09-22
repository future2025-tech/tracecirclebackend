package com.tracecirclebackend.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tracecirclebackend.entity.PasswordHistory;
import com.tracecirclebackend.entity.UserEntity;
import com.tracecirclebackend.repository.PasswordHistoryRepository;
import com.tracecirclebackend.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl {
	
    private final UserRepository userRepo;
    private final PasswordHistoryRepository historyRepo;
    private final BCryptPasswordEncoder encoder;
    
    @Transactional
    public UserEntity createUser(String email, String rawPassword) {
        if (userRepo.findByEmail(email) != null) {
            throw new IllegalStateException("User with this email already exists");
        }

        String hashedPassword = encoder.encode(rawPassword);

        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setPassword(hashedPassword);

        userRepo.save(user);

        PasswordHistory ph = new PasswordHistory();
        ph.setEmail(email);
        ph.setPassword(hashedPassword);
        ph.setChangedAt(LocalDateTime.now());
        historyRepo.save(ph);

        return user;
    }

    
    public boolean isPasswordUsedBefore(String email, String newPassword) {
    	
        List<PasswordHistory> history = historyRepo
        		.findTop3ByEmailOrderByChangedAtDesc(email);
        
        for (PasswordHistory ph : history) {
            if (encoder.matches(newPassword, ph.getPassword()))
            	return true;
        }
        return false;
    }

    public void updatePassword(String email, String newPassword) {
       
    	UserEntity user = userRepo.findByEmail(email);
        String hashed = encoder.encode(newPassword);
        user.setPassword(hashed);
        userRepo.save(user);

        PasswordHistory ph = new PasswordHistory();
        ph.setEmail(email);
        ph.setPassword(hashed);
        ph.setChangedAt(LocalDateTime.now());
        historyRepo.save(ph);
    }
    
    public void deleteUser(String email) {

    	UserEntity user = userRepo.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        List<PasswordHistory> historyList = historyRepo
        		.findTop3ByEmailOrderByChangedAtDesc(email);
        
        if (!historyList.isEmpty()) {
            historyRepo.deleteAll(historyList);
        }

        userRepo.delete(user);
    }

}
