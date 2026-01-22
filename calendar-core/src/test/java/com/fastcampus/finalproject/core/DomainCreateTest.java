package com.fastcampus.finalproject.core;

import com.fastcampus.finalproject.core.domain.ScheduleType;
import com.fastcampus.finalproject.core.domain.entity.Schedule;
import com.fastcampus.finalproject.core.domain.entity.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Test code for creating domain entities
public class DomainCreateTest {

    @Test
    void eventCreate() {
        final User me = new User("memo", "email", "pass", LocalDate.now());
        final Schedule taskSchedule = Schedule.task("할일", "청소하기", LocalDateTime.now(), LocalDateTime.now(), me);
        assertEquals(taskSchedule.getScheduleType(), ScheduleType.TASK);
        assertEquals(taskSchedule.toTak().getTitle(), "할일");
        assertEquals(taskSchedule.toTak().getDescription(), "청소하기");
    }
}
