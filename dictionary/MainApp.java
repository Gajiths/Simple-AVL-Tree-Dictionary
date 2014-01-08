package dictionary;


import java.util.Scanner;

public class MainApp {
	
	public static void main(String args[]){
		
		Scanner dictionary=new Scanner(System.in);
		
		AvlTree dictionaryTree=new AvlTree();
		
		dictionaryTree.insert("Cat","Pusa");
		dictionaryTree.insert("Dag","Balla");
		dictionaryTree.insert("Man","Miniha");
		dictionaryTree.insert("Donky","Buuruwa");
		dictionaryTree.insert("parrot","Girawa");
		dictionaryTree.insert("Pig","Uuuraa");
		dictionaryTree.insert("Frog","Gemba");
		while(true){
			
			System.out.println("=============GAJITH  DICTIONARY===============");
			System.out.println("=============Option(1)- ADD A WORD============");
			System.out.println("=============Option(2)-SEARCH A WORD==========");
			System.out.println("=============Option(3)-EXIT==========");
			
			System.out.println("SELECT THE OPTION :");
			int option=dictionary.nextInt();
			
			if(option==1){
				System.out.println("=============ADD A WORD=======");
				System.out.println("--ADD A Key--");
				String key=dictionary.next();
				System.out.println("--ADD A Discription--");
				String discription=dictionary.next();
				dictionaryTree.insert(key,discription);
				
			}else if(option==2){
				System.out.println("=============SEARCH A WORD==========");
				String searchString=dictionary.next();
				String find=(String) dictionaryTree.find(searchString);
				if(find!=null){
					System.out.println(find);
				}else{
					System.out.println("The word is not  found");
				}
			}else if(option==3){
				
				System.exit(0);
			}
			
		}
	}
}
