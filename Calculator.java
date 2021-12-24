import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface Operation {
    int operate(int x, int y) ;
}

public class Calculator {
    private Map<String, Operation> supportedOperation ;

    public void load(){
        supportedOperation = new HashMap<>() ;
        supportedOperation.put("add", Integer::sum) ;
        supportedOperation.put("sub", (x, y) -> x - y) ;
        supportedOperation.put("mul",(x, y) -> x * y) ;
        supportedOperation.put("div", (x, y) -> x / y) ;
    }
    public void start(){
        load();
        Scanner sc = new Scanner(System.in) ;
        String selectedOperation ;
        System.out.println("Currently Supported Operation:");
        for (String opr : supportedOperation.keySet()){
            System.out.println(" ' " + opr + " ' " + ", ");
        }
        System.out.println("Type EXIT to close");

        do {
            System.out.println("Type Here: ");
            selectedOperation = sc.nextLine();
            if (!supportedOperation.containsKey(selectedOperation)) {
                continue;
            }
            System.out.println("Enter the first argument ");
            int x = Integer.parseInt(sc.nextLine()) ;

            System.out.println("Enter the second argument: ");
            int y = Integer.parseInt(sc.nextLine()) ;

            System.out.println(supportedOperation.get(selectedOperation).operate(x,y));
            System.out.println("******************************************************");
        }while (supportedOperation.equals("EXIT")) ;
    }

    public static void main(String[] args) {
        new Calculator().start();
    }
}
