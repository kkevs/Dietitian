package controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.EditorDaoImpl;
import model.Editor;
import service.EditorServiceImlp;

@ManagedBean
@SessionScoped
public class EditorBean  implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private List<Editor> editorList;
	
	private Editor editor = new Editor();
	
	private Editor otherEditor = new Editor();
	

	public EditorBean() throws Exception {
		editorList = new  ArrayList<Editor>();
		EditorServiceImlp editorServiceImlp = new EditorServiceImlp();
		editorList = editorServiceImlp.getAllEditorList();
	}
	
	public void getOtherBean(int id){
		for (int i = 0; i < editorList.size(); i++) {
			if(editorList.get(i).getId()==id){
				otherEditor = editorList.get(i);
			}
		}
	}

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	public List<Editor> getEditorList() {
		return editorList;
	}

	public void setEditorList(List<Editor> editorList) {
		this.editorList = editorList;
	}
	

	public Editor getOtherEditor() {
		return otherEditor;
	}

	public void setOtherEditor(Editor otherEditor) {
		this.otherEditor = otherEditor;
	}

	public void addBlog() throws Exception {
		System.out.println("deneme");
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		editor.setDate(timestamp);
		EditorDaoImpl editorDaoImpl = new EditorDaoImpl();
		editorDaoImpl.saveEditor(editor);
	}

}
