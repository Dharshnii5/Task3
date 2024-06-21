class Book {
            private int bookID;
            private String title;
            private String author;
            private boolean isAvailable;

            public Book(int bookID, String title, String author, boolean isAvailable) {
                this.bookID = bookID;
                this.title = title;
                this.author = author;
                this.isAvailable = isAvailable;
            }

            public int getBookID() {
                return bookID;
            }

            public void setBookID(int bookID) {
                this.bookID = bookID;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public boolean getIsAvailable() {
                return isAvailable;
            }

            public void setIsAvailable(boolean isAvailable) {
                this.isAvailable = isAvailable;
            }

            @Override
            public String toString() {
                return "Book{" +
                        "bookID=" + bookID +
                        ", title='" + title + '\'' +
                        ", author='" + author + '\'' +
                        ", isAvailable=" + isAvailable +
                        '}';
            }
        }

        class Library {
            private Book[] books;
            private int numBooks;

            public Library() {
                this.books = new Book[100];
                this.numBooks = 0;
            }

            public void addBook(Book book) {
                if (numBooks == books.length) {
                    System.out.println("Library is full!");
                    return;
                }
                books[numBooks] = book;
                numBooks++;
            }

            public void removeBook(int bookID) {
                int index = -1;
                for (int i = 0; i < numBooks; i++) {
                    if (books[i].getBookID() == bookID) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println("Book not found!");
                    return;
                }

                for (int i = index; i < numBooks - 1; i++) {
                    books[i] = books[i + 1];
                }
                numBooks--;
            }

            public Book searchBook(int bookID) {
                for (int i = 0; i < numBooks; i++) {
                    if (books[i].getBookID() == bookID) {
                        return books[i];
                    }
                }
                return null;
            }

            public void displayBooks() {
                for (int i = 0; i < numBooks; i++) {
                    System.out.println(books[i]);
                }
            }
        }

        public class Main {
            public static void main(String[] args) {

                Library library = new Library();

                Book book1 = new Book(101, "Rapunzel", "Brothers Grimi", true);
                Book book2 = new Book(102, "Black Beauty", "Anna Sewell", true);
                Book book3 = new Book(103, "The Handmaid's Tale", "Margaret Atwood", false);
                Book book4 = new Book(104, "Gulliver's Travels", "Jonathan Swift", true);

                library.addBook(book1);
                library.addBook(book2);
                library.addBook(book3);
                library.addBook(book4);
                library.displayBooks();
                System.out.println("\nSearching for book with ID 102...");
                Book foundBook = library.searchBook(102);
                if (foundBook != null) {
                    System.out.println(foundBook);
                } else {
                    System.out.println("Book not found!");
                }

                System.out.println("\nRemoving book with ID 103...");
                library.removeBook(103);
                library.displayBooks();
            }
        }



