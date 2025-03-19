var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __spreadArray = (this && this.__spreadArray) || function (to, from, pack) {
    if (pack || arguments.length === 2) for (var i = 0, l = from.length, ar; i < l; i++) {
        if (ar || !(i in from)) {
            if (!ar) ar = Array.prototype.slice.call(from, 0, i);
            ar[i] = from[i];
        }
    }
    return to.concat(ar || Array.prototype.slice.call(from));
};
function registerUser(name, age) {
    if (age < 18) {
        return "Sorry ".concat(name, ", you are not eligible to register.");
    }
    return "Welcome ".concat(name, ", you are successfully registered.");
}
console.log(registerUser('Tanuj', 22));
console.log(registerUser('Tanuja', 17));
// arrays in ts
var numbers = [1, 2, 3, 4, 5, 6];
var names = ["temp1", "temp2", "temp3", "temp4"];
console.log(numbers);
console.log(numbers[0]);
// tuples in ts -> fixed length of diff data types..
var user = ["temp", 703417199, true];
console.log(user);
console.log(user[0]);
//Enums -> define a set of named constants
var Status;
(function (Status) {
    Status[Status["Active"] = 0] = "Active";
    Status[Status["Inactive"] = 1] = "Inactive";
    Status[Status["Pending"] = 2] = "Pending";
})(Status || (Status = {}));
var userStatus = Status.Pending;
console.log(userStatus);
function checkOrderStatus(status) {
    switch (status) {
        case Status.Active:
            return "Your order is active";
        case Status.Inactive:
            return "Your order is inactive";
        case Status.Pending:
            return "Your order is pending";
        default:
            return "Invalid status";
    }
}
var userStatus1 = Status.Pending;
console.log(checkOrderStatus(userStatus1));
// union , literals
//union types -> variable can hold multiple values..
var value;
value = 1234;
value = "Hello";
function getInput(input) {
    return 'You entered : ' + input;
}
console.log(getInput(1234));
console.log(getInput('Hello World'));
function getUserRole(user) {
    return 'Your role is : ' + user;
}
console.log(getUserRole('admin'));
//Functions with optional parameters..
// Arrow functions..
var multiply = function (num1, num2, number) { return num1 * num2; };
console.log(multiply);
var usrName = function (name1, name2) { return name1 + ' ' + name2; };
console.log(usrName("temp1", "temp2"));
//Optional Parameter
function userDetails(name, age, status) {
    return "Name: ".concat(name, ", Age: ").concat(age, ", Status: ").concat(status);
}
console.log(userDetails("temp"));
console.log(userDetails("temp2", 23));
console.log(userDetails("temp3", 23, true));
//Default paramters..
function applyDiscount(price, discount) {
    if (discount === void 0) { discount = 0.1; }
    return price - (price * discount);
}
console.log(applyDiscount(100));
console.log(applyDiscount(100, 0.25));
var Person = /** @class */ (function () {
    // Constructor to initialize the member variables
    function Person(name, age) {
        this.name = name;
        this.age = age;
    }
    // Getter for the name property
    Person.prototype.getName = function () {
        return this.name;
    };
    // Setter for the name property
    Person.prototype.setName = function (name) {
        this.name = name;
    };
    // Getter for the age property
    Person.prototype.getAge = function () {
        return this.age;
    };
    // Setter for the age property
    Person.prototype.setAge = function (age) {
        if (age > 0) {
            this.age = age;
        }
        else {
            console.error("Age must be a positive number.");
        }
    };
    return Person;
}());
// Example usage of the Person class
var person1 = new Person("temp", 23);
console.log("Name: ".concat(person1.getName(), ", Age: ").concat(person1.getAge()));
person1.setName("temp 2");
person1.setAge(25);
console.log("Updated Name: ".concat(person1.getName(), ", Updated Age: ").concat(person1.getAge()));
var User = /** @class */ (function () {
    // Constructor to initialize the member variables
    function User(userName, userEmail, userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }
    // Getter for userName
    User.prototype.getUserName = function () {
        return this.userName;
    };
    // Setter for userName
    User.prototype.setUserName = function (userName) {
        this.userName = userName;
    };
    // Getter for userEmail
    User.prototype.getUserEmail = function () {
        return this.userEmail;
    };
    // Setter for userEmail
    User.prototype.setUserEmail = function (userEmail) {
        this.userEmail = userEmail;
    };
    User.prototype.getUserPassword = function () {
        return this.userPassword;
    };
    User.prototype.setUserPassword = function (userPassword) {
        this.userPassword = userPassword;
    };
    User.prototype.getDetails = function () {
        return "Name: ".concat(this.userName, ", Email: ").concat(this.userEmail);
    };
    return User;
}());
// Subclass AdminUser extending from User
var AdminUser = /** @class */ (function (_super) {
    __extends(AdminUser, _super);
    // Constructor to initialize the member variables and role
    function AdminUser(userName, userEmail, userPassword, role) {
        var _this = _super.call(this, userName, userEmail, userPassword) || this;
        _this.role = role;
        return _this;
    }
    // Getter for role
    AdminUser.prototype.getRole = function () {
        return this.role;
    };
    // Setter for role
    AdminUser.prototype.setRole = function (role) {
        this.role = role;
    };
    // Method to delete a user (dummy implementation)
    AdminUser.prototype.deleteUser = function () {
        console.log("User ".concat(this.getUserName(), " has been deleted."));
    };
    return AdminUser;
}(User));
// Subclass EndUser extending from User
var EndUser = /** @class */ (function (_super) {
    __extends(EndUser, _super);
    // Constructor to initialize the member variables and address
    function EndUser(userName, userEmail, userPassword, address) {
        var _this = _super.call(this, userName, userEmail, userPassword) || this;
        _this.address = address;
        return _this;
    }
    // Getter for address
    EndUser.prototype.getAddress = function () {
        return this.address;
    };
    // Setter for address
    EndUser.prototype.setAddress = function (address) {
        this.address = address;
    };
    // Method to view profile details
    EndUser.prototype.viewProfile = function () {
        return "Name: ".concat(this.getUserName(), ", Email: ").concat(this.getUserEmail(), ", Address: ").concat(this.address);
    };
    return EndUser;
}(User));
// Creating objects of AdminUser and EndUser
var admin = new AdminUser("Alice", "alice@example.com", "admin123", "Administrator");
console.log(admin.getDetails());
admin.deleteUser();
var endUser = new EndUser("Bob", "bob@example.com", "user123", "123 Main St");
console.log(endUser.viewProfile());
var personA = {
    name: 'Tanuj',
    age: 22,
    getDetails: function () {
        return "Name: ".concat(this.name, ", Age: ").concat(this.age);
    }
};
console.log(personA.getDetails());
var emp1 = {
    name: "Tanuj",
    age: 22,
    role: "Developer",
    getDetails: function () {
        return "Name : ".concat(this.name, ", Age : ").concat(this.role);
    },
    getRole: function () {
        return "Role : ".concat(this.role);
    },
};
var person2 = {
    name: "Tanuj",
    age: 22,
    role: "Developer"
};
console.log(person2);
// Generic function
function genFunction(value) {
    return value;
}
console.log(genFunction(10));
console.log(genFunction("Generics"));
// Create objects
var strGenInt = { content: "Typescript" };
var numGenInt = { content: 100.90 };
// Generic class
var DataStorage = /** @class */ (function () {
    function DataStorage() {
        this.items = [];
    }
    DataStorage.prototype.addItem = function (item) {
        this.items.push(item);
    };
    DataStorage.prototype.removeItem = function (item) {
        this.items = this.items.filter(function (i) { return i !== item; });
    };
    DataStorage.prototype.getItems = function () {
        return __spreadArray([], this.items, true);
    };
    return DataStorage;
}());
var textStorage = new DataStorage();
textStorage.addItem('Tanuj');
textStorage.addItem('Tanuja');
textStorage.addItem('Tarun');
console.log(textStorage.getItems());
textStorage.removeItem("Tanuj");
console.log(textStorage.getItems());
var numberStorage = new DataStorage();
numberStorage.addItem(10);
numberStorage.addItem(100);
numberStorage.addItem(10);
console.log(numberStorage.getItems());
