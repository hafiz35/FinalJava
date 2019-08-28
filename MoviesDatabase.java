import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
public class MoviesDatabase {
	Scanner in=new Scanner(System.in);
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBoxoffice() {
		return boxoffice;
	}
	public void setBoxoffice(String boxoffice) {
		this.boxoffice = boxoffice;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getDateoflaunch() {
		return dateoflaunch;
	}
	public void setDateoflaunch(String dateoflaunch) {
		this.dateoflaunch = dateoflaunch;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getHasteaser() {
		return hasteaser;
	}
	public void setHasteaser(String hasteaser) {
		this.hasteaser = hasteaser;
	}
	public static ArrayList<MoviesDatabase> getAl() {
		return al;
	}
	public static void setAl(ArrayList<MoviesDatabase> al) {
		MoviesDatabase.al = al;
	}
	private String title,boxoffice,active,dateoflaunch,genre,hasteaser;
	public static ArrayList<MoviesDatabase> al=new ArrayList();
	public MoviesDatabase(){
	}
	public MoviesDatabase(String title, String boxoffice, String active, String genre, String dateoflaunch,
			String hasteaser) {
		super();
		this.title = title;
		this.boxoffice = boxoffice;
		this.active = active;
		this.genre = genre;
		this.dateoflaunch = dateoflaunch;
		this.hasteaser = hasteaser;
	}
	public static ArrayList<MoviesDatabase> movies(){
		al.add(new MoviesDatabase("Avatar","2787965087","Yes","15/03/2017","Science Fiction","Yes"));
		al.add(new MoviesDatabase("TheAvengers","1518812988","Yes","23/12/2017","Superhero","No"));
		al.add(new MoviesDatabase("Titanic","2187324123","Yes","21/08/2017","Romance","No"));
		al.add(new MoviesDatabase("JurassicWorld","2324123432","No","02/07/2017","Science Fiction","Yes"));
		al.add(new MoviesDatabase("Avengers:Endgame","3214213123","Yes","02/11/2022","Superhero","Yes"));
		return al;
	}
	public static void addmovies(MoviesDatabase m){
		al.add(m);
		System.out.println("Movie added Successfully");
	}
	public static boolean validatemovie(MoviesDatabase m){
		boolean check=true;
		int i = Integer.parseInt(m.boxoffice);		
		if(!(m.title.matches("[A-Z][a-z]*") && m.title.length()>0))
		{	return false;
		}
		if(i>0)
		{	return false;
		}
		if(!(m.genre.equals("Action") || m.genre.equals("Adventure") || m.genre.equals("Comedy") || m.genre.equals("Family")))
		{	return false;
		}
		return true;
	}
	public static boolean editmovies(MoviesDatabase m){
		int index=0;
		Iterator it=al.iterator();
		while(it.hasNext()){
			MoviesDatabase md=(MoviesDatabase) it.next();
			if(md.title.equals(m.title))
			{	al.add(index,m);
				System.out.println("Movie edited successfully");
				return true;
			}
			index++;
		}
		System.out.println("Cannot edit movie");
		return false;
	}	
	public static boolean removemovies(String title){
		int index=0;
		Iterator it=al.iterator();
		while(it.hasNext()){
			MoviesDatabase md=(MoviesDatabase) it.next();
			if(md.title.equals(title))
			{	al.remove(index);
				System.out.println("Movie removed");
				return true;
			}
			index++;
		}
		System.out.println("Cannot remove movie");
		return false;
	}	
	public void viewmovies(){
		System.out.println("List movies\n1.Ascending order\n2.Descending order\n3.Return to Previous menu");
		int ch=in.nextInt();
		Comparator<MoviesDatabase> comparemovieNameasc = (MoviesDatabase o1, MoviesDatabase o2) ->
        o1.title.compareTo( o2.title );
		if(ch==1){
			Collections.sort(al,comparemovieNameasc);
		}
		else if(ch==2){
			Collections.sort(al,Collections.reverseOrder(comparemovieNameasc));
		}
		else{
			return;
		}
		Iterator it=al.iterator();
		System.out.println("Title         Boxoffice      Active      DateOfLaunch       Genre       Hasteaser");
		while(it.hasNext()){
			MoviesDatabase md=(MoviesDatabase) it.next();
			System.out.println(md.title+"    "+md.boxoffice+"    "+md.active+"    "+md.dateoflaunch+"    "+md.genre+"    "+md.hasteaser);
		}
	}
}
