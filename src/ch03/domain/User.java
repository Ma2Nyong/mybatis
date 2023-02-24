package ch03.domain;

import java.time.LocalDate;

import org.apache.ibatis.type.Alias;

@Alias("myUser")// 별명을 직접 붙힐 수 있다.
public class User {
	private int userId;
	private String userName;
	private LocalDate regDate;
	private Address address; // user has one address
	
	@Override
	public String toString() {
		return String.format("%d %s %s %s", userId, userName, regDate, address);
	}
}
