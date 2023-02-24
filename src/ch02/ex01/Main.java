package ch02.ex01;

import java.util.List;

import ch02.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class); // Class<ch02.ex01.Map>
		
		List<User> users = mapper.selectUsers();
		// 람다는 메서드가 데이터이다. 따라서 prlntln을 데이터로 넣어줄 수 있다.
		users.forEach(System.out::println);
	}
}
