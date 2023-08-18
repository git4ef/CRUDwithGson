package ef.CRUDwithGson;

import ef.CRUDwithGson.view.MenuView;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        MenuView menuView = new MenuView();
        menuView.runMenuView();
    }
}
