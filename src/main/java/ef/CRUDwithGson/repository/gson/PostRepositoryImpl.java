package ef.CRUDwithGson.repository.gson;

import ef.CRUDwithGson.model.Post;
import ef.CRUDwithGson.model.PostStatus;
import ef.CRUDwithGson.repository.PostRepository;
import ef.CRUDwithGson.util.PostGsonUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {
    private final PostGsonUtil postGsonUtil = new PostGsonUtil();

    @Override
    public Post save(Post post) {
        List<Post> posts = new ArrayList<>();
        posts = postGsonUtil.deserializingToObjects();
        post.setId(postGsonUtil.getIdForObject(posts));
        posts.add(post);
        postGsonUtil.serializingToJson(posts);
        return post;
    }

    @Override
    public Post getById(Integer id) {
        return postGsonUtil.deserializingToObjects().stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Post update(Post postToUpdate) {
        List<Post> postList = new ArrayList<>();
        postList = postGsonUtil.deserializingToObjects();
        List<Post> updatedPostList = postList.stream().
                map(currentPost -> {
                    if(currentPost.getId() == postToUpdate.getId()) {
                        postToUpdate.setCreated(currentPost.getCreated());
                        postToUpdate.setUpdated(new Date());
                        return postToUpdate;
                    }
                    return currentPost;
                }).toList();
        postGsonUtil.serializingToJson(updatedPostList);
        return postToUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        List<Post> postsList = null;
        postsList= postGsonUtil.deserializingToObjects();
        List<Post> updatedPostList = postsList.stream().
                map(currentPost -> {
                    if(currentPost.getId() == id) {
                        currentPost.setStatus(PostStatus.DELETED);
                    }
                    return currentPost;
                }).toList();
        postGsonUtil.serializingToJson(updatedPostList);
    }

    @Override
    public List<Post> getAll() {
        return postGsonUtil.deserializingToObjects();
    }
}





