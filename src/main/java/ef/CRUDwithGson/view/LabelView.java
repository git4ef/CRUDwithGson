package ef.CRUDwithGson.view;

import ef.CRUDwithGson.controller.LabelController;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LabelView {
    private int number = 0;
    private String str = null;
    private final Scanner scanner = new Scanner(System.in);
    private final LabelController labelController = new LabelController();
    private final MenuView menuView = new MenuView();


    public void findLabelById() {
        System.out.println("enter id for find label");

        try {
            number = scanner.nextInt();
            System.out.println(labelController.findLabelById(number));
        } catch (InputMismatchException e) {
            System.out.println("enter only numbers");
        } catch (NullPointerException e) {
            System.out.println("label not found");
        }

        System.out.println();
        System.out.println("Please press ENTER to return CRUD menu..");
        try {
            System.in.read();
            menuView.runMenuView();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteLabelById() {
        System.out.println("enter id for delete label");

        try {
            number = scanner.nextInt();
            labelController.deleteLabel(number);
            System.out.println("label deleted");
        } catch (InputMismatchException e) {
            System.out.println("enter only numbers");
        } catch (NullPointerException e) {
            System.out.println("label not found");
        }

        System.out.println();
        System.out.println("please press ENTER to return CRUD menu..");
        try {
            System.in.read();
            menuView.runMenuView();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
            ;
        }
    }

    public void addLabel() {
        System.out.println("enter name label for save");

        try {
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
        }
        System.out.println();
        System.out.println("please press ENTER to return CRUD menu..");
        try {
            System.in.read();
            menuView.runMenuView();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
            ;
        }
    }

    public void updateLabelById() {
        System.out.println("enter id for update label");

        try {
            number = scanner.nextInt();
            System.out.println("enter name for update label");
            str = scanner.next();
            labelController.updateLabel(number, str);
            System.out.println("label updated");
        } catch (InputMismatchException e) {
            System.out.println("Enter only numbers for id and only string for name label");
        } catch (NullPointerException e) {
            System.out.println("Label not found");
        }

        System.out.println();
        System.out.println("please press ENTER to return CRUD menu..");
        try {
            System.in.read();
            menuView.runMenuView();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
            ;
        }
    }

    public void getAllLabels() {
        System.out.println(labelController.getAllLabels());

        System.out.println();
        System.out.println("please press ENTER to return CRUD menu..");
        try {
            System.in.read();
            menuView.runMenuView();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

