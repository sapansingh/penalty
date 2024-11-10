package com.inspection.penalty.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiScheduler {

    private final RestTemplate restTemplate;

    // Inject RestTemplate or create a bean for it
    public ApiScheduler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(cron = "0 0/45 * * * ?") // Cron expression for every 45 minutes
    //@Scheduled(fixedRate = 5000)
    @Scheduled(cron = "0 0/45 * * * ?") // Cron expression for every 45 minutes
    public void callApiEvery45Minutes() {
        String url = "http://192.168.200.10/pushservice/tokengerator.php"; // Replace with your API URL
        try {
            String response = restTemplate.getForObject(url, String.class);
            System.out.println("API response: " + response);
        } catch (Exception e) {
            System.err.println("Error calling the API: " + e.getMessage());
        }
    }
}
