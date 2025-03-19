import { Library } from './Library';
import { Book } from './Book';
 
const libtech = new Library();
 
const book1: Book = {
    id: 1,
    title: 'Revolution 2020',
    author: 'Chetan bhagat',
    isAvailable: () => true,
};
 
const book2: Book = {
    id: 2,
    title: 'Harry Potter',
    author: 'JK Rowling',
    isAvailable: () => true,
};
 
const book3: Book = {
    id: 3,
    title: 'The day',
    author: 'Deep sharma',
    isAvailable: () => true,
};
 
const book4: Book = {
    id: 4,
    title: 'Life in a boat',
    author: 'Harry Mitchel',
    isAvailable: () => true,
};
 
libtech.addBook(book1);
libtech.addBook(book2);
libtech.addBook(book3);
libtech.addBook(book4);
 
console.log(libtech.issueBook(1));
console.log(libtech.issueBook(2));
 
console.log('Available Books:');
console.log(libtech.listAllBooks());