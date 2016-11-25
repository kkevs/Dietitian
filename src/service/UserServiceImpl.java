package service;

import dao.UserDAOImpl;
import model.User;

public class UserServiceImpl implements UserService {

	private static UserDAOImpl userDAOImpl;

	public UserServiceImpl() {
		userDAOImpl = new UserDAOImpl();
	}

	public UserDAOImpl getUserDAOImpl() {
		return userDAOImpl;
	}

	@Override
	public int saveUser(User user) throws Exception {
		return getUserDAOImpl().saveUser(user);
		
	}

	public User controlUser(User user) throws Exception {
		System.out.println("service");
		return getUserDAOImpl().controlUser(user);
	}

}
