package Collections;
import java.util.*;

public class ComparingNamePrice implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
		// TODO Auto-generated method stub
		
		int nameComparison=p1.prodName.compareTo(p2.prodName);
		
		if(nameComparison==0) {
			return Double.compare(p1.productPrice, p2.productPrice);
		}
		return nameComparison;
	}
	

}
