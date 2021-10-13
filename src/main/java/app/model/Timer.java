package app.model;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Timer {

    private Long nanoTime = System.nanoTime();

    @Bean
    public Long getTime() {
        return nanoTime;
    }
}
