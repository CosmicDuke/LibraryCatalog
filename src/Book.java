
public class Book {

	String Title;
	int PageCount;
	int ISBN;
	boolean isCheckedOut;
	int dayCheckedOut =-1;

	public Book(String bookTitle, int bookPageCount, int BookIsbn ){

		this.Title = bookTitle;
		this.PageCount = bookPageCount;
		this.ISBN = BookIsbn;
		isCheckedOut = false;
		dayCheckedOut= -1;

	}

	//getters

	public String getTitle(){
		return this.Title;
	}

	public int getPageCount(){
		return this.PageCount;
	}	

	public int getISBN(){
		return this.ISBN;
	}

	public boolean getIsCheckedOut(){
		return this.isCheckedOut;
	}

	public int getDayCheckedOut(){
		return this.dayCheckedOut;
	}

	//setters

	public void setIsCheckedOut(boolean newIsCheckedOut, int currentDayCheckedOut){
		this.isCheckedOut = newIsCheckedOut;
		setDayCheckedOut(currentDayCheckedOut);
	}

	private void setDayCheckedOut(int Day){
		this.dayCheckedOut = Day; 

	}
}
