package tech.itpark.itpark2021.lesson39.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@Aspect
@Order
@Component
@Slf4j
public class LoggingAspect {

    @Before("within(tech.itpark.itpark2021.lesson39.service.impl.TownDirectoryServiceImpl)")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Класс : " + joinPoint.getTarget().getClass().getName());
        log.info("метод : " + joinPoint.getSignature().getName());
        log.info("Аргументы метода : " + Arrays.stream(joinPoint.getArgs())
                .map(Objects::toString)
                .collect(Collectors.joining(", ")));
    }

}
