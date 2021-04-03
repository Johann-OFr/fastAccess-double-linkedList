
public class IDLListTest {

	public static void main(String[] args) {
		IDLList<Integer> test1 = new IDLList<Integer>();
		IDLList<Double> test2 = new IDLList<Double>();
		IDLList<String> test3 = new IDLList<String>();		
		
		
		//add to head
		System.out.println("ADD ELEMENT AT HEAD");
		test1.add(11);
		test1.add(12);
		test1.add(13);
		System.out.println("Adding element of Integer type list: [ " + test1.toString() + "]");
		test2.add(10.3);
		test2.add(10.4);
		test2.add(10.5);
		System.out.println("Adding element of Double type list: [ " + test2.toString() + "]");
		test3.add("20");
		test3.add("21");
		test3.add("21");
		System.out.println("Adding element of String type list: [ " + test3.toString() + "]");
		
		//add element at an index
		System.out.println();
		System.out.println("ADD ELEMENT AT AN INDEX");
		test1.add(0, 50);
		System.out.println("After adding 50 to index 0, Integer type list becomes: [ " + test1.toString() + "]");
		test2.add(0, 20.6);
		System.out.println("After adding 20.6 to index 0, Double type list becomes: [ " + test2.toString() + "]");
		test3.add(0, "40");
		System.out.println("After adding 40 to index 0, String type list becomes: [ " + test3.toString() + "]");
		
		//add element b/w two nodes
		System.out.println();
		System.out.println("ADD ELEMENT B/W TWO NODES");
		test1.add(1, 100);
		System.out.println("After adding 100 to index 1, Integer type list becomes: [ " + test1.toString() + "]"); 
		test2.add(1, 40.9);
		System.out.println("After adding 40.9 to index 1, Double type list becomes: [ " + test2.toString() + "]");
		test3.add(1, "60");
		System.out.println("After adding 60 to index 1, String type list becomes: [ " + test3.toString() + "]");
		
		//append value to the end of list
		System.out.println();
		System.out.println("APPEND VALUE TO END OF LIST");
		test1.append(200);
		System.out.println("After appending 200 to Integer type list: [ " + test1.toString() + "]");
		test2.append(61.2);
		System.out.println("After appending 61.2 to Double type list: [ " + test2.toString() + "]");
		test3.append("80");
		System.out.println("After appending 80 to String type list: [ " + test3.toString() + "]");
		
		//get index from list
		System.out.println();
		System.out.println("ELEMENT IN AN INDEX");
		System.out.println("Getting the second index yields Integer type: " + test1.get(2));
		System.out.println("Getting the second index yields Double type: " + test2.get(2));
		System.out.println("Getting the second index yields String type: " + test3.get(2));
		
		//get head of the list
		System.out.println();
		System.out.println("GET HEAD OF LIST");
		System.out.println("Getting the head  yields Integer type: " + test1.getHead());
		System.out.println("Getting the head  yields Double type: " + test2.getHead());
		System.out.println("Getting the head  yields String type: " + test3.getHead());
		
		//get last of the list
		System.out.println();
		System.out.println("GET TAIL OF LIST");
		System.out.println("Getting the tail yields Integer type " + test1.getLast());
		System.out.println("Getting the tail yields Double type " + test2.getLast());
		System.out.println("Getting the tail yields String type " + test3.getLast());
		
		//removing the head
		System.out.println();
		System.out.println("REMOVE HEAD FROM LIST");
		test1.remove();
		System.out.println("Integer type List after removing head: [ " + test1.toString() + "]");
		test2.remove();
		System.out.println("Double type List after removing head: [ " + test2.toString() + "]");
		test3.remove();
		System.out.println("String type List after removing head: [ " + test3.toString() + "]");
		
		//return and remove the head
		System.out.println();
		System.out.println("RETURN AND REMOVE HEAD FROM LIST");
		System.out.println("Head value removed from the Integer list: " + test1.removeLast());
		System.out.println("Head value removed from the Double list: " + test2.removeLast());
		System.out.println("Head value removed from the String list: " + test3.removeLast());
		
		//Remove element at specific index
		System.out.println();
		System.out.println("REMOVE ELEMENT AT SPECIFIC INDEX");
		test1.removeAt(1);
		System.out.println("Removing index 1 yields the Integer list: " + test1.toString());
		test2.removeAt(1);
		System.out.println("Removing index 1 yields the Double list: " + test2.toString());
		test3.removeAt(1);
		System.out.println("Removing index 1 yields the String list: " + test3.toString());
		
		//Remove node if present. 
		System.out.println();
		System.out.println("REMOVE NODE IF PRESENT IN LIST");
		System.out.println("T/F: Is Node 100 present in Integer list? Remove if true: " + test1.remove(100));
		System.out.println("T/F: Is Node 300 present in Integer list? Remove if true: " + test1.remove(300));
		System.out.println("T/F: Is Node 10.4 present in Double list? Remove if true: " + test2.remove(10.4)); 		//FIXME - not removing double. cannot find 
		System.out.println("T/F: Is Node 1.1 present in Double list? Remove if true: " + test2.remove(1.1));
		System.out.println("T/F: Is Node 60 present in String list? Remove if true: " + test3.remove("60"));
		System.out.println("T/F: Is Node 5 present in Stromg list? Remove if true: " + test3.remove("5"));
		
		
		
		
		
		
		
	}

}
