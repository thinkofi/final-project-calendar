package com.fastcampus.finalproject.core.domain.entity;

import com.fastcampus.finalproject.core.domain.Event;
import com.fastcampus.finalproject.core.domain.Notification;
import com.fastcampus.finalproject.core.domain.ScheduleType;
import com.fastcampus.finalproject.core.domain.Task;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "schedule")
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String title;
    private String description;
    @JoinColumn(name = "writer_id")
    @ManyToOne
    private User writer;


    @Enumerated(EnumType.STRING)
    private ScheduleType scheduleType;

//    @Builder.Default
    private LocalDateTime createdAt;

    public static Schedule event(String title, String description, LocalDateTime startAt, LocalDateTime endAt, User writer) {
        return Schedule.builder()
                .title(title)
                .description(description)
                .startAt(startAt)
                .endAt(endAt)
                .writer(writer)
                .scheduleType(ScheduleType.EVENT)
                .build();
    }

    public static Schedule task(String title, String description, LocalDateTime startAt, LocalDateTime endAt, User writer) {
        return Schedule.builder()
                .title(title)
                .description(description)
                .startAt(startAt)
                .endAt(endAt)
                .writer(writer)
                .scheduleType(ScheduleType.TASK)
                .build();
    }

    public static Schedule notification(String title, String description, LocalDateTime startAt, LocalDateTime endAt, User writer) {
        return Schedule.builder()
                .title(title)
                .description(description)
                .startAt(startAt)
                .endAt(endAt)
                .writer(writer)
                .scheduleType(ScheduleType.NOTIFICATION)
                .build();
    }

    public Task toTak() {
        return new Task(this);
    }

    public Event toEvent() {
        return new Event(this);
    }

    public Notification toNotification() {
        return new Notification(this);
    }
}
