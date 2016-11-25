package service;

import model.User;

public interface UserService {
	public int saveUser(User user) throws Exception;
	public User controlUser(User user) throws Exception;
}
