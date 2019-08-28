import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
public class Movielistcustomer {
	Scanner in=new Scanner(System.in);
	public Movielistcustomer(String cname){
		this.cname=cname;
	}
	public Movielistcustomer(String title, String cname, String boxoffice, String genre) {
		super();
		this.title = title;
		this.cname = cname;
		this.boxoffice = boxoffice;
		this.genre = genre;
	}
	public static ArrayList<Movielistcustomer> mlc=new ArrayList();
	private String title,cname,boxoffice,genre;
	public  boolean addofavourites(){
		MoviesDatabase md=new MoviesDatabase();
		md.viewmovies();
		int i=0;
		System.out.println("Enter the movie number to add to your favourite list : ");
		int index=in.nextInt();
		Iterator it=md.al.iterator();
		while(it.hasNext()){
			MoviesDatabase md1=(MoviesDatabase) it.next();
			if(i==index-1){
				mlc.add(new Movielistcustomer(md1.getTitle(),this.cname,md1.getBoxoffice(),md1.getGenre()));
				System.out.println("Successfully added to your favourite list");
				return true;
			}
			i++;
		}
		System.out.println("Cannot add to favourites");
		return false;
	}
	public boolean removefromfavourites(){
		viewmovies();
		System.out.println("Enter the movie number to remove from your favourite list : ");
		int index=in.nextInt();
		if(mlc.size()>=index){
			mlc.remove(index-1);
			System.out.println("Successfully removed from your favourite list");
			return true;
		}
		else
		{	System.out.println("Cannot remove movie");
			return false;	
		}
	}
	public void viewmovies(){
		System.out.println("List movies\n1.Ascending order\n2.Descending order\n3.Return to Previous menu");
		int ch=in.nextInt();
		Comparator<Movielistcustomer> comparemovieNameasc = (Movielistcustomer o1, Movielistcustomer o2) ->
        o1.title.compareTo( o2.title );
		if(ch==1){
			Collections.sort(mlc,comparemovieNameasc);
		}
		else if(ch==2){
			Collections.sort(mlc,Collections.reverseOrder(comparemovieNameasc));
		}
		else{
			return;
		}
		Iterator it=mlc.iterator();
		System.out.println("Title     Customer Name    Boxoffice      Genre");
		while(it.hasNext()){
			Movielistcustomer ml=(Movielistcustomer) it.next();
			System.out.println(ml.title+"  "+cname+"  "+ml.boxoffice+"  "+ml.genre);
		}
	}
}
