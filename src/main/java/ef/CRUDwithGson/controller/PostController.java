package ef.CRUDwithGson.controller;

import ef.CRUDwithGson.model.Label;
import ef.CRUDwithGson.model.Post;
import ef.CRUDwithGson.model.Writer;
import ef.CRUDwithGson.repository.PostRepository;
import ef.CRUDwithGson.repository.gson.PostRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class PostController {
    private final PostRepository postRepository = new PostRepositoryImpl();
    private final LabelController labelController = new LabelController();


    public Post findPostById(int id) {
        return postRepository.getById(id);
    }

    public void deletePost(int id) {
        postRepository.deleteById(id);

    }

    public List<Post> getAllPosts() {
        return postRepository.getAll();
    }

    public Post updatePost(int id, String content, String labels) {
        return postRepository.update(new Post(id, content, labelController.findOrCreateLabelsByString(labels)));
    }

    public Post savePost(String content, String labels) {
        return postRepository.save(new Post(content, labelController.findOrCreateLabelsByString(labels)));
    }

    public List<Post> findPostsById(String posts) {
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

