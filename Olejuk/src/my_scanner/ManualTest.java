package my_scanner;

/**
 * Created by dexter on 26.02.16.
 */
public class ManualTest {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner(System.in);

        System.out.print("Enter 'Oleg yo' - ");
        String next = scanner.next();
        scanner.reset();

        System.out.print("Enter 'Oleg yo' - ");
        String nextLine = scanner.nextLine();

        System.out.print("Enter '555' - ");
        int num1 = 0;
        if(scanner.hasInt()){
            num1 = scanner.nextInt();
        }

        if(next.equals("Oleg")){
            if(nextLine.equals("Oleg yo\n")){
                if(num1 == 555){
                    System.out.println("Everything OK");
                }
            }
        }
    }
}
