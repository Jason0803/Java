package book.vo;

public class Book {
	private String isbn;
	private String title;
	private String writer;
	private String publisher;
	private int price;
	
	public Book(String isbn, String title, String writer, String publisher, int price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", writer=" + writer + ", publisher=" + publisher
				+ ", price=" + price + "]";
	}
	
	
	
}
