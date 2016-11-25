package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.User;
import service.UserServiceImpl;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
	private User user;
	private boolean b;

	public User getUser() {
		return user;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserBean() {
		user = new User();
	}

	public String addUser() throws Exception {
		System.out.println("bean");
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		int a = userServiceImpl.saveUser(user);

		if (a > 0) {
			return "index?faces-redirect=true";
		} else {
			return "erropage?faces-redirect=true";
		}

	}

	public String controlUser() throws Exception {
		System.out.println("inside controllerUser");
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		User user2 = userServiceImpl.controlUser(user);
		FacesContext context = FacesContext.getCurrentInstance();
		
		if (user2.getRole_id() == 1) {
			context.getExternalContext().getSessionMap().put("user", user2);
			b = true;
			return "editor?faces-redirect=true";
		}
		if (user2.getRole_id() == 2) {
			context.getExternalContext().getSessionMap().put("user", user2);
			b = true;
			return "index?faces-redirect=true";
		}
		b = false;
		return "errorpage?faces-redirect=true";

	}


	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index.xhtml?faces-redirect=true";
	}

}
