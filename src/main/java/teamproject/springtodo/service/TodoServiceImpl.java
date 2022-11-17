package teamproject.springtodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import teamproject.springtodo.domain.Todo;
import teamproject.springtodo.repository.TodoRepository;

import java.util.List;
@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getTodos(Sort sort) throws Exception{
        return todoRepository.findAll(sort);
    }

    @Override
    public void postTodo(Todo todo) throws Exception {
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long Id) throws Exception {
        todoRepository.deleteById(Id);
    }

    @Override
    public Todo findTodoById(Long Id) throws Exception {
        return todoRepository.findById(Id).orElse(new Todo());
    }
}
