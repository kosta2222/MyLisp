
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

class Rider2{
int ncol;
int nline;
int ntok;

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
  

int i=0;
charRead = lispExpression.charAt(i);
while (i<lispExpression.length() && charRead!=' '){
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
//else if((char)charRead==' '){
    //...
//}
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
i++;

}
    
        
    
        

}    

}
 
    
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
    
   
}

}catch(IOException ioEx){
    System.out.println("Oshibka chteniya stroki iz faila["+ioEx+"]");
}
}
}
class Program{
    public static void main(String[] args) {
        new Solve();
    }
}

