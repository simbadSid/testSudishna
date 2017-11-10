package MGM;

import MGM.MgmInterviewFoodSort.FOOD;




public class Utility {

	public static void quickSortAlgo(FOOD[] sortedFood, int firstIndex, int lastIndex) {

		if (firstIndex >= lastIndex)
			return;
		
		int i = pivotIndex(sortedFood, firstIndex,lastIndex);
		swapValues(sortedFood, firstIndex, i - 1);
		quickSortAlgo(sortedFood, firstIndex, i - 1);
		quickSortAlgo(sortedFood, i, lastIndex);

	}

	private static int pivotIndex(FOOD[] sortedFood, int firstIndex, int lastIndex){
		int pivot = sortedFood[firstIndex].getSize();
		int i = firstIndex;
		int j = lastIndex;

		while (i < j) {
			i++;

			// to compare left side
			while (sortedFood[i].getSize() < pivot && i < j) {
				i++;
			}

			// to compare right side
			while (sortedFood[j].getSize() > pivot && j > i) {
				j--;
			}

			// swap values
			if (sortedFood[i].getSize() >= sortedFood[j].getSize()) {
				swapValues(sortedFood, i, j);
			}
		}

		return i;
	}
	
	
	private static void swapValues(FOOD[] sortedFood, int i, int j) {
		FOOD temp = sortedFood[i];
		sortedFood[i] = sortedFood[j];
		sortedFood[j] = temp;
	}
		

}