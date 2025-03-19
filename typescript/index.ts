function registerUser(name: string, age:number):string {
    if(age<18){
        return `Sorry ${name}, you are not eligible to register.`
    }
    return `Welcome ${name}, you are successfully registered.`
}
console.log(registerUser('Tanuj',22));
console.log(registerUser('Tanuja',17));
 
// arrays in ts
let numbers : number[] = [1,2,3,4,5,6];
let names: string[] = ["temp1","temp2", "temp3", "temp4"];
console.log(numbers);
console.log(numbers[0]);
 
// tuples in ts -> fixed length of diff data types..
let user :[string, number, boolean] = ["temp", 703417199, true];
console.log(user);
console.log(user[0]);
 
//Enums -> define a set of named constants
enum Status{
    Active,
    Inactive,
    Pending
}
 
let userStatus : Status = Status.Pending;
console.log(userStatus);
 
function checkOrderStatus(status:Status):string
{
    switch(status)
    {
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
let userStatus1:Status=Status.Pending;
 
console.log(checkOrderStatus(userStatus1));
 
// union , literals
//union types -> variable can hold multiple values..
let value : string | number ;
value=1234;
value="Hello";
 
 
function getInput(input : string|number) :string{
    return 'You entered : '+input;
}
 
console.log(getInput(1234));
console.log(getInput('Hello World'));
 
type userType = 'admin' | 'enduser' | 'backendengg' | 'frontendengg';
 
function getUserRole(user : userType):string{
    return 'Your role is : ' +user;
}
 
console.log(getUserRole('admin'));
 
//Functions with optional parameters..
// Arrow functions..
const multiply =(num1: number, num2, number)=>num1*num2;
console.log(multiply);
 
const usrName = (name1:string, name2: string)=>name1+' '+name2;
console.log(usrName("temp1","temp2"));
 
//Optional Parameter
function userDetails(name: string, age?: number,status?:boolean): string{
    return `Name: ${name}, Age: ${age}, Status: ${status}`;
}
 
console.log(userDetails("temp"));
console.log(userDetails("temp2",23));
console.log(userDetails("temp3",23,true));
 
//Default paramters..
function applyDiscount(price: number, discount: number =0.1): number
{
    return price - (price * discount);
}
 
console.log(applyDiscount(100));
console.log(applyDiscount(100,0.25));


class Person {
    // Private member variables
    private name: string;
    private age: number;
 
    // Constructor to initialize the member variables
    constructor(name: string, age: number) {
      this.name = name;
      this.age = age;
    }
 
    // Getter for the name property
    public getName(): string {
      return this.name;
    }
 
    // Setter for the name property
    public setName(name: string): void {
      this.name = name;
    }
 
    // Getter for the age property
    public getAge(): number {
      return this.age;
    }
 
    // Setter for the age property
    public setAge(age: number): void {
      if (age > 0) {
        this.age = age;
      } else {
        console.error("Age must be a positive number.");
      }
    }
  }
 
  // Example usage of the Person class
  const person1 = new Person("temp", 23);
  console.log(`Name: ${person1.getName()}, Age: ${person1.getAge()}`);
 
  person1.setName("temp 2");
  person1.setAge(25);
  console.log(`Updated Name: ${person1.getName()}, Updated Age: ${person1.getAge()}`);


  abstract class User {
    // Private member variables
    private userName: string;
    private userEmail: string;
    private userPassword: string;
 
    // Constructor to initialize the member variables
    constructor(userName: string, userEmail: string, userPassword: string) {
      this.userName = userName;
      this.userEmail = userEmail;
      this.userPassword = userPassword;
    }
 
    // Getter for userName
    public getUserName(): string {
      return this.userName;
    }
 
    // Setter for userName
    public setUserName(userName: string): void {
      this.userName = userName;
    }
 
    // Getter for userEmail
    public getUserEmail(): string {
      return this.userEmail;
    }
 
    // Setter for userEmail
    public setUserEmail(userEmail: string): void {
      this.userEmail = userEmail;
    }
 
    
    public getUserPassword(): string {
      return this.userPassword;
    }
 
    public setUserPassword(userPassword: string): void {
      this.userPassword = userPassword;
    }
 
   
    public getDetails(): string {
      return `Name: ${this.userName}, Email: ${this.userEmail}`;
    }
  }
 
  // Subclass AdminUser extending from User
  class AdminUser extends User {
    // Additional attribute for AdminUser
    private role: string;
 
    // Constructor to initialize the member variables and role
    constructor(userName: string, userEmail: string, userPassword: string, role: string) {
      super(userName, userEmail, userPassword);
      this.role = role;
    }
 
    // Getter for role
    public getRole(): string {
      return this.role;
    }
 
    // Setter for role
    public setRole(role: string): void {
      this.role = role;
    }
 
    // Method to delete a user (dummy implementation)
    public deleteUser(): void {
      console.log(`User ${this.getUserName()} has been deleted.`);
    }
  }
 
  // Subclass EndUser extending from User
  class EndUser extends User {
    // Additional attribute for EndUser
    private address: string;
 
    // Constructor to initialize the member variables and address
    constructor(userName: string, userEmail: string, userPassword: string, address: string) {
      super(userName, userEmail, userPassword);
      this.address = address;
    }
 
    // Getter for address
    public getAddress(): string {
      return this.address;
    }
 
    // Setter for address
    public setAddress(address: string): void {
      this.address = address;
    }
 
    // Method to view profile details
    public viewProfile(): string {
      return `Name: ${this.getUserName()}, Email: ${this.getUserEmail()}, Address: ${this.address}`;
    }
  }
 
  // Creating objects of AdminUser and EndUser
  const admin = new AdminUser("Alice", "alice@example.com", "admin123", "Administrator");
  console.log(admin.getDetails());
  admin.deleteUser();
 
  const endUser = new EndUser("Bob", "bob@example.com", "user123", "123 Main St");
  console.log(endUser.viewProfile());


  interface PersonInterface {
    name: string;
    age: number;
    getDetails(): string;
}
 
const personA: PersonInterface = {
    name: 'Tanuj',
    age: 22,
 
    getDetails(): string {
        return `Name: ${this.name}, Age: ${this.age}`;
    }
}
console.log(personA.getDetails());
interface EmployeeInterface extends PersonInterface {
    role : string;
    getRole() : string;
}
const emp1 : EmployeeInterface={
    name : "Tanuj",
    age : 22,
    role : "Developer",
    getDetails(): string {
        return `Name : ${this.name}, Age : ${this.role}`;
    },
    getRole() : string{
        return `Role : ${this.role}`;
    },
};
type PersonType ={
    name : string;
    age : number;
}
type personNew = PersonType & {role : string};
const person2 : personNew={
    name : "Tanuj",
    age : 22,
    role : "Developer"
}
console.log(person2);


// Generic function
function genFunction<T>(value: T): T {
    return value;
  }
   
  console.log(genFunction<number>(10));
  console.log(genFunction<string>("Generics"));
   
  // Generic interface
  interface GenInt<T> {
    content: T;
  }
   
  // Create objects
  const strGenInt: GenInt<string> = { content: "Typescript" };
  const numGenInt: GenInt<number> = { content: 100.90 };
   
  // Generic class
  class DataStorage<T> {
    private items: T[] = [];
   
    addItem(item: T): void {
      this.items.push(item);
    }
   
    removeItem(item: T): void {
      this.items = this.items.filter(i => i !== item);
    }
   
    getItems(): T[] {
      return [...this.items];
    }
  }
 
  const textStorage = new DataStorage<string>();
  textStorage.addItem('Tanuj');
  textStorage.addItem('Tanuja');
  textStorage.addItem('Tarun');
  console.log(textStorage.getItems());
  textStorage.removeItem("Tanuj");
  console.log(textStorage.getItems());
 
 
  const numberStorage = new DataStorage<number>();
  numberStorage.addItem(10);
  numberStorage.addItem(100);
  numberStorage.addItem(10);
  console.log(numberStorage.getItems());



