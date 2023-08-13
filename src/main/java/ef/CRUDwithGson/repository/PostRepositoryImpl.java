package ef.CRUDwithGson.repository;

import ef.CRUDwithGson.model.Post;
import ef.CRUDwithGson.model.PostStatus;
import ef.CRUDwithGson.util.PostGsonUtil;
import java.util.*;

public class PostRepositoryImpl implements PostRepository {
    PostGsonUtil postGsonUtil = new PostGsonUtil();

    @Override
    public Post save(Post post) {
        List<Post> postList = new ArrayList<>();
        postList = postGsonUtil.deserializingToObjects();
        postList.add(post);
        postGsonUtil.serializingToJson(postList);
        return post;
    }
    @Override
    public Post getById(Integer id) {
        return postGsonUtil.deserializingToObjects().stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Post update(Post post) {
        List<Post> postList = new ArrayList<>();
        postList = postGsonUtil.deserializingToObjects();
        postList.get(post.getId()).setContent(post.getContent());
        postList.get(post.getId()).setUpdated(new Date());
        postList.get(post.getId()).setLabelList(post.getLabelList());
        postGsonUtil.serializingToJson(postList);
        return post;
    }

    @Override
    public void deleteById(Integer id) {
        List<Post> postList = new ArrayList<>();
        postList = postGsonUtil.deserializingToObjects();
        postList.stream().filter(s -> s.getId() == id)
                        .findFirst()
                        .orElse(null).setStatus(PostStatus.DELETED);
        postGsonUtil.serializingToJson(postList);
    }

    @Override
    public List<Post> getAll() {
        return postGsonUtil.deserializingToObjects();
    }
}


