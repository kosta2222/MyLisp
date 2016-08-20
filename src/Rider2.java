
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

class Rider2{
int ncol;
int nline;
int ntok;
FileRider fr;
BufferedReader bf;
RegExp re;

    public Rider2() {
        ncol=0;
        nline=1;
        ntok=0;
        File f=new File("D:\\NetBeansProjects\\A_MyLisp\\src\\input.txt");
        fr=new FileRider(f,"cp1251");
        re=new RegExp();
        
    }
  public  void error(String msg) {
	     System.out.println("!Syntax Parse error");
	System.out.printf("Error at (%d: %d): %s\n", nline, ntok, msg);
  }
    public void readSymbolAndRecogniseIt(){
        bf=fr.getBuffered_reader();
 int charRead=0;         
    try{
if (bf != null){

while (charRead != -1 && (char)charRead!=' '){
charRead = bf.read();
++ncol;
if((char)charRead=='\n'){
 ncol=0;
 ++nline;
}
/* Запомним позицию текущей лексемы */
	ntok = ncol;
        // <принадлежит к Числу,Дабл >
if(re.test(String.valueOf((char)charRead),"^\\d+$") ||re.test(String.valueOf((char)charRead),"^\\d+\\.\\d+$")){
    //...
}
//<принадлежит  к Индификатору >
else if(re.test(String.valueOf((char)charRead),"^\\w+$") ){
    //...
}
else {
		switch ((char)charRead) {
		case '+':  break;
		case '-':  break;
		case '*':   break;
		case '/':   break;
		case '(':   break;
		case ')':   break;
		default:  error("Invalid character"); break;
		}
	}
}
}
    }
catch(IOException ioEx){
System.err.println("Oshibka chteniya faila["+ioEx+"]");

}
        
try{bf.close();

}catch(IOException ioEx){
System.err.println("Oshibka zakritiya faila["+ioEx+"]");
   
}    

}
 }
    
class Program  {
public static void main(String args[]){
Rider2 r=new Rider2();
r.readSymbolAndRecogniseIt();
}
}
