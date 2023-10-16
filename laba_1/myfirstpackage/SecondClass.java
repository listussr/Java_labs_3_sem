package myfirstpackage;
public class SecondClass {
	private int i = 0, j = 0;
	
	public SecondClass(){}
	
	public SecondClass(int first, int second){
		this.i = first;
		this.j = second;
	}
	
	public int getI(){
		return this.i;
	}
	public int getJ(){
		return this.j;
	}
	public void setI(int val) {
		this.i = val;
	}
	public void setJ(int val) {
		this.j = val;
	}
	
	public int sum(){
		return this.i + this.j;
	}
}