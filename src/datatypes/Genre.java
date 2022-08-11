package datatypes;

public class Genre {
	
	private String[] allGenres = {"Fiction", "Kids", "Science", "Comics", "Sports"};
	private String genre;

	public Genre(int index){
		this.genre = allGenres[index];
	}

	public String getGenre() {
		return this.genre;
	}
	
}