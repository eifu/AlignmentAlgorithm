
public class LCSAlgorithm {
	
	char[][]B;		// substitution matrix;
	int[][]F;		// dynamic programming matrix
	int n;			// length of Text
	int m;		 	// length of Pattern
	String T;
	String P;
	
	LCSAlgorithm(String T, String P){
		this.T = T;
		this.P = P;
		n = T.length();
		m = P.length();
		F = new int[n+1][m+1];	// substitution matrix
		B = new char[n+1][m+1];
		
		for (int i = 0; i <= n; i++){	// inserting 0 in 1st row 
			F[i][0] = 0;
			B[i][0] = 'O';
		}
		
		for (int j = 0; j <= m; j++){	// inserting 0 in 1st column
			F[0][j] = 0;
			B[0][j] = 'O';
		}
		int ii = 1, jj = 1;
		int total;
		int up,left,diagonal;	
		while( ii<= n && jj <= m){
				up = F[ii][jj-1];
				left = F[ii-1][jj];
				if(T.charAt(ii-1)==P.charAt(jj-1)){
					diagonal = F[ii-1][jj-1]+1;	// humming distance	
				}else{
					diagonal = F[ii-1][jj-1];
				}
				
				if(up >= left && up >= diagonal){
					F[ii][jj] = up;
					B[ii][jj] = 'u';
				}else if(left >= diagonal){
					F[ii][jj] = left;
					B[ii][jj] = 'l';
				}else{
					F[ii][jj] = diagonal;
					B[ii][jj] = 'd';
				}
				if(jj==1 || ii == n){		//diagonally iterating the matrix
					total = ii + jj + 1;
					jj = ii+1 <= m ? ii+1: m;
					ii = total - jj;

				}else{			
					jj --;
					ii ++;
				}				
		}		
	}
	void printLCS(){
		printLCShelper(B,P,n,m);
	}
	
	void printLCShelper(char[][] B, String P, int i, int j){
		if(i==0 || j ==0){
			while(i>0){
				System.out.print("-");
				i--;
			}
			return;
		}
		if(B[i][j] == 'd'){
			printLCShelper(B,P,i-1,j-1);
			System.out.print(P.charAt(j-1));
			
		}else{
			if(B[i][j] == 'u'){
				printLCShelper(B,P,i,j-1);
			}else{
				printLCShelper(B,P,i-1,j);
				System.out.print("-");
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
		
		for(int j=0;j<=m ; j++){
			for (int i = 0; i<= n; i++){
				System.out.print(B[i][j]);
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
