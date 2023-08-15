package ef.CRUDwithGson.view;

import ef.CRUDwithGson.controller.LabelController;
import ef.CRUDwithGson.controller.PostController;
import ef.CRUDwithGson.controller.WriterController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WriterView {
    static WriterController writerController = new WriterController();
    static LabelController labelController = new LabelController();
    static PostController postController = new PostController();
    static int number = 0;
    static String str = null;
    static String str2 = null;
    static Scanner scanner = new Scanner(System.in);


    public static void findWriterById() throws IOException, InterruptedException {
        System.out.println("enter id for find writer");

        try {
            scanner = new Scanner(System.in);
            number = scanner.nextInt();
            System.out.println(writerController.findWriterById(number));
        } catch (InputMismatchException e) {
            System.out.println("enter only numbers");
        } catch (NullPointerException e) {
            System.out.println("writer not found");
        } catch (IOException e) {
            System.out.println("file JSON not found");
        }

        System.out.println();
        System.out.println("please press ENTER to return Writer menu..");
        System.in.read();
        MenuView.runMenuView();
    }

    public static void deleteWriterById() throws IOException, InterruptedException {
        System.out.println("enter id for delete writer");
        try {
            number = scanner.nextInt();
            writerController.deleteWriter(number);
            System.out.println("writer deleted");
        } catch (InputMismatchException e) {
            System.out.println("enter only numbers");
        } catch (NullPointerException e) {
            System.out.println("writer not found");
        } catch (IOException e) {
            System.out.println("file JSON not found");
        }

        System.out.println();
        System.out.println("please press ENTER to return Writer menu..");
        System.in.read();
        MenuView.runMenuView();
    }

    public static void adddWriter() throws IOException, InterruptedException {
        String str2 = null;
        String str3 = null;
        String str4 = null;
        try {
            System.out.println("Enter First Name");
            str = scanner.nextLine();
            System.out.println("Enter Last Name");
            str2 = scanner.nextLine();
            System.out.println("Enter content for Post");
            str3 = scanner.nextLine();
            System.out.println("Enter labels with a SPACE in Post");
            str4 = scanner.nextLine();
            writerController.saveWriter(str,str2,str3,str4);
            System.out.println("post from writer saved");
        } catch (InputMismatchException e) {
            System.out.println("enter only string");
        } catch (NullPointerException e) {
            System.out.println("first record");
            writerController.saveWriter(str,str2,str3,str4);
            System.out.println("post saved");
        } catch (FileNotFoundException e) {
            System.out.println("file JSON not found");
            writerController.saveWriter(str,str2,str3,str4);
            System.out.println("post saved");
        }

        System.out.println();
        System.out.println("please press ENTER to return Writer menu..");
        System.in.read();
        MenuView.runMenuView();
    }

    public static void updateWriterById() throws IOException, InterruptedException {
        try {
            System.out.println("Enter id writer");
            number = scanner.nextInt();
            System.out.println("Enter First Name");
            str = scanner.next();
            System.out.println("Enter Last Name");
            str2 = scanner.next();
            writerController.updateWriter(number,str,str2);
            System.out.println("update from writer saved");
        } catch (InputMismatchException e) {
            System.out.println("enter only string");
        } catch (NullPointerException e) {
            System.out.println("writer not found");
        } catch (FileNotFoundException e) {
            System.out.println("file JSON not found");
        }

        System.out.println();
        System.out.println("please press ENTER to return CRUD menu..");
        System.in.read();
        MenuView.runMenuView();
    }

    public static void getAllWriters() throws IOException, InterruptedException {
        try {
            System.out.println(writerController.getAllWriters());
        } catch (FileNotFoundException e) {
            System.out.println("file JSON not found");
        }

        System.out.println();
        System.out.println("Please press ENTER to return CRUD menu..");
        System.in.read();
        MenuView.runMenuView();
    }
}




