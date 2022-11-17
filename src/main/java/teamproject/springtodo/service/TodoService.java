package teamproject.springtodo.service;

import org.springframework.data.domain.Sort;
import teamproject.springtodo.domain.Todo;

import java.util.List;

public interface TodoService {
    List<Todo>getTodos(Sort sort) throws Exception;
    void postTodo(Todo todo) throws Exception;
    void deleteTodo(Long Id) throws Exception;
    Todo findTodoById(Long Id) throws Exception;
}
