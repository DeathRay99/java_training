package Collections;
import java.util.*;

public class ComparingCategoryId implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
		// TODO Auto-generated method stub
		
		int categoryComparison=p1.category.compareTo(p2.category);
		
		if(categoryComparison==0) {
			return Integer.compare(p1.prodId, p2.prodId);
		}
		return categoryComparison;
	}


}
