package MGM;

import java.util.Random;
import org.junit.Test;

import MGM.MgmInterviewFoodSort.FOOD;




public class testMgmInterviewFoodSort
{
//-----------------------------------------
// Attributes
//-----------------------------------------
	public static final int		CST_ARRAY_SIZE			= 10;	
	public static final int		CST_ARRAY_SIZE_LARGE	= 10000;	
	public static final int		CST_MAX_VALUE			= 1000;	
	public static final Random	rnd						= new Random();


//-----------------------------------------
// Run tests (Insertion Sort)
//-----------------------------------------
	@Test
	public void testInsertionSort_random()
	{
		System.out.println("\n\nTest: Ramdom array + insertion sort");

		MgmInterviewFoodSort mifs = buildTest_random(CST_ARRAY_SIZE);
		FOOD[] sortedFood	= mifs.sortFoodInsertion();
		MgmInterviewFoodSort.printFood(sortedFood);
		assert(isSorted(sortedFood));
	}


	@Test
	public void testInsertionSort_zeros()
	{
		System.out.println("\n\nTest: zero size array + insertion sort");

		MgmInterviewFoodSort mifs = buildTest_zero();
		FOOD[] sortedFood	= mifs.sortFoodInsertion();
		MgmInterviewFoodSort.printFood(sortedFood);
		assert(isSorted(sortedFood));
	}


	@Test
	public void testInsertionSort_simple()
	{
		System.out.println("\n\nTest: Simple array + insertion sort");

		MgmInterviewFoodSort mifs = buildTest_simple();
		FOOD[] sortedFood	= mifs.sortFoodInsertion();
		MgmInterviewFoodSort.printFood(sortedFood);
		assert(isSorted(sortedFood));
	}


	@Test
	public void testInsertionSort_largeArray()
	{
		System.out.println("\n\nTest: Random large " + CST_ARRAY_SIZE_LARGE + "array + insertion sort");

		MgmInterviewFoodSort mifs = buildTest_random(CST_ARRAY_SIZE_LARGE);
		FOOD[] sortedFood	= mifs.sortFoodInsertion();
		assert(isSorted(sortedFood));
	}


//-----------------------------------------
// Run tests (Quick Sort)
//-----------------------------------------
	@Test
	public void testQuickSort_random()
	{
		System.out.println("\n\nTest: Ramdom array + insertion sort");

		MgmInterviewFoodSort mifs = buildTest_random(CST_ARRAY_SIZE);
		FOOD[] sortedFood	= mifs.sortFoodInsertion();
		MgmInterviewFoodSort.printFood(sortedFood);
		assert(isSorted(sortedFood));
	}


	@Test
	public void testQuickSort_zeros()
	{
		System.out.println("\n\nTest: zero size array + insertion sort");

		MgmInterviewFoodSort mifs = buildTest_zero();
		FOOD[] sortedFood	= mifs.sortFoodInsertion();
		MgmInterviewFoodSort.printFood(sortedFood);
		assert(isSorted(sortedFood));
	}


	@Test
	public void testQuickSort_simple()
	{
		System.out.println("\n\nTest: Simple array + insertion sort");

		MgmInterviewFoodSort mifs = buildTest_simple();
		FOOD[] sortedFood	= mifs.sortFoodInsertion();
		MgmInterviewFoodSort.printFood(sortedFood);
		assert(isSorted(sortedFood));
	}


	@Test
	public void testQuickSort_largeArray()
	{
		System.out.println("\n\nTest: Random large " + CST_ARRAY_SIZE_LARGE + "array + insertion sort");

		MgmInterviewFoodSort mifs = buildTest_random(CST_ARRAY_SIZE_LARGE);
		FOOD[] sortedFood	= mifs.sortFoodInsertion();
		assert(isSorted(sortedFood));
	}


//-----------------------------------------
// Build test cases
//-----------------------------------------
	private MgmInterviewFoodSort buildTest_random(int arraySize)
	{
		MgmInterviewFoodSort res = new MgmInterviewFoodSort();

		res.foodArray = new FOOD[arraySize];
		for (int i=0; i<arraySize; i++)
		{
			int size = (rnd.nextInt() % CST_MAX_VALUE);
			if (rnd.nextBoolean() == true)
			{
				res.foodArray[i] = res.new Potato(size);
			}
			else
			{
				if (rnd.nextBoolean() == true)
				{
					res.foodArray[i] = res.new Tomato(size);
				}
				else
				{
					res.foodArray[i] = res.new Tomato();
				}
			}
		}

		return res;
	}


	private MgmInterviewFoodSort buildTest_zero()
	{
		MgmInterviewFoodSort res = new MgmInterviewFoodSort();

		res.foodArray = new FOOD[0];
		return res;
	}


	private MgmInterviewFoodSort buildTest_simple()
	{
		MgmInterviewFoodSort res = new MgmInterviewFoodSort();

		res.foodArray = new FOOD[10];
		res.foodArray[0] = res.new Tomato(11);
		res.foodArray[1] = res.new Tomato();

		res.foodArray[2] = res.new Potato(1);
		res.foodArray[3] = res.new Potato(42);
		res.foodArray[4] = res.new Potato(77);
		res.foodArray[5] = res.new Potato(55);
		res.foodArray[6] = res.new Potato(46);
		res.foodArray[7] = res.new Potato(12);
		res.foodArray[8] = res.new Potato(11);
		res.foodArray[9] = res.new Potato(9);
		return res;
	}


//-----------------------------------------
// Auxiliary
//-----------------------------------------
	public boolean isSorted(FOOD[] foodArray)
	{
		for (int i=1; i<foodArray.length; i++)
		{
			if (foodArray[i-1].getSize() > foodArray[i].getSize())
			{
				return false;
			}
		}

		return true;
	}
}
