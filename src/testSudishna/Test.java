package testSudishna;

import java.util.LinkedList;

public class Test
{
	public static int N = 100;

	public static void primNumbers()
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i=2; i<=N; i++)
		{
			list.add(i);
		}

		System.out.println("Prime number list untill " + N + ": ");
		int i = 0;
		while (i < list.size())
		{
			int e0= list.get(i);
			System.out.println("\t" + e0);
			int j = i+1;
			while (j < list.size())
			{
				int e1= list.get(j);
				if ((e1 % e0) == 0)
				{
					list.remove(j);
				}
				else
				{
					j ++;
				}
			}
			i++;
		}
	}

	public static void main(String[] args)
	{
		primNumbers();

	}

}
