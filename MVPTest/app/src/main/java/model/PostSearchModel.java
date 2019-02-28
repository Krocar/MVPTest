package model;

import bean.PostQueryInfo;

public interface PostSearchModel {
    /*
    * @param type     快递类型
    * @param postid   快递单号
    * @param callback 结果回调
    * */
    void requestPostSearch(String type,String postid,PostSearchCallback callback);
    interface  PostSearchCallback{
        void requestPostSearchSuccess(PostQueryInfo postQueryInfo);
        void requestPostSearchFail(String failStr);
    }
}
