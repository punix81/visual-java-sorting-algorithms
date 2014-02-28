package ch.mas.ict.ressources;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * @file    	Message.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 déc. 2010 00:45:30
 * @mail 		lopespaulo18@gmail.com
 * @Description
 */
public class Message {

	private static String bundleName = "MessagesBundle";
	private static Object params[] = null; 
	private static Locale locale = Locale.getDefault();  

	/**
	 * 
	 * @param defaultObject
	 * @return
	 */
	protected static ClassLoader getCurrentClassLoader(Object defaultObject){
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if(loader == null){
			loader = defaultObject.getClass().getClassLoader();
		}
		return loader;
	}

	/**
	 * Méthode qui retourne une chaine de caractère traduite selon la langue par 
	 * défaud de la JVM.
	 * @param key Clé de la valeur que l'on souhaite traduire. 
	 * @return Message traduit.
	 */
	public static String getMessageResourceString(String key){

		String text = null;
		ResourceBundle bundle = 
			ResourceBundle.getBundle(  bundleName, locale, 
					getCurrentClassLoader(params));
		try{
			text = bundle.getString(key);
		} catch(Exception e){
			text = "?? key " + key + " not found ??";
		}

		if(params != null){
			MessageFormat mf = new MessageFormat(text, locale);
			text = mf.format(params, new StringBuffer(), null).toString();
		}
		return text;
	}
}