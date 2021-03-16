package lab1;

import lab1.test.TestApp;
import lab1.test.TestByConsole;

public class Main {

    public static void main(String[] args) {
        TestApp app = new TestApp();
        TestByConsole app1 = new TestByConsole();
        app.startApp();
        app1.startApp();
    }
}
