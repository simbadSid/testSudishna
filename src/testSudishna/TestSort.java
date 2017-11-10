package testSudishna;

import java.util.List;




public class TestSort
{
	public static void swap(List<String> result, int begin, int end)
	{
		String strBegin	= result.get(begin);
		String strEnd	= result.get(end);

		result.set(begin,	strEnd);
		result.set(end,		strBegin);
	}



	public static void sort(List<String> result, int begin, int end)
	{
		if (begin == end)
		{
			return;
		}
		if (end == begin+1)
		{
			if (result.get(begin).compareTo(result.get(end)) > 0)
			{
				swap(result, begin, end);
			}
			return;
		}

		String pivot = result.get(begin);
		int ib = begin +1;
		int ie = end;

		while(true)
		{
			while((ib < ie) && (pivot.compareTo(result.get(ib)) >= 0))
				ib ++;
			while((ib < ie) && (pivot.compareTo(result.get(ie)) < 0))
				ie --;
			if (ib == ie)
				break;
			swap(result, ib, ie);
		}
		sort(result, begin, ib-1);
		sort(result, ie, end);
	}


	public static void sort_the_files(int n, List<String> result)
	{
		sort(result, 0, n-1);
	}

}

