class Rider{


public  static Object readToken(String t){
int length=t.length();
char fst=t.charAt(0),lst=t.charAt(length-1);
if(fst=='(' && lst==')')
return t.substring(1,length-1);
else if(fst=='"' && lst=='"')
return t.substring(1,length-1);
else if (t.equals("true")) return true;
else if (t.equals("false")) return false;
else
            try {return Integer.parseInt(t);} //Integer.valueOf(t);
            catch (NumberFormatException errorInteger) {
            
            }
                try {return Double.parseDouble(t);} //Double.valueOf(t);
                catch (NumberFormatException errorDouble) {
                    
                }
return null;}
}

/*class Main  {
public static void main(String args[]){
 Rider r=new Rider();
System.out.println(r.readToken("(( define pi 3 )(set! x 1))"));
System.out.println(r.readToken("\"Hello!\""));
System.out.println(r.readToken("true"));
System.out.println(r.readToken("false"));
System.out.println(r.readToken("3.7"));
/*<---run:
define pi 3
Hello!
true
false
3.7
*/

//}
//}

