import inicioDeSesión.LoginFrame;
import ui.*;
import game.*;


public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        //new home();
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}
