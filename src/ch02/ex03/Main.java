package ch02.ex03;

import java.time.LocalDate;

import ch02.domain.User;
import config.Configuration;

public class Main {
	public static void main(String[] args) {
		Map mapper = Configuration.getMapper(Map.class);
		
		/* 한번실행했음 또 실행하면 error 뜰것이다.
		if(mapper.insertUser(new User(11, "abel", LocalDate.of(2023, 1, 27))) > 0)
			System.out.println("성공11");
		
		if(mapper.insertUser(new User(12, null, null)) > 0)
			System.out.println("성공12");
		
		if(mapper.insertUser2(13, "kidanu", LocalDate.of(2023, 1, 27)) > 0)
			System.out.println("성공13");
		
		if(mapper.insertUser3(14, "neo", LocalDate.of(2023, 1, 27)) > 0)
			System.out.println("성공14");
		*/
	}
}
