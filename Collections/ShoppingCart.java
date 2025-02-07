package Collections;

import java.util.*;
public class ShoppingCart {
	
	
//	private ArrayList<Product> cart= new ArrayList<>();
//	private LinkedList<Product> cart= new LinkedList<>();
//	private HashSet<Product> cart= new HashSet<>();
//	private TreeSet<Product> cart= new TreeSet<>(new ComparingCategoryPrice());
	private Scanner scanner=new Scanner(System.in);
	
	public void addProduct(Map<Integer,Product> cart) {
		System.out.println("Enter product Id: ");
		int id=scanner.nextInt();
		System.out.println("Enter product Name: ");
		String name=scanner.next();
		System.out.println("Enter product price: ");
		double price = scanner.nextDouble();
		System.out.println("Enter product category: ");
		String category = scanner.next();
		
//		if(cart.add(new Product(id,name,price,category)))
		cart.put(id, new Product(id,name,price,category));
		System.out.println("Product : "+name+" added to cart");
//		else
//			System.out.println("Same product cant be added again ");
	}
	
	public void removeProduct(Map<Integer,Product> cart) {
		System.out.println("Enter product Id to remove product: ");
		int id = scanner.nextInt();
		
//		boolean removed = cart.removeIf(product->product.prodId==id);
		Product removed=cart.remove(id);
		if(removed!=null) {
			System.out.println("Product with id: "+id+" removed from cart");
			
		}
		else {
			System.out.println("Product with Id : "+id+" not found");
		}
	}
	
	public void searchProduct(Map<Integer,Product> cart) {
		System.out.println("Enter product name to search product: ");
		String name = scanner.next();
		
		for(Product product:cart.values()) {
			if(product.prodName.equalsIgnoreCase(name)) {
				System.out.println("Product :"+name+" found.");
				return;
			}
		}
			System.out.println("Product : "+name+" not found");
	}
	
	public double discount(Product p) {
		if(p.category.equalsIgnoreCase("electronics"))
			return p.productPrice*0.1;
		if(p.category.equalsIgnoreCase("grocery"))
			return p.productPrice*0.02;
		if(p.category.equalsIgnoreCase("apparel"))
			return p.productPrice*0.05;
		if(p.category.equalsIgnoreCase("footwear"))
			return p.productPrice*0.15;
		
		return 0;
	}
	
	public void checkOut(Map<Integer,Product> cart) {
		double totalBill=0;
		double totalDiscount=0;
		
		for(Product product:cart.values()) {
			double discount=discount(product);
			totalDiscount+=discount;
			totalBill+=(product.productPrice-discount);
		}
//		while(!cart.isEmpty()) {
//			Product prod=cart.poll();
////			((ArrayDeque) cart).removeFirst();
//			double discount=discount(prod);
//			totalDiscount+=discount;
//			totalBill+=(prod.productPrice-discount);
//			
//		}
		System.out.println("Total price to be paid : INR "+ totalBill);
		System.out.println("Total discount availed : INR "+ totalDiscount);
		cart.clear();
		System.out.println("Checkout Complete. Cart is empty. ");
		
	}
	
	public void display(Map<Integer,Product> cart) {
		if(cart.isEmpty()) {
			System.out.println("No products in cart. ");
			
		}
		else {
			for(Product product:cart.values()) {
				System.out.println(product.toString());
			}
		}
	}
	
	public void menu(Map<Integer,Product> cart) {
		while(true) {
			 System.out.println("Employee Management Application");
	            System.out.println("Press 1 : To add a Product ");
	            System.out.println("Press 2 : To remove product ");
	            System.out.println("Press 3 : To search product ");
	            System.out.println("Press 4 : To checkout");
	            System.out.println("Press 5 : to Display all products ");
	            
	            int choice = scanner.nextInt();
	            
	            switch (choice) {
                case 1:
                    addProduct(cart);
                    break;
                case 2:
                	searchProduct(cart);
                    break;
                case 3:
                	removeProduct(cart);
                    break;
                case 4:
                    checkOut(cart);
                    break;
                case 5:
                    display(cart);
                    break;
   
                default:
                    System.out.println("Thank you, exiting from system");
//                    scanner.close();
                    return;
	            }
			
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Queue<Product> cart2=new PriorityQueue<>(new ComparingCategoryPrice());
//		Queue<Product> cart2=new ArrayDeque<>();
		Map<Integer,Product>cart1=new HashMap<>();
		Map<Integer,Product>cart2=new LinkedHashMap<>();
		Map<Integer,Product>cart3=new TreeMap<>();
		
		
//		Scanner scanner=new Scanner(System.in);
//		
		 ShoppingCart cart=new ShoppingCart();
//		 System.out.println("How you want to sort the products? ... ");
//		 System.out.println("Press 1 : for categoryPrice ");
//         System.out.println("Press 2 : To namePrice ");
//         System.out.println("Press 3 : To categoryId ");
//         
//         int choice = scanner.nextInt();
//         
//         switch (choice) {
//         case 1:
//        	 cart2= new TreeSet<>(new ComparingCategoryPrice());
//             break;
//         case 2:
//        	 cart2= new TreeSet<>(new ComparingNamePrice());
//             break;
//         case 3:
//        	 cart2= new TreeSet<>(new ComparingCategoryId());
//             break;
//          default:
//        	  cart2=new TreeSet<>(new ComparingCategoryPrice());
//         }
		
		cart.menu(cart1);
		System.out.println("------------------------------------------------- ");
		cart.menu(cart2);
		System.out.println("------------------------------------------------- ");
		cart.menu(cart3);
		
		
		
	}

}






