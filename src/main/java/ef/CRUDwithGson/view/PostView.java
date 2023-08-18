package ef.CRUDwithGson.view;

import ef.CRUDwithGson.controller.LabelController;
import ef.CRUDwithGson.controller.PostController;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PostView {

    private int number = 0;
    private final Scanner scanner = new Scanner(System.in);
    private final MenuView menuView = new MenuView();
    private final PostController postController = new PostController();
    private final LabelController labelController = new LabelController();


    public void findPostById() {
        System.out.println("enter id for find post");

        try {
            number = scanner.nextInt();
            if (postController.findPostById(number) == null) {
                throw new NullPointerException();
            } else {
                System.out.println(postController.findPostById(number));
            }
        } catch (InputMismatchException e) {
            System.out.println("enter only numbers");
        } catch (NullPointerException e) {
            System.out.println("post not found");
        }

        System.out.println();
        System.out.println("please press ENTER to return CRUD menu..");
        try {
            System.in.read();
            menuView.runMenuView();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletePostById() {
        System.out.println("enter id for delete post");

        try {
            number = scanner.nextInt();
            if (postController.findPostById(number) == null) {
                throw new NullPointerException();
            } else {
                postController.deletePost(number);
                System.out.println("post deleted");
            }
        } catch (InputMismatchException e) {
            System.out.println("enter only numbers");
        } catch (NullPointerException e) {
            System.out.println("post not found");
        }

        System.out.println();
        System.out.println("please press ENTER to return CRUD menu..");
        try {
            System.in.read();
            menuView.runMenuView();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updatePostById() {
        String content = null;
        String labels = null;
        try {
            System.out.println("enter id for update post");
            number = scanner.nextInt();
            System.out.println("enter content for update post");
            content = scanner.next();
            scanner.nextLine();
            System.out.println("Enter labels with a SPACE in Post");
            labels = scanner.nextLine();
            postController.updatePost(number, content, labels);
            System.out.println("post updated");

        } catch (InputMismatchException e) {
            System.out.println("enter only numbers for id and only string for content and labels");
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
        }
    }

    public void getAllPosts() {
        System.out.println(postController.getAllPosts());

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


