
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Lisp{
    int x;
    private final String[] FUNCTIONS = {"sin","cos","tan"};
    private boolean isFunction(String token) {
        for (String item : FUNCTIONS) {
            if (item.equals(token)) {
                return true;
            }
        }
        return false;
    }
     private  boolean isOp(String c) {
        switch (c) {
            case "-":
            case "+":
            case "*":
            case "/":
            case "^":
            case  "u":
            
                return true;
        }
        return false;
    }
 public  double calculate(String sIn) throws Exception {
       //System.out.println("iz calculate() "+sIn);
        double dA = 0, dB = 0;
        String sTmp;
        Deque<Double> stack = new ArrayDeque<Double>();
        StringTokenizer st = new StringTokenizer(sIn);
        while(st.hasMoreTokens()) {
            try {
                
                sTmp = st.nextToken().trim();
                                         
                if ((1 == sTmp.length() && isOp(sTmp))||isFunction(sTmp)) {
                    if(isFunction(sTmp) && (sTmp.equals("sin")||sTmp.equals("cos")||sTmp.equals("tan"))){
                    dA=stack.pop();
                    switch(sTmp){
                    case "sin":
                        dA=Math.sin(dA);
                        break;
                    case "cos":
                        dA=Math.cos(dA);
                        break;
                        case "tan":
                        dA=Math.tan(dA);
                        break;
                        default:
                            throw new Exception("������������ �������� " + sTmp);
                    }
                    stack.push(dA);
                } 
                    
                    if ((1 == sTmp.length() && isOp(sTmp))&& !sTmp.equals("u")){
                    dB = stack.pop();
                    dA = stack.pop();
                    switch (sTmp) {
                        case "+":
                            dA += dB;
                            break;
                        case "-":
                            dA -= dB;
                            break;
                        case "/":
                            dA /= dB;
                            break;
                        case "*":
                            dA *= dB;
                            break;
                        case "%":
                            dA %= dB;
                            break;
                        case "^":
                            dA = Math.pow(dA, dB);
                            break;
                        default:
                            throw new Exception("������������ �������� " + sTmp);
                    }
                    stack.push(dA);
                    
                }
                    if ((1 == sTmp.length() && isOp(sTmp))&& sTmp.equals("u")){
                      dA=stack.pop();
                      switch(sTmp){
                      case "u":
                      dA=-dA;
                          break;
                      default:
                            throw new Exception("������������ �������� " + sTmp);
                    }
                      stack.push(dA);
                    }
                    
                }else {
                    try {
                        if(sTmp.equals("x")){
                        dA =x;
                                          
                        stack.push(dA);
                        
                        }else{
                       
                            dA = Double.parseDouble(sTmp);
                             stack.push(dA);
                        }
                        }

                    
                    catch (Exception ex){
                        ex.printStackTrace();
                        

                        
                    }
                }
            
            } catch (Exception e) {
                throw new Exception("������������ ������ � ���������");
            }
            
        }
        

        if (stack.size() > 1) {
            throw new Exception("���������� ���������� �� ������������� ���������� ���������");
        }

        return stack.pop();
    }
}
