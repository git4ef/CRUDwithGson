package ef.CRUDwithGson.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ef.CRUDwithGson.controller.PostController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MenuView {

    public static void runMenuView() throws InterruptedException, IOException {

        System.out.println("CRUD Menu:");
        System.out.println("1 - ADD ARTICLE\n" +
                "2 - DELETE\n" +
                "3 - UPDATE\n" +
                "4 - SEARCH\n" +
                "5 - DISPLAY\n" +
                "6 - EXIT");
        System.out.println("Enter your choice: ");

        int number = 0;
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("enter only numbers");
            TimeUnit.SECONDS.sleep(2);
            MenuView.runMenuView();
        }


        switch (number) {
            case 1:
                WriterView.adddWriter();
            case 2:
                System.out.println("Select object for delete:");
                System.out.println(
                        "1. Writer\n" +
                                "2. Post\n" +
                                "3. Label\n");
                number = scanner.nextInt();
                switch (number) {
                    case 1:
                        WriterView.deleteWriterById();
                    case 2:
                        PostView.deletePostById();
                    case 3:
                        LabelView.deleteLabelById();
                }

            case 3:
                System.out.println("Select object for update:");
                System.out.println(
                        "1. Writer\n" +
                                "2. Post\n" +
                                "3. Label\n");
                number = scanner.nextInt();
                switch (number) {
                    case 1:
                        WriterView.updateWriterById();
                    case 2:
                        PostView.updatePostById();
                    case 3:
                        LabelView.updateLabelById();
                }

            case 4:
                System.out.println("Select object for search:");
                System.out.println(
                        "1. Writer\n" +
                                "2. Post\n" +
                                "3. Label\n");
                number = scanner.nextInt();
                switch (number) {
                    case 1:
                        WriterView.findWriterById();
                    case 2:
                        PostView.findPostById();
                    case 3:
                        LabelView.findLabelById();
                }

            case 5:
                System.out.println("Select object for display:");
                System.out.println(
                        "1. Writer\n" +
                                "2. Post\n" +
                                "3. Label\n");
                number = scanner.nextInt();
                switch (number) {
                    case 1:
                        WriterView.getAllWriters();
                    case 2:
                        PostView.getAllPosts();
                    case 3:
                        LabelView.getAllLabels();
                }

            case 6:
                System.exit(0);
        }
    }
}

