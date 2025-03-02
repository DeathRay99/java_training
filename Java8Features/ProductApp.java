package Java8Features;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class ProductApp {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Product> products=List.of(
				new Product("Iphone", "electronics", 10000.00),
				new Product("Headphone", "electronics", 5000.00),
				new Product("Apple","Grocery",56.00),
				new Product("Cooker","kitchenware",1000.00)
				);
		
		List<Product>filteredProducts=products.stream().filter(product->product.getPrice()>5000.0&&product.getPrice()<=50000).collect(Collectors.toList());
		
		List<Product>sortedProducts=products.stream().sorted(Comparator.comparingDouble(Product::getPrice)).collect(Collectors.toList());
		
		List<String> upperCaseNames = products.stream()
                .map(product -> product.getName().toUpperCase())
                .collect(Collectors.toList());
		
		double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0);

        System.out.println("Average Price of Products: " + averagePrice);
		
		System.out.println(filteredProducts);
		sortedProducts.forEach(product->System.out.println(product));
		
//		System.out.println(Product::test);
				
				

	}

}
