////////////
//[packages]
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
//[/packages]
/////////////
//////////////
//[class Node]
class Node{
    private String kind;
    private String value;
    private String op1;
    private String op2;
    private String op3;

    public Node() {
        
    }

    /**
     * @return the kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * @param kind the kind to set
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the op1
     */
    public String getOp1() {
        return op1;
    }

    /**
     * @param op1 the op1 to set
     */
    public void setOp1(String op1) {
        this.op1 = op1;
    }

    /**
     * @return the op2
     */
    public String getOp2() {
        return op2;
    }

    /**
     * @param op2 the op2 to set
     */
    public void setOp2(String op2) {
        this.op2 = op2;
    }

    /**
     * @return the op3
     */
    public String getOp3() {
        return op3;
    }

    /**
     * @param op3 the op3 to set
     */
    public void setOp3(String op3) {
        this.op3 = op3;
    }
    
    
}
//[/class Node]
///////////////
////////////////
//[class Rider]
class Rider2{
int ncol;
int nline;
int ntok;
String sym;

RegExp re;


    public Rider2() {
        ncol=0;
        nline=1;
        ntok=0;
        
        re=new RegExp();
        
    }
  public  void error(String msg) {
	     System.out.println("!Syntax Parse error");
	System.out.printf("Error at (%d: %d): %s\n", nline, ntok, msg);
  }
  
    public void readSymbolAndRecogniseIt(String lispExpression){
        
 char charRead='\0';         
  


for (int i=0;i<lispExpression.length();i++){
charRead = lispExpression.charAt(i);
++ncol;
if((char)charRead=='\n'){
 ncol=0;
 ++nline;
}
/* Запомним позицию текущей лексемы */
	ntok = ncol;
        // <принадлежит к Числу,Дабл >
if(re.test(String.valueOf(charRead),"^\\d+$") ||re.test(String.valueOf(charRead),"^\\d+\\.\\d+$")){
    //...
}
//<принадлежит  к Индификатору >
else if(re.test(String.valueOf(charRead),"[a-z]") ){
    //...
}
else if(charRead==' '){
    //...
 i++;
}
else {
		switch (charRead) {
		case '+':  break;
		case '-':  break;
		case '*':   break;
		case '/':   break;
		case '(':   break;
		case ')':   break;
                default :error("Invalid character");
		}
	}

}
}    
}
////[/class Rider]
///////////////////

///////////////
//[class Solve]
class Solve  {
    public Solve(){
    File f=new File("D:\\NetBeansProjects\\A_MyLisp\\src\\input.txt");
    FileRider fr=new FileRider(f,"cp1251");;
BufferedReader bf=fr.getBuffered_reader();
     Rider2 r=new Rider2();

try{
String line=bf.readLine();
while(line!=null){
    r.readSymbolAndRecogniseIt(line);
    line=bf.readLine();
}

}catch(IOException ioEx){
    System.out.println("Oshibka chteniya stroki iz faila["+ioEx+"]");
}
}
}
//[/class Solve]
///////////////
//////////////
//[class Program]
class Program{
    public static void main(String[] args) {
        new Solve();
    }
}
//[/class Program]
//////////////////

