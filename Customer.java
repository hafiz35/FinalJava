import java.util.Scanner;
public class Customer {
	String cname;
	public Customer(String cname){
		this.cname=cname;
	}
	public void menu() throws InterruptedException{
		Scanner in=new Scanner(System.in);
		while(true)
		{System.out.println("Menu : \n1.Add to favourites\n2.Remove from favourites\n3.View Movie List\n4.Logout");
		int option=in.nextInt();
		Movielistcustomer m=new Movielistcustomer(cname);
		switch(option){
			case 1 :	m.addofavourites();
						break;
			case 2 :	m.removefromfavourites();
						break;
			case 3 :	m.viewmovies();
						break;
			case 4 :	System.out.println("Logging out....");
			 			Thread.sleep(1000);
			 			System.exit(0);
						break;
		}
		if(option==4)
			break;
		}
	}
}