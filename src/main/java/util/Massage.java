package util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

public class Massage {
	public static void addMassage( String severtity, String summary,String detil) {
		FacesMessage.Severity massageSeverity=null;
		switch(severtity.toUpperCase()) {
		case "INFO":
			massageSeverity= FacesMessage.SEVERITY_INFO;
			break;
		case "WARN":
			massageSeverity= FacesMessage.SEVERITY_WARN;
			break;
		case "ERROR":
			massageSeverity= FacesMessage.SEVERITY_ERROR;
			break;
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(massageSeverity, summary, detil ));
	}
	public static String getString(String key) {
		String lang =FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
		String baseName=(lang.equalsIgnoreCase("ar") ? "language.messages_ar" : "language.messages");
		ResourceBundle bundle= ResourceBundle.getBundle(baseName,FacesContext.getCurrentInstance().getViewRoot().getLocale());
		return bundle.getString(key) ;
	}
	public static void addMessagByKey(String severtity, String summary,String key) {
		addMassage(severtity, summary, getString(key));
		
	}

}
