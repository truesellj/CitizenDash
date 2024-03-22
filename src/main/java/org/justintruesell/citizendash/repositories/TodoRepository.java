package org.justintruesell.citizendash.repositories;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.Data;
import org.justintruesell.citizendash.models.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    public List<Todo> findByOwner(String email);
    public Todo findByTitle(String title);
}
