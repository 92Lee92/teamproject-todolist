package teamproject.springtodo;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import teamproject.springtodo.domain.Todo;
import teamproject.springtodo.repository.TodoRepository;



@SpringBootTest
class SpringtodoApplicationTests {

	@Autowired
	private TodoRepository todoRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testJpa() {

	}

}
