import { Book } from './Book';
 
class Library {
    private books: Book[] = [];
 
    public addBook(book: Book): void {
        this.books.push(book);
    }
 
    public issueBook(id: number): string {
        for(let i=0; i<this.books.length; i++){
            if(this.books[i].id === id){
                if(this.books[i].isAvailable()){
                    this.books[i].isAvailable =() => false;
                    return `Book titled '${this.books[i].title}' has been issued.`;
                }
            }
        }
            return 'Book not found.';
    }
 
    public returnBook(id: number): string {
        for(let i=0; i<this.books.length; i++){
            if(this.books[i].id === id){
                if(this.books[i].isAvailable()){
                    this.books[i].isAvailable =() => true;
                    return `Book titled '${this.books[i].title}' has been returned.`;
                }
            }
        }
            return 'Book not found.';
 
    }

    public listAllBooks(): string {
        if (this.books.length === 0) {
            return 'No books available in the library.';
        }
        return this.books.map(book => `Title: ${book.title}, Author: ${book.author}, Available: ${book.isAvailable()}`).join('\n');
    }
}
 
export { Library };  
