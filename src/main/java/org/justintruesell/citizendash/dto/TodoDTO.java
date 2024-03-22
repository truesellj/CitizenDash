package org.justintruesell.citizendash.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.justintruesell.citizendash.models.Todo;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class TodoDTO{
    ArrayList<Todo> todos = new ArrayList<>();



}
