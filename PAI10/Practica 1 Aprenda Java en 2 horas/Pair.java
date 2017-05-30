public class Pair { 

	int first, second;
	Pair (){
		first = 0;
		second = 0;
	}

	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}

	public void swap (Pair p2) {
		Pair temp = p2;
		p2 = this;
		this.first = temp.first ;
		this.second = temp.second ;
	}
	public void reflex () {
		int z = first; first = second; second = z;
	}
	
	public String toString (){
		return new String("("+first+", "+second+")");
	}

	public boolean equals (Pair par2){
		return (par2.first == first & par2.second == second);	
	}
}
