package MGM;

import java.util.Random;
import org.junit.Test;

import MGM.MgmInterviewFoodSort.FOOD;




public class testMgmInterviewFoodSort
{
//-----------------------------------------
// Attributes
//-----------------------------------------
	public static final int	CST_ARRAY_SIZE	= 100;	


//-----------------------------------------
// Run tests
//-----------------------------------------
		@Test
		public void testRandom()
		{
//			assert(0 == 0);
//			fail("Not yet implemented");

			buildTest_random();
			MgmInterviewFoodSort mifs = new MgmInterviewFoodSort();
			mifs.main();
			assert(isSorted());
		}


		@Test
		public void testSimple()
		{
			buildTest_random();
			MgmInterviewFoodSort mifs = new MgmInterviewFoodSort();
			mifs.main();
			assert(isSorted());
		}


//-----------------------------------------
// Build test cases
//-----------------------------------------
	private void buildTest_random()
	{
		MgmInterviewFoodSort		res	= new MgmInterviewFoodSort();
		Random						rnd	= new Random(0);

		MgmInterviewFoodSort.potatoes = new FOOD[21];
		for (int i=0; i<CST_ARRAY_SIZE; i++)
		{
			int size = rnd.nextInt();
			if (rnd.nextBoolean() == true)
			{
				MgmInterviewFoodSort.potatoes[i] = res.new Potato();
//TODO add size
MgmInterviewFoodSort.potatoes[i].size = size;
			}
			else
			{
				MgmInterviewFoodSort.potatoes[i] = res.new Potato();
//TODO add size
MgmInterviewFoodSort.potatoes[i].size = size;
			}
		}
	}


//-----------------------------------------
// Auxiliary
//-----------------------------------------
	public boolean isSorted()
	{
		for (int i=1; i<MgmInterviewFoodSort.potatoes.length; i++)
		{
			if (MgmInterviewFoodSort.potatoes[i-1].size > MgmInterviewFoodSort.potatoes[i].size)
			{
				return false;
			}
		}

		return true;
	}
}
