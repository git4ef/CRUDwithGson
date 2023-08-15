package ef.CRUDwithGson.repository;

import ef.CRUDwithGson.model.Post;
import ef.CRUDwithGson.model.PostStatus;
import ef.CRUDwithGson.model.Status;
import ef.CRUDwithGson.util.PostGsonUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {
    PostGsonUtil postGsonUtil = new PostGsonUtil();

    @Override
    public Post save(Post post) throws IOException {
        List<Post> posts = new ArrayList<>();
        try {
            posts = postGsonUtil.deserializingToObjects();
        } catch (FileNotFoundException e) {
            System.out.println("first record, post.json file created..");
            postGsonUtil.serializingToJson(Collections.emptyList());
        }
        post.setId(postGsonUtil.getIdForObject(posts.size()));
        posts.add(post);
        postGsonUtil.serializingToJson(posts);
        return post;
    }

    @Override
    public Post getById(Integer id) throws IOException {
        return postGsonUtil.deserializingToObjects().stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Post update(Post post) throws IOException {
        List<Post> postList;
        postList = postGsonUtil.deserializingToObjects();
        postList.get(post.getId()-1).setContent(post.getContent());
        postList.get(post.getId()-1).setLabelList(post.getLabelList());
        postList.get(post.getId()-1).setUpdated(new Date());
        postGsonUtil.serializingToJson(postList);
        return post;
    }

    @Override
    public void deleteById(Integer id) throws IOException {
        List<Post> postList;
        postList = postGsonUtil.deserializingToObjects();
        postList.stream().filter(c -> c.getId() == id).findFirst().orElse(null).setStatus(PostStatus.DELETED);
        postGsonUtil.serializingToJson(postList);
    }

    @Override
    public List<Post> getAll() throws IOException {
        return postGsonUtil.deserializingToObjects();
    }
}





