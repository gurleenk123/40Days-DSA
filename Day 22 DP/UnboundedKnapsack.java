public class UnboundedKnapsack {

	public static void main(String[] args) 
	{
		int val[] = { 60, 100, 120 };  
	    int wt[] = { 10, 20, 30 };  
	     
	    int W = 50; 
	    int N = val.length; 
	    
	    System.out.println(knapsackdp(wt,val,W,N));

	}

	public static int knapsackdp(int[] wt, int[] val, int w, int n)
	{
		int[][] dp=new int[n+1][w+1];
		
		//initiazation
		for(int i=0;i<n+1;i++)
			for(int j=0;j<w+1;j++)
				if(i==0 || j==0)
					dp[i][j]=0;
		
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<w+1;j++)
			{
				if(wt[i-1] <= j)
				{
					dp[i][j]=Math.max(val[i-1] + dp[i][j - wt[i-1] ], dp[i-1][j]);
				}
				else
					dp[i][j]=dp[i-1][j];
			}
		
			
		}
		return dp[n][w];
	}

}
