package tubespbo;

import java.util.*;

public class TUBESPBO {
    public static void main(String[] args) {
        Aplikasi app = new Aplikasi();
        app.MainMenu();
        Scanner s = new Scanner(System.in);
        app.i = s.nextInt();
        app.MainMenu();
        app.a = s.nextInt();
        app.MainMenu();
    }  
}
