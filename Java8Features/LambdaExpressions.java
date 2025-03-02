package Java8Features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface Maths{
	int operate(int a,int b);
}

public class LambdaExpressions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Maths add=(a,b)->a+b;
		System.out.println(add.operate(89, 77));
		
		List<String>names=Arrays.asList("tem","oooo","kkkkll");
		List<String>names2=new ArrayList<>();
		List<Integer>numbers=List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer>evenNumbers=numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
		List<Integer>incNumbers=numbers.stream().map(n->n+10).collect(Collectors.toList());
		names2.add("Java");
		names2.add("Training");
		
		names.forEach(Product::test);
		
		int resultSum=numbers.stream().map(n->n*2).mapToInt(Integer::intValue).sum();
		
		names.sort((s1,s2)->s1.compareTo(s2));
		System.out.println(names);
		System.out.println(resultSum);
		System.out.println(incNumbers);
		System.out.println(evenNumbers);
		
		names2.forEach(name->System.out.println(name));
		

	}

}
