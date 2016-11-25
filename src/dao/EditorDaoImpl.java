package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import db.DBConnection;
import model.Editor;

public class EditorDaoImpl extends DBConnection implements EditorDao {

	@Override
	public void saveEditor(Editor blog) throws Exception {
		newConnectDB();

		String SQL = "INSERT INTO tbl_editor(content,date,header)VALUES (?,?,?)";
		PreparedStatement preparedStatement = conn.prepareStatement(SQL);
		preparedStatement.setString(1, blog.getContent());
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		preparedStatement.setDate(2, date);
		preparedStatement.setString(3, blog.getHeader());
		preparedStatement.executeUpdate();
		disconnectDB();
	}

	public List<Editor> getAllEditorList() throws Exception {
		List<Editor> editorList = new ArrayList<Editor>();
		newConnectDB();
		String SQL = "SELECT * FROM tbl_editor ORDER BY id DESC";
		PreparedStatement preparedStatement;
		preparedStatement = conn.prepareStatement(SQL);
		ResultSet resultSet;
		resultSet = preparedStatement.executeQuery();
		Editor editor;
		while (resultSet.next()) {
			editor = new Editor();
			editor.setId(resultSet.getInt("id"));
			// editor.setImageLink(resultSet.getString("image_link"));
			editor.setContent(resultSet.getString("content"));
			editor.setDate(resultSet.getDate("date"));
			editor.setHeader(resultSet.getString("header"));
			editorList.add(editor);
		}
		disconnectDB();
		return editorList;
	}

}
