package teamproject.springtodo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import teamproject.springtodo.domain.Todo;
import teamproject.springtodo.repository.TodoRepository;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class SpringtodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringtodoApplication.class, args);
	}
//	@Bean
//	public CommandLineRunner runner(TodoRepository todoRepository) throws Exception{
//		return (args) -> {
//			IntStream.rangeClosed(1,10).forEach(index->todoRepository.save(Todo.builder()
//					.content("오늘 할 일"+index)
//					.createdDateTime(LocalDateTime.now())
//					.isComplete(false)
//					.build())
//			);
//		};
//	}
}
