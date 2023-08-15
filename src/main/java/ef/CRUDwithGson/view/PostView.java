package ef.CRUDwithGson.view;

import ef.CRUDwithGson.controller.PostController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PostView {

    static PostController postController = new PostController();

    static int number = 0;
    static String str = null;
    static String labels = null;
    String json;
    static Scanner scanner;


    public static void findPostById() throws IOException, InterruptedException {
        System.out.println("enter id for find post");

        try {
            scanner = new Scanner(System.in);
            number = scanner.nextInt();
            System.out.println(postController.findPostById(number));
        } catch (InputMismatchException e) {
            System.out.println("enter only numbers");
        } catch (NullPointerException e) {
            System.out.println("post not found");
        } catch (IOException e) {
            System.out.println("file JSON not found");
        }

        System.out.println();
        System.out.println("please press ENTER to return CRUD menu..");
        System.in.read();
        MenuView.runMenuView();
    }

    public static void deletePostById() throws IOException, InterruptedException {
        System.out.println("enter id for delete post");

        try {
            scanner = new Scanner(System.in);
            number = scanner.nextInt();
            postController.deletePost(number);
            System.out.println("post deleted");
        } catch (InputMismatchException e) {
            System.out.println("enter only numbers");
        } catch (NullPointerException e) {
            System.out.println("post not found");
        } catch (IOException e) {
            System.out.println("file JSON not found");
        }

        System.out.println();
        System.out.println("please press ENTER to return CRUD menu..");
        System.in.read();
        MenuView.runMenuView();
    }

    public static void updatePostById() throws IOException, InterruptedException {
        System.out.println("enter id for update post");
        try {
            scanner = new Scanner(System.in);
            number = scanner.nextInt();
            System.out.println("enter content for update post");
            str = scanner.next();
            System.out.println("enter labels with a SPACE to update in post");
            labels = scanner.next();
            postController.updatePost(number, str, labels);
            System.out.println("post updated");
        } catch (InputMismatchException e) {
            System.out.println("enter only numbers for id and only string for content and labels");
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

    public static void getAllPosts() throws IOException, InterruptedException {
        try {
            System.out.println(postController.getAllPosts());
        } catch (FileNotFoundException e) {
            System.out.println("file JSON not found");
        }

        System.out.println();
        System.out.println("Please press ENTER to return Label menu..");
        System.in.read();
        MenuView.runMenuView();
    }
}


