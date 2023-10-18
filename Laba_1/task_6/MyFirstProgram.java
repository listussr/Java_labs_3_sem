import myfirstpackage.*;

class FirstClass {
	public static void main(String[] s){
		SecondClass o = new SecondClass(1, 2);
		int i, j;
		for(i = 0; i <= 8; ++i){
			for(j = 0; j <= 8; ++j){
				o.setI(i);
				o.setJ(j);
				System.out.println(o.sum());
				System.out.println(" ");
			}
			System.out.println();
		}
	}
}

