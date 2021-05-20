public class test {
	public static void main(String[] args) {
		linkedList<String> tree = new linkedList<String>();
		
		tree.insert("0",null);	
    
            tree.insert("00",tree.SearchFor("0"));   

                tree.insert("000",tree.SearchFor("00"));

                tree.insert("001",tree.SearchFor("00"));

            tree.insert("01",tree.SearchFor("0")); 

                tree.insert("010",tree.SearchFor("01"));

            tree.insert("02",tree.SearchFor("0"));

                tree.insert("020",tree.SearchFor("02"));
		
        /* if parent Node not added but not found then the node will be added to the 
        same height as the previously added node but wont be connected to the linkedlist*/
		tree.insert("999",tree.SearchFor("j5"));
		/* if null then since the linkedlist is not empty the code will give an error*/
		tree.insert("998",null);
		
        tree.output();
  }
}
