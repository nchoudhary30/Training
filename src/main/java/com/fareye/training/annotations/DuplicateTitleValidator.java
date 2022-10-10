package com.fareye.training.annotations;

import com.fareye.training.controller.TodoController;
import com.fareye.training.model.Todo;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class DuplicateTitleValidator implements ConstraintValidator<DuplicateTitle, Todo> {
    public boolean isValid(Todo todo, ConstraintValidatorContext constraintValidatorContext){
        for (Todo t : TodoController.todos) {
            if (t.getUser().getId() == todo.getUser().getId() && Objects.equals(t.getTitle(), todo.getTitle()))
                return false;
        }
        return true;
    }
}
