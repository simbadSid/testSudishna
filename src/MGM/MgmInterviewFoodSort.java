package mgmInteview;

import java.util.Arrays;



//Your task is to:
//- fix the code
//- improve the poor quality of this code.
//
//(You can change anything you want
//
//The class should sort food instances and output the following lines:
//
//Potato 1
//Potato 9
//Potato 11
//Tomato 11
//Potato 12
//Potato 42
//Potato 46
//Potato 55
//Potato 77
//Tomato 121
//

public class MgmInterviewFoodSort {

	/**
	 * Original code: public FOOD[] potatoes = null;
	 * 
	 * Comment: 
	 * 			- Changing the variable	name to "foodArray" as we are pushing both Potato and Tomato objects in this array.
	 */
	public FOOD[] foodArray = null;

	/**
	 * Added
	 * 
	 * Comment: 
	 * 			- Parameterized all the constant values that are used in the code (to ease the evolution of the code)
	 */
	public static final int DEFAULT_FOOD_SIZE	= -1;
	public static final int DEFAULT_TOMATO_SIZE	= 121;

	public abstract class FOOD {

		public int size = DEFAULT_FOOD_SIZE;

		/**
		 * Added
		 * 
		 * Comment: 
		 * 			- This builder is used by all the sub classes: all of them instantiate and use the attribute size.
		 */
		public FOOD(int size) {
			this.size = size;
		}

		public String whoAMI() {
			return this.getClass().getName().substring(MgmInterviewFoodSort.class.getName().length() + 1);
		}

		/**
		 * Added
		 * 
		 * Comment: 
		 * 			- The value of size is used during the sort. We thus have added this getter to ease the evolution of the code: if the size is computed differently,
		 * 			 we don't want to change all the part of the code that access it. We simply update this function.
		 */
		public int getSize() {
			return this.size;
		}
	}

	public class Potato extends FOOD {
		/**
		 * Added
		 * 
		 * Comment: 
		 * 			- The size attribute is always set after the class instanciation. Thus we merge it into the builder.
		 */
		public Potato(int size) {
			super(size);
		}
	}

	public class Tomato extends FOOD {
		/**
		 * Original code: public int size = 121;
		 * 
		 * Comment: 
		 * 			- The previous code declares same variable "size" in the "Tomato" which is already present in the "FOOD". The problem is that during sorting,
		 * 			 the Food instance's size is used instead of Tomato. Using super keyword helps to refer to Food's size attribute. 
		 * 			- The size attribute is always set after the class instantiation. Thus we merge it into the builder. 
		 * 			- We have created two builder definition as there are two use cases. 
		 * 			- We have replaced the previous hard-coded value by a constant (to ease the evolution of the code).
		 */
		public Tomato() {
			super(DEFAULT_TOMATO_SIZE);
		}

		public Tomato(int size) {
			super(size);
		}
	}

	/**
	 * Original code: public void main()
	 * 
	 * Comment:
	 * 			 - The name of the function was misleading. We thus have replaced it by a name that hints about the interest of the function 
	 * 			 - The function has been split into two functions (sort and print) according to their respective duties. 
	 * 			 - The sort function returns the sorted FOOD array.
	 */
	public FOOD[] sortFoodInsertion() {
		/**
		 * Added
		 * 
		 * Comment: 
		 * 			- Using arraySize variable, we prevent from future evolution of the input array
		 * 
		 */
		int arraySize = foodArray.length;
		final FOOD[] SORTEDFOOD = new FOOD[arraySize];

		for (int i = 0; i < arraySize; i++) {
			/**
			 * Original code: final int index_of_the_smaller_food = i;
			 * 
			 * Comment: 
			 * 			- "final" keyword before a variable means the value of the variable can not be changed. Thus, it will be constant. 
			 * 			But the value of "index_of_the_smaller_food" changes based on if condition
			 */
			int index_of_the_smaller_food = i;

			for (int j = i; j < arraySize; j++) {
				if (foodArray[index_of_the_smaller_food].getSize() > foodArray[j].getSize()) {
					index_of_the_smaller_food = j;
				}
				if (foodArray[index_of_the_smaller_food].getSize() == foodArray[j].getSize()
						&& foodArray[index_of_the_smaller_food].whoAMI().contains("Tomato")) {
					index_of_the_smaller_food = j;
				}
			}

			SORTEDFOOD[i] = foodArray[index_of_the_smaller_food];
			foodArray[index_of_the_smaller_food] = foodArray[i];
		}

		return SORTEDFOOD;
	}
	
	/**
	 * Added
	 * 
	 * Comment:
	 * 		- Quick sort sorting algorithm added
	 */
	public FOOD[] sortFoodQuick() {
		int arraySize = foodArray.length;
		FOOD[] SORTEDFOOD = new FOOD[arraySize];

		for (int i = 0; i < arraySize; i++)
			SORTEDFOOD[i] = foodArray[i];
		
		Utility.quickSortAlgo(SORTEDFOOD, 0, arraySize - 1);

		return SORTEDFOOD;
	}

	/**
	 * Added
	 * 
	 * Comment: 
	 * 			- This function prints the array for the result
	 */
	public static void printFood(FOOD[] inArry) {
		for (final FOOD potato : Arrays.asList(inArry)) {
			System.out.println(potato.whoAMI() + " " + potato.size);
		}
	}

	public static void main(final String[] args) {
		MgmInterviewFoodSort fs = new MgmInterviewFoodSort();
		
		/**
		 * Original code: potatoes = new FOOD[10];
		 * 
		 * Comment:
		 * 			- foodArray is the attribute of the class MgmInterviewFoodSort. Thus it can not be accessed statically. 
		 * 			The correction we did allows to access the attribute that belongs of this object.
		 */
		
		fs.foodArray = new FOOD[10];

		fs.foodArray[0] = fs.new Tomato(11);
		fs.foodArray[1] = fs.new Tomato();

		fs.foodArray[2] = fs.new Potato(1);
		fs.foodArray[3] = fs.new Potato(42);
		fs.foodArray[4] = fs.new Potato(77);
		fs.foodArray[5] = fs.new Potato(55);
		fs.foodArray[6] = fs.new Potato(46);
		fs.foodArray[7] = fs.new Potato(12);
		fs.foodArray[8] = fs.new Potato(11);
		fs.foodArray[9] = fs.new Potato(9);

		// fs.main();

		// FOOD[] sortArry = fs.sortFoodInsertion();
		FOOD[] sortArry = fs.sortFoodQuick();
		printFood(sortArry);
	}
}
