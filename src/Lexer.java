////////////
//[packages]
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
//[/packages]
/////////////
//////////////


///////////////
////////////////
//[class Rider]
public class Lexer{

String token;
String kind;

RegExp re;
 /*   @param  void
  @return   String
  ��� ������ ������ ������
*/
    public String getToken() {
        return token;
    }

/*�����������
*/
    public Lexer() {
       
        
        re=new RegExp();
        
    }
    public static boolean isOp(char ch){
     switch (ch) {
		case '+':  return true;
		case '-':  return true;
		case '*':  return  true;
		case '/':  return true;
		case '(':  return true;
		case ')':  return true;   
    }
   return false; }

/*@param String lispExpression
  @return void
  ��� ������:�������� �� ���� ������ ����������� �� �����.
	����������� ��������� ������.�������� ����� ������ � ������� ������� �����
	�������� �� ������.���������� ���������� �� ������ � �������������(���� ��������� �����),
	� ����� ���,���� ��� � �����.��������� ��� ������.���� ������ �� �������� -��������� ��
	������,����� error()
	
	 
*/  
    public void readSymbolAndRecogniseAndSetId(String lispExpression,int nline){
       
 char charRead='\0';         
  int ncol=0,ntok;


charRead = lispExpression.charAt(0);
for(int i=0;i<lispExpression.length();i++){
charRead = lispExpression.charAt(i);
++ncol;
if((char)charRead=='\n'){
 ncol=0;
 ++nline;
}
/* �������� ������� ������� ������� */
	ntok = ncol;
        // <����������� � �����,���� >
        if(re.test(String.valueOf(charRead),"\\d") ||re.test(String.valueOf(charRead),"\\d") || re.test(String.valueOf(charRead),"[A-Z]") || re.test(String.valueOf(charRead),"[a-z]") || (charRead==' ') ||isOp(charRead) ){
if(re.test(String.valueOf(charRead),"^\\d+$") ||re.test(String.valueOf(charRead),"^\\d+\\.\\d+$")){
  
    
}
//<�����������  � ������������ >
else if(re.test(String.valueOf(charRead),"[a-z]") ){
    //...
    
}
else if(re.test(String.valueOf(charRead),"[A-Z]") ){
    //...
//    this.token=String.valueOf(charRead);
//    this.kind="OPERACIYA";
   
}
else if(charRead==' '){
    //...
 
}
else if(isOp(charRead)){
    
}
        
        }else{
            System.out.println("!Syntax Parse error");
	System.out.printf("Error at (%d: %d): %s\n", nline, ntok,"Invalid character" );
//        �����-��� 1,������ ��������������� �����������
        System.exit(1);
        }

}
}    
}
////[/class Lisp]
///////////////////

///////////////
  class LispMachine{
 public   double eval(String t,int nline){
    
    RegExp re=new RegExp();
//���������� ��� ���������� ���������� ���� 
 double dAStack=0,dBStack=0;   
//    
//    ���� ��� ��������� � ���������� �������
    Deque<Double> stack=new ArrayDeque<>();
//
//  
 String term="";    
 String expression="";
// ����� Lisp �������� �� ��������
int length=t.length();

//
char fst=t.charAt(0),lst=t.charAt(length-1);
if(fst=='(' && lst==')')
 expression= t.substring(1,length-1);
else {
//    �����-������ ������������� ������
  System.out.println("Parse error");
	System.out.printf("Error at (%d: ): %s\n", nline,"Oshibka razbora skobok" );
//        �����-��� 2,������ �������
        System.exit(2);  
}
StringTokenizer st=new StringTokenizer(expression,"+-*/^u ",true);
//
//���������
while(st.hasMoreTokens()){
    String sTmp=st.nextToken().trim();
    if(Lexer.isOp(sTmp.charAt(0))){
//        ���� ������� �������� ���������� �� � ����
        
    term=sTmp;    
    }else if(re.test(sTmp,"\\d|\\.")){
//(������������� ���������� �����) ���� ����� -����� � ����
   double dA=Double.parseDouble(sTmp);
//   
//   
   stack.push(dA);
//   ���� � ����� 2 �����-��������� � ��������� � ����������� �� ����������� term
   if(stack.size()==2){
       dAStack=stack.pop();
       dBStack=stack.pop();
       switch(term){
           case "+": dAStack+=dBStack;break;
           case "-": dAStack-=dBStack;break;
           case "*": dAStack*=dBStack;break;
           case "/": dAStack /=dBStack;break;
           default:System.out.println("Parse error");
	System.out.printf("Error at (%d: ): %s\n", nline,"Oshibka razbora virajeniya-nedopustimaya operasiya" );
//        �����-��� 5,������ �������
        System.exit(5);       
       }
       
   }else{
  System.out.println("Parse error");
	System.out.printf("Error at (%d: ): %s\n", nline,"Oshibka razbora virajeniya-bollee dvuh operatorov" );
//        �����-��� 4,������ �������
        System.exit(4);       
   }
        
    }else {
  System.out.println("Parse error");
	System.out.printf("Error at (%d: ): %s\n", nline,"Oshibka razbora virajeniya" );
//        �����-��� 3,������ �������
        System.exit(3);  
}
}
//����� ���������
//
return dAStack;
}
        
        
    
      
  }              
//[class Solve]
 class Solve  {
    public Solve(){
    File f=new File("D:\\NetBeansProjects\\A_MyLisp\\src\\input.txt");
    FileRider fr=new FileRider(f,"cp1251");;
BufferedReader bf=fr.getBuffered_reader();
     Lexer l=new Lexer();
     LispMachine lm=new LispMachine();
     

try{
    int i=1;
String line=bf.readLine();
while(line!=null){
    l.readSymbolAndRecogniseAndSetId(line,i);
    System.out.println(lm.eval(line, i));
    line=bf.readLine();
    
    
  

    i++;
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

