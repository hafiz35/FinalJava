import java.util.Scanner;
public class Admin extends MoviesDatabase{
	public Admin(){
		super();
	}
	public Admin(String title, String boxoffice, String active, String genre, String dateoflaunch, String hasteaser) {
		super(title, boxoffice, active, genre, dateoflaunch, hasteaser);
	}

	public void menu() throws InterruptedException{
		Scanner in=new Scanner(System.in);
		while(true)
		{System.out.println("Menu : \n1.Add Movies\n2.Edit Movies\n3.Remove movies\n4.View Movie List\n5.Logout");
		int option=in.nextInt();
		String title,boxoffice,active,dateoflaunch,genre,hasteaser;
		switch(option){
			case 1 :	System.out.println("Enter movie details :");
						title=in.next();
						boxoffice=in.next();
						active=in.next();
						dateoflaunch=in.next();
						genre=in.next();
						hasteaser=in.next();
						boolean check=validatemovie(new MoviesDatabase(title,boxoffice,active,dateoflaunch,genre,hasteaser));
						if(check==true)
							addmovies(new MoviesDatabase(title,boxoffice,active,dateoflaunch,genre,hasteaser));
						else
							System.out.println("Enter the proper movie details");
						break;
			case 2 :	System.out.println("Enter movie details :");
						title=in.next();
						boxoffice=in.next();
						active=in.next();
						dateoflaunch=in.next();
						genre=in.next();
						hasteaser=in.next();
						check=validatemovie(new MoviesDatabase(title,boxoffice,active,dateoflaunch,genre,hasteaser));
						if(check==true)
							editmovies(new MoviesDatabase(title,boxoffice,active,dateoflaunch,genre,hasteaser));
						else
							System.out.println("Enter the proper movie details");
						break;
			case 3 :	System.out.println("Enter the title of the movie");
						title=in.next();
						removemovies(title);
						break;
			case 4 :	viewmovies();
						break;
			case 5 :	System.out.println("Logging out....");
			 			Thread.sleep(1000);
			 			System.exit(0);
						break;
		}
		if(option==5)
			break;
		}
	}
}
