public class MethodDeclaration{

	public static void main(String[] args){
	    //create a class instance
	    MethodDeclaration md = new MethodDeclaration();

	    //call your first method here
	    md.talk();
	    md.talk();
	    md.talk();
	}

    //create your first method here
    public void talk(){
        System.out.println("Inside of the talk method");
    }
}