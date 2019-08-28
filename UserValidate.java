import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class UserValidate {

	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public UserValidate(){
		
	}
	public UserValidate(String customername, String password, String type) {
		super();
		this.customername = customername;
		this.password = password;
		this.type = type;
	}

	private String customername,password,type;
	public static ArrayList<UserValidate> al=new ArrayList();
	public static ArrayList<UserValidate> users(){
		
		al.add(new UserValidate("Sam","Sam007%","Admin"));
		al.add(new UserValidate("Jane","Jane007%","Customer"));
		al.add(new UserValidate("Drake","Drake007%","Customer"));
		al.add(new UserValidate("Tony","Tony007%","Customer"));
		return al;
	}
	public boolean ValidUser(String name,String pass,String t){
		int x=0;
		Iterator it=al.iterator();
		while(it.hasNext()){
			UserValidate uv=(UserValidate) it.next();
			if(uv.customername.equals(name)){
				if(uv.password.equals(pass) && uv.type.equals(t))
				{	return true;
				}
				break;
			}
		}
		return false;
	}
}
