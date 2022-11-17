package teamproject.springtodo;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import teamproject.springtodo.domain.Todo;
import teamproject.springtodo.repository.TodoRepository;

import java.time.LocalDateTime;

@SpringBootTest
class SpringtodoApplicationTests {

	@Autowired
	private TodoRepository todoRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testJpa() {
		Todo todo1 = new Todo();
		todo1.setContent("스프링 공부");
		todo1.setIsComplete(Boolean.FALSE);
		todo1.setCreatedDateTime(LocalDateTime.now());
		this.todoRepository.save(todo1);

		Todo todo2 = new Todo();
		todo2.setContent("리액트 공부");
		todo2.setIsComplete(Boolean.FALSE);
		todo2.setCreatedDateTime(LocalDateTime.now());
		this.todoRepository.save(todo2);
	}

}
