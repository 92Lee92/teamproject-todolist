package teamproject.springtodo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import teamproject.springtodo.domain.Todo;
import teamproject.springtodo.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {
    @Autowired
    private TodoService todoService;
    /*
    * 목록 조회
    * */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTodos() throws Exception{
        List<Todo> todos = todoService.getTodos(Sort.by(Sort.Direction.ASC,"id"));
        return ResponseEntity.ok(todos);
    }
    /*
    * 등록
    */
    @PostMapping
    public ResponseEntity<String>postTodo(@RequestBody Todo todo)throws Exception{
        todo.setIsComplete(false);
        todoService.postTodo(todo);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

    }
    /*
    * 수정
    */
    @PutMapping("/{id}")
    public ResponseEntity<String> putTodo(@PathVariable("id") Long id) throws Exception{
        Todo todo = todoService.findTodoById(id);
        Boolean IsComplete = todo.getIsComplete()?false:true;
        todo.setIsComplete(IsComplete);
        todoService.postTodo(todo);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

    }
    /*
    * 삭제
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id) throws Exception{
        todoService.deleteTodo(id);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

    }

}
