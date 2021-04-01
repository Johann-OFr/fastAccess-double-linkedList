
public class IDLListTest {

	public static void main(String[] args) {
		IDLList<Integer> test1 = new IDLList<Integer>();
		IDLList<Double> test2 = new IDLList<Double>();
		
//		test2.add(72.7);
//		test2.add(0, 3.3);
//		System.out.println(test2);
//		System.out.println(test2.remove(3.3));
//		System.out.println(test2.remove(72.7));
		
		
//	//EMPTY TESTS
//		//test1.getHead();		
//		//test1.remove();
//		//test1.append(20);
//		
	//NON-EMPTY TESTS
		test1.add(0, 15);									//should add at head
		test1.add(1, 32);									//should add at index 1
		test1.add(1, 24);									//should shift index 1 up to index 2 and add at index 1
		test1.add(25);										//should add at head
		System.out.println(test1);
		test1.append(222);				//adds last element
		System.out.println(test1);
		System.out.println(test1.remove(24));
		System.out.println(test1);
		test1.removeAt(1);
		System.out.println(test1);
		test1.removeLast();
		System.out.println(test1);
		

	}

}
