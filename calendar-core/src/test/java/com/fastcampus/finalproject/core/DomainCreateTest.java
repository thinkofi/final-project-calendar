package com.fastcampus.finalproject.core;

import com.fastcampus.finalproject.core.domain.Engagement;
import com.fastcampus.finalproject.core.domain.Event;
import com.fastcampus.finalproject.core.domain.RequestStatus;
import com.fastcampus.finalproject.core.domain.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DomainCreateTest {

    @Test
    void eventCreate() {
        final User writer = new User("seongho", "seongho@gmail.com", "pass",
                                LocalDate.now(), LocalDateTime.now());
        final User attendee = new User("attendee", "attendee@gmail.com", "pass",
                LocalDate.now(), LocalDateTime.now());
        final Event event = new Event(
                LocalDateTime.now(),
                LocalDateTime.now(),
                "title",
                "description",
                writer,
                LocalDateTime.now()
        );
        event.addEngagement(new Engagement(event, attendee, LocalDateTime.now(), RequestStatus.REQUESTED));
        assertEquals(event.getEngagements().get(0).getEvent().getWriter().getName(), "seongho");
    }
}
