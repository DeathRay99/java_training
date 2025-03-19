"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Library = void 0;
var Library = /** @class */ (function () {
    function Library() {
        this.books = [];
    }
    Library.prototype.addBook = function (book) {
        this.books.push(book);
    };
    Library.prototype.issueBook = function (id) {
        for (var i = 0; i < this.books.length; i++) {
            if (this.books[i].id === id) {
                if (this.books[i].isAvailable()) {
                    this.books[i].isAvailable = function () { return false; };
                    return "Book titled '".concat(this.books[i].title, "' has been issued.");
                }
            }
        }
        return 'Book not found.';
    };
    Library.prototype.returnBook = function (id) {
        for (var i = 0; i < this.books.length; i++) {
            if (this.books[i].id === id) {
                if (this.books[i].isAvailable()) {
                    this.books[i].isAvailable = function () { return true; };
                    return "Book titled '".concat(this.books[i].title, "' has been returned.");
                }
            }
        }
        return 'Book not found.';
    };
    Library.prototype.listAllBooks = function () {
        if (this.books.length === 0) {
            return 'No books available in the library.';
        }
        return this.books.map(function (book) { return "Title: ".concat(book.title, ", Author: ").concat(book.author, ", Available: ").concat(book.isAvailable()); }).join('\n');
    };
    return Library;
}());
exports.Library = Library;
