package dao;

import java.sql.SQLException;

import model.User;

public interface UserDAO {
	public int saveUser(User user) throws SQLException, Exception;
	public User controlUser(User user) throws Exception;
}
