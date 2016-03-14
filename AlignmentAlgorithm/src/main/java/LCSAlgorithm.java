
public class LCSAlgorithm {
	
	//int[][]M;		// substitution matrix;
	int[][]F;		// dynamic programming matrix
	int n;			// length of Text
	int m;		 	// length of Pattern
	
	LCSAlgorithm(String T, String P){
		n = T.length();
		m = P.length();
		System.out.println("n is "+ n);
		System.out.println("m is "+ m);
		//M = new int[4][4];		// we have 4 by 4 matrix with 4 base pairs.
		F = new int[n+1][m+1];	// substitution matrix
		
		
		for (int i = 0; i <= n; i++){	// inserting 0 in 1st row 
			F[i][0] = 0;
		}
		
		for (int j = 0; j <= m; j++){	// inserting 0 in 1st column
			F[0][j] = 0;
		}
		int ii = 1, jj = 1;
		int total;
		int up,left,diagonal;	
		while( ii<= n && jj <= m){
			System.out.println(jj+"   " + ii);

				up = F[ii][jj-1];
				left = F[ii-1][jj];
				if(T.charAt(ii-1)==P.charAt(jj-1)){
					diagonal = F[ii-1][jj-1]+1;	// humming
				}else{
					diagonal = F[ii-1][jj-1];
				}

				F[ii][jj] = max(up,left,diagonal);
				if(jj==1 || ii == n){
					total = ii + jj + 1;
					jj = ii+1 <= m ? ii+1: m;
					ii = total - jj;

				}else{
					
					jj --;
					ii ++;
				}
				
				
		}
		
		
	}
	

	void display( ){
		for(int j=0;j<=m ; j++){
			for (int i = 0; i<= n; i++){
				System.out.print(F[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
			
	}
	
	int max(int a, int b, int c){
		if(a >= b && a >= c){
			return a;
		}else if(b >= c){
			return b;
		}else{
			return c;
		}
	}
}
