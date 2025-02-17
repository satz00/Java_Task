package com.task.PatientAppointmentBookingSystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Patient Appointment Booking API")
                        .version("1.0")
                        .description("API documentation for the Patient Appointment Booking System"));
    }
}
