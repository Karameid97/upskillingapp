package project.mb;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import util.Massage;

@SessionScoped
@ManagedBean(name = "mbLog")
public class MBScurityLogin {

	private String username;
	private String password;
	private boolean login;
	
	private String lang ="en";
	private Locale locale = Locale.ENGLISH;
	private String dir= "ltr";
	private static Map<String, Object> countries;
	
	static {
		countries = new LinkedHashMap<String, Object>();
		countries.put("English", Locale.ENGLISH);
		countries.put("عربي", new Locale("ar"));
	}
	
	public void localeChanged(ValueChangeEvent e) {
        lang = e.getNewValue().toString();
        for (Map.Entry<String, Object> entry : getCountries().entrySet()) {
            if (entry.getValue().toString().equals(lang)) {
                locale = lang.equals("en") ? Locale.ENGLISH : new Locale(lang);
                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
                dir = lang.equals("ar") ? "rtl" : "ltr";
            }
        }
    }

	public String checkLogin() {
		if (username.equalsIgnoreCase("karam") && password.equalsIgnoreCase("123")) {
			login = true;
			Massage.addMessagByKey("INFO","","msg_welcome" );
			return "/home.xhtml";
		} else {
			login = false;
			Massage.addMassage("ERROR", "", "Please check username or password");
			return null;
		} 
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return"/home.xhtml?faces-rsdirect=true";
	}

	// setters && getters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public Locale getLocal() {
		return locale;
	}
	public void setLocal(Locale local) {
		this.locale = local;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public  Map<String, Object> getCountries() {
		return countries;
	}
	

}
