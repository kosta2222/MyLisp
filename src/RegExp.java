import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExp{
public boolean test(String testString,String pattern){
Pattern p=Pattern.compile(pattern);
Matcher m=p.matcher(testString);
return m.matches();}
}