package biz;

import bean.PostQueryInfo;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface PostServiceBiz {
    @POST("query")
    Observable<PostQueryInfo> searchRx(@Query("type") String type, @Query("postid") String postid);
}
