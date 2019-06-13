package thread;

public class Student {
	public static void main(String[] args) {
		stud1 s = new stud1(10);
		stud1 s1 = new stud1(35);
		change(s);
		System.out.println(s.sid);
	}
	static void change(stud1 stud) {
		stud.sid = stud.sid+10;
		
	}
	
	
	

}

class stud1{
	static int sid;
	stud1(int sid){
		this.sid=sid;
	}
}
