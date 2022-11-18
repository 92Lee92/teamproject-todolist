package teamproject.springtodo;

import teamproject.springtodo.domain.Todo;
import teamproject.springtodo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JpaMappingTest {
    private final String content = "내용";
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TestEntityManager testEntityManager;
    @Test
    private Todo getSaved(){
        Todo todo = Todo.builder()
                .content(content)
                .build();
        return testEntityManager.persist(todo);
    }
    @Test
    public void test_get(){
        //GIVEN
        Todo todo = getSaved();
        System.out.println("===================");
        System.out.println(todo.getId());
        System.out.println(todo.getContent());
        System.out.println(todo.getIsComplete());
        System.out.println("===================");

        Long id = todo.getId();

        //WHEN
        Todo savedTodo = todoRepository.getReferenceById(id);

        //THEN
        assertThat(savedTodo.getContent()).isEqualTo(content);
        assertThat(savedTodo.getContent()).isEqualTo(todo.getContent());
    }
    @Test
    public void test_save(){
        //GIVEN
        Todo todo = Todo.builder()
                    .content("내용1")
                    .isComplete(true)
                    .build();
        //WHEN
        Todo savedTodo = todoRepository.save(todo);
        System.out.println("=================");
        System.out.println(savedTodo.getId());
        System.out.println(savedTodo.getContent());
        System.out.println(savedTodo.getIsComplete());
        System.out.println("==================");

        //THEN
        assertThat(savedTodo.getId()).isGreaterThan(0);
        assertThat(savedTodo.getContent()).isEqualTo("내용1");
        assertThat(savedTodo.getIsComplete()).isEqualTo(true);
    }

    @Test
    public void test_delete(){
        //GIVEN
        Todo todo = getSaved();
        System.out.println("==================");
        System.out.println(todo.getId());
        System.out.println(todo.getContent());
        System.out.println(todo.getIsComplete());
        System.out.println("==================");
        Long id = todo.getId();

        //WHEN
        todoRepository.deleteById(id);

        //THEN
        assertThat(testEntityManager.find(Todo.class,id)).isNull();
    }


}
