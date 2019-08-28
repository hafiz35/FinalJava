import java.io.IOException;
import java.util.Scanner;
public class Login {
	public static void main(String[] args) throws InterruptedException{
		Scanner in=new Scanner(System.in);
		int option;
		UserValidate uv=new UserValidate();
		uv.users();
		String name,pass;
		boolean ch;
		Admin a=new Admin();
		a.movies();
		while(true){
			System.out.println("Login as\n1.Admin\n2.Customer\n3.Report\n4.Exit");
			option=in.nextInt();
			switch(option){
				case 1 : System.out.println("Enter user name : ");
							name=in.next();
							System.out.println("Enter password : ");
							pass=in.next();
							ch=uv.ValidUser(name,pass,"Admin");
							if(ch==true)
							{	a.menu();
							}
							else{
								System.out.println("Enter valid credentials");
							}
							break;
				case 2 : System.out.println("Enter user name : ");
							name=in.next();
							System.out.println("Enter password : ");
							pass=in.next();
							ch=uv.ValidUser(name,pass,"Customer");
							if(ch==true)
							{	Customer c=new Customer(name);
								c.menu();
							}
							else{
								System.out.println("Enter valid credentials");
							}
							break;
				case 3 : System.out.println("Report Generated");
						 break;
				case 4 : System.out.println("Exiting....");
						 Thread.sleep(1000);
						 System.exit(0);
						 break;
				default: System.out.println("Enter correct option"); 
			}
		}
	}
}