package view;

import bean.PostQueryInfo;

public interface MainView extends BaseView{
    void updateListUI(PostQueryInfo postQueryInfo);
    void errorToast(String message);
}
