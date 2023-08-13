package ef.CRUDwithGson.view;

import ef.CRUDwithGson.controller.LabelController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LabelView {
    LabelController labelController = new LabelController();

    public void runLabelView() throws IOException {
        System.out.println("Label Menu:");
        System.out.println("\"Choose your option:\":\n" +
                "1 - get by id\n" +
                "2 - delete by id\n" +
                "3 - save\n" +
                "4 - update\n" +
                "5 - get all\n" +
                "6 - back");

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();


        switch (number) {
            case 1:
                System.out.println("enter id for find label");
                number = scanner.nextInt();
                if (labelController.findLabelById(number) == null) {
                    System.out.println("not found");
                } else {
                    System.out.println(labelController.findLabelById(number).toString());
                }
                System.out.println();

                System.out.println("Please press ENTER to return Label menu..");
                try {
                    System.in.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                runLabelView();

            case 2:
                System.out.println("enter id for delete label");
                number = scanner.nextInt();
                if (labelController.findLabelById(number) == null) {
                    System.out.println("not found");
                } else {
                    System.out.println("Label ID:" + labelController.findLabelById(number).getId() + " Name:" + labelController.findLabelById(number).getName() + " deleted");
                    labelController.deleteLabel(number);
                }
                System.out.println();

                System.out.println("Please press ENTER to return Label menu..");
                try {
                    System.in.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                runLabelView();

            case 3:
                System.out.println("enter id label");
                number = scanner.nextInt();
                if (labelController.findLabelById(number) != null) {
                    System.out.println("label with ID: " + number + " already exists.");
                    System.out.println("Please press ENTER to return Label menu..");
                    System.in.read();
                } else {
                    String getName = scanner.next();
                    System.out.println("enter name label");
                    labelController.saveLabel(getName);
                    System.out.println();
                    System.out.println("Label has been save " + labelController.findLabelById(number));
                    System.out.println("Please press ENTER to return Label menu..");
                    System.in.read();
                }
                runLabelView();
            case 4:
            case 5:
        }
    }
}
