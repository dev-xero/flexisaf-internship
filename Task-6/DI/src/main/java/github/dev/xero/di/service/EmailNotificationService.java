package github.dev.xero.di.service;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService{
    @Override
    public void notify(String message) {
       System.out.println("Email:" + message);
    }
}
