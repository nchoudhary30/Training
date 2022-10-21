package com.fareye.training.model;

import com.fareye.training.annotations.DuplicateTitle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

enum Status{
    pending, done
}

@Getter @Setter @NoArgsConstructor @DuplicateTitle
public class Todo {
    @NotNull @Min(value = 2880, message = "ID must be greater than 2880")
    int id;
    LocalDate modifiedDate = LocalDate.now();
    LocalDate dueDate = LocalDate.now();
    LocalDate createdDate = LocalDate.now();
    private String body;
    @NotNull(message = "Title must not be null")
    private String title;
    private Status status = Status.pending;
    User user;

}
