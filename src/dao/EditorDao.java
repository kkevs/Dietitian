package dao;

import java.sql.SQLException;

import model.Editor;

public interface EditorDao {
	public void saveEditor(Editor editor) throws SQLException, Exception;
	
}
