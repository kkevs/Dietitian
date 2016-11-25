package dao;

import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import db.DBConnection;
import model.User;

public class UserDAOImpl extends DBConnection implements UserDAO {

	@Override
	public int saveUser(User user) throws Exception {

		String insertSQL = "INSERT INTO tbl_kullanici(name,surname, email, password) VALUES (?,?,?,?);";
		newConnectDB();
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(user.getPassword().getBytes());
		byte messageDigestDizisi[] = messageDigest.digest();
		StringBuffer sb16 = new StringBuffer();
		for (int i = 0; i < messageDigestDizisi.length; i++) {
			sb16.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 16).substring(1));
		}
		PreparedStatement pstmt = conn.prepareStatement(insertSQL);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getSurname());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, sb16.toString());
		int i = 0;
		i = pstmt.executeUpdate();
		disconnectDB();

		return i;

	}

	public User controlUser(User user) throws Exception {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(user.getPassword().getBytes());
		byte messageDigestDizisi[] = messageDigest.digest();
		StringBuffer sb16 = new StringBuffer();
		for (int i = 0; i < messageDigestDizisi.length; i++) {
			sb16.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 16).substring(1));
		}

		String selectSQL = "SELECT * FROM tbl_kullanici WHERE email='" + user.getEmail() + "' and password='"
				+ sb16.toString() + "'";
		newConnectDB();
		Statement stmt;
		ResultSet rs;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(selectSQL);
		User kullanici =  new User();
		while (rs.next()) {
			kullanici.setEmail(rs.getString("email"));
			kullanici.setId(rs.getInt("id"));
			kullanici.setPassword(rs.getString("password"));
			kullanici.setSurname(rs.getString("surname"));
			kullanici.setRole_id(rs.getInt("rol_id"));
		}
		disconnectDB();
		return kullanici;
	}

}
