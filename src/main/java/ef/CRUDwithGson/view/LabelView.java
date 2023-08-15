package ef.CRUDwithGson.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static ef.CRUDwithGson.view.WriterView.labelController;

public class LabelView {
    static int number = 0;
    static String str = null;
    static Scanner scanner;


    public static void findLabelById() throws IOException, InterruptedException {
        System.out.println("enter id for find label");

        try {
            scanner = new Scanner(System.in);
            number = scanner.nextInt();
            System.out.println(labelController.findLabelById(number));
        } catch (InputMismatchException e) {
            System.out.println("enter only numbers");
        } catch (NullPointerException e) {
            System.out.println("label not found");
        } catch (IOException e) {
            System.out.println("file JSON not found");
        }

        System.out.println();
        System.out.println("Please press ENTER to return CRUD menu..");
        System.in.read();
        MenuView.runMenuView();
    }

    public static void deleteLabelById() throws IOException, InterruptedException {
        System.out.println("enter id for delete label");

        try {
            scanner = new Scanner(System.in);
            number = scanner.nextInt();
            labelController.deleteLabel(number);
            System.out.println("label deleted");
        } catch (InputMismatchException e) {
            System.out.println("enter only numbers");
        } catch (NullPointerException e) {
            System.out.println("label not found");
        } catch (IOException e) {
            System.out.println("file JSON not found");
        }

        System.out.println();
        System.out.println("please press ENTER to return CRUD menu..");
        System.in.read();
        MenuView.runMenuView();
    }

    public static void addLabel() throws IOException, InterruptedException {
        System.out.println("enter name label for save");

        try {
            scanner = new Scanner(System.in);
            str = scanner.nextLine();
            if (labelController.findLabelByName(str) != null) {
                throw new IllegalArgumentException();
            } else {
                labelController.saveLabel(str);
                System.out.println("label saved");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("label with this name exist");
        } catch (NullPointerException e) {
            System.out.println("first record");
            labelController.saveLabel(str);
            System.out.println("label saved");
        } catch (FileNotFoundException e) {
            System.out.println("file JSON not found");
            labelController.saveLabel(str);
            System.out.println("label saved");
        }

        System.out.println();
        System.out.println("please press ENTER to return CRUD menu..");
        System.in.read();
        MenuView.runMenuView();
    }

    public static void updateLabelById() throws IOException, InterruptedException {
        System.out.println("enter id for update label");

        try {
            scanner = new Scanner(System.in);
            number = scanner.nextInt();
            System.out.println("enter name for update label");
            str = scanner.next();
            labelController.updateLabel(number, str);
            System.out.println("label updated");
        } catch (InputMismatchException e) {
            System.out.println("Enter only numbers for id and only string for name label");
        } catch (NullPointerException e) {
            System.out.println("Label not found");
        } catch (IOException e) {
            System.out.println("File JSON not found");
        }

        System.out.println();
        System.out.println("Please press ENTER to return Label menu..");
        System.in.read();
        MenuView.runMenuView();
    }

    public static void getAllLabels() throws IOException, InterruptedException {
        try {
            System.out.println(labelController.getAllLabels());
        } catch (FileNotFoundException e) {
            System.out.println("file JSON not found");
        }

        System.out.println();
        System.out.println("Please press ENTER to return Label menu..");
        System.in.read();
        MenuView.runMenuView();
    }
}
