package com.fareye.training.model;

import com.fareye.training.annotations.DuplicateTitle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

enum Status{
    pending, done
}

@Getter @Setter @NoArgsConstructor @DuplicateTitle
public class Todo {
    @NotNull
    int id;
    Date modifiedDate=new Date(), dueDate, createdDate;
    private String body;
    @NotNull
    private String title;
    private Status status = Status.pending;
    User user;

}
