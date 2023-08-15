package ef.CRUDwithGson.controller;

import ef.CRUDwithGson.model.Label;
import ef.CRUDwithGson.model.Post;
import ef.CRUDwithGson.repository.PostRepositoryImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostController {
    PostRepositoryImpl postRepository = new PostRepositoryImpl();
    LabelController labelController = new LabelController();


    public Post findPostById(int id) throws IOException {
        return postRepository.getById(id);
    }

    public void deletePost(int id) throws IOException {
        postRepository.deleteById(id);

    }

    public List<Post> getAllPosts() throws IOException {
        return postRepository.getAll();
    }

    public Post updatePost(int id, String content, String labels) throws IOException {
        return postRepository.update(new Post(id, content, labelController.findOrCreateLabelsByString(labels)));
    }

    public Post savePost(String content, List<Label> labels) throws IOException {
        return postRepository.save(new Post(content, labels));
    }

    public List<Post> findPostsById(String posts) throws IOException {
        List<Post> postList = new ArrayList<>();
        String[] postsId = posts.split(" ");
        for (String post : postsId) {
            if (postRepository.getById(Integer.valueOf(post)) != null) {
                postList.add(postRepository.getById(Integer.valueOf(post)));
            } else {
                System.out.println("post with ID: " + post + "not found");
            }
        }
        return postList;
    }
}

