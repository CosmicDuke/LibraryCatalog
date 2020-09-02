import java.util.HashMap;
import java.util.Map;

public class LibraryCatalogue {
	
	//Properties/Fields/Global Variable
	Map<String,Book> bookCollection = new HashMap<String, Book>();
	int CurrentDay = 0;
	int LengthOfCheckoutPeriod = 7;
	double initialLateFee =0.50;
	double feePerLateDay =1.00;
	
	
	//Constructor
	public LibraryCatalogue(Map<String, Book> collection) {
		this.bookCollection = collection;
	}
	//Using two constructor for more flexibility now
	//Constructor
	public LibraryCatalogue(Map<String, Book> collection, int lenghtOfCheckoutPeriod, double initialLateFee,
			double feePerLateDay ){
		  this.bookCollection = collection;
		  this.LengthOfCheckoutPeriod = lenghtOfCheckoutPeriod;
		  this.feePerLateDay = feePerLateDay;
		  this.initialLateFee = initialLateFee;
		
	}
	
	//Getters
	
	public int getCurrentDay() {
		return this.CurrentDay;
	}
	
	public Map<String, Book> getBookCollection(){
		return this.bookCollection;
	}
	
	public Book getBook(String bookTitle) {
		return getBookCollection().get(bookTitle);
	}
	
	public int getLengthofCheckoutPeriod() {
		return this.LengthOfCheckoutPeriod;
	}
	
	public double getInitialLateFee() {
		return this.initialLateFee;
	}
	
	public double getFeePerLateDay() {
		return this.feePerLateDay;
	}
	
	
	//Setters
	
	public void nextDay() {
		CurrentDay++;
	}
	
	
	public void setDay(int day) {
		CurrentDay=day;
	}
	
	
	//Instance Method
	public void checkOutBook(String title){
		Book book = getBook(title);
		if(book.getIsCheckedOut()) {
			sorrBookAlreadyCheckedOut(book);
			}else {
				book.setIsCheckedOut(true, CurrentDay);
				System.out.println("You just checked out "+ title + ". It is due on day " + 
				(getCurrentDay()+ getLengthofCheckoutPeriod())+".");
				
			}
		
		
	}
	
	
	public void returnBook(String title) {
		Book book = getBook(title);
		int dayLate = CurrentDay - (book.getDayCheckedOut()+ getLengthofCheckoutPeriod());
		if (dayLate >0)
		{
			System.out.println("You owe the library $"+ (getInitialLateFee()+ dayLate * getFeePerLateDay())+
					" because your book is "+ dayLate+" days overdue. ");
			
		}
		else {System.out.println("Book returned. Thank you.");}
		
		book.setIsCheckedOut(false, -1);
	}
	
	public void sorrBookAlreadyCheckedOut(Book book) {
		System.out.println("Sorry, "+book.getTitle()+ " is already checked out. "+ 
	"It should be back on day "+ (book.getDayCheckedOut()+getLengthofCheckoutPeriod())+".");
	}
		
		
		public static void main(String[] args) {
		
		Map<String, Book> bookCollection = new HashMap<String, Book>();
		Book harry = new Book ("Harry Potter", 4546546, 77777778);
		Book aaa = new Book ("aax",5665,777464);
		
		bookCollection.put("Harry Potter", harry);
		bookCollection.put("aax", aaa);
		
		LibraryCatalogue lib = new LibraryCatalogue(bookCollection);
		
		lib.checkOutBook("Harry Potter");
		lib.nextDay();
		lib.nextDay();
		lib.checkOutBook("Harry Potter");
		lib.checkOutBook("aax");
		lib.setDay(17);
		lib.returnBook("Harry Potter");
		lib.returnBook("aax");
		lib.checkOutBook("Harry Potter");
		
		
	}
}
