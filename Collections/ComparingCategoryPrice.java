package Collections;
import java.util.*;

public class ComparingCategoryPrice implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
		// TODO Auto-generated method stub
		
//		int categoryComparison=p2.category.compareTo(p1.category);
		
//		if(categoryComparison==0) {
			return Double.compare(p2.productPrice, p1.productPrice);
//		}
//		return categoryComparison;
	}


}
