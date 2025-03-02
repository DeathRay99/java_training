package Collections;

import java.util.Objects;

public class Product {
	
	int prodId;
	String prodName;
	double productPrice;
	String category;
	
	public Product(int prodId, String prodName, double productPrice, String category) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.productPrice = productPrice;
		this.category=category;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", productPrice=" + productPrice + ", category="
				+ category + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(prodId, prodName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return prodId == other.prodId && Objects.equals(prodName, other.prodName);
	}

	

//	@Override
//	public int compareTo(Product other) {
//		// TODO Auto-generated method stub
//		return Double.compare(productPrice, other.productPrice);
//	}
//	@Override
//	public int compareTo(Product other) {
//	    return this.prodName.compareTo(other.prodName);
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Product other = (Product) obj;
//		return ((prodId==other.prodId)&&(prodName==other.prodName));
//	}
	
	

	
	
	

}
