package com.fareye.training.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

enum Status{
    pending, done
}
@Getter @Setter @NoArgsConstructor
public class Todo {
    Date modifiedDate=new Date(), dueDate, createdDate;
    private String body;
    @NotNull
    private String title;
    private Status status = Status.pending;
    User user;

}
