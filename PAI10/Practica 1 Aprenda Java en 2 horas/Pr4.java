class Pr4 {
	public static void main (String args []) {
		int k , size = args.length;
		Integer a[] = new Integer [2];
		for (k = 0 ; k < size ; ++k) {
			a[k]= new Integer (args [k]) ;
			System.out.println("a [" + k + "]= " + a[k]);
		}
	}
}
