
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

class Rider2{
int ncol;
int nline;
int ntok;
FileRider fr;
BufferedReader bf;

    public Rider2() {
        ncol=0;
        nline=1;
        ntok=0;
        File f=new File("input.txt");
        fr=new FileRider(f,"cp-1251");
        
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

while (charRead != -1 && charRead==' '){
charRead = bf.read();
++ncol;
if(charRead=='\n'){
 ncol=0;
 ++nline;
}
/* Запомним позицию текущей лексемы */
	ntok = ncol;
if(charRead <принадлежит к Числу,Дабл > ){
    //...
}
else if(charRead <принадлежит к Индификатору > ){
    //...
}
else {
		switch (charRead) {
		case '+': sym = T_ADD; break;
		case '-':  sym = T_SUB; break;
		case '*':  sym = T_MUL; break;
		case '/':  sym = T_DIV; break;
		case '(':  sym = T_LPAREN; break;
		case ')':  sym = T_RPAREN; break;
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
    
