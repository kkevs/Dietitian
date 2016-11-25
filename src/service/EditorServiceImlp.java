package service;

import java.util.List;

import dao.EditorDaoImpl;
import model.Editor;

public class EditorServiceImlp implements EditorService {
	private static EditorDaoImpl editorDaoImlp;

	public EditorServiceImlp() {
		editorDaoImlp = new EditorDaoImpl();
	}

	public EditorDaoImpl getEditorDaoImpl() {
		return editorDaoImlp;
	}

	@Override
	public void saveEditor(Editor blog) {
		
	}

	public  List<Editor> getAllEditorList() throws Exception {
		return editorDaoImlp.getAllEditorList();
	}
	

	

}
