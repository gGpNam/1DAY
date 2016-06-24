package basic;

import basic.AbUser;
//import java.sql.Connection;
//import java.sql.SQLException;

public class User <E extends AbUser<? extends Collection<? extends Iterable>>> {
	private int id;
	private String name;
	private String password;
	private String isUse;
	
	//Use Generic Type Class 
	public <QQ extends Comparable<? super QQ>>QQ max(Collection<QQ> coll) {
			return null;
		}
	//	Use Method Oberriding, Use Parameter Association
	public enum NUM {
		ONE { String val() { return ""+1;}; String val2() { return ""+4;} },
		TWO { String val() { return ""+2;}; String val2() { return ""+5;} },
		THREE { String val() { return ""+3;}; String val2() { return ""+6;} };
		abstract String val();
		abstract String val2();
	}	 
	/**
	 * @return Returns the id.
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return Returns the isUse.
	 */
	public String getIsUse() {
		return isUse;
	}
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param isUse The isUse to set.
	 */
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param password The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString(){
		return id + "\t" + name + "\t"
		+ password + "\t";
	}
}
