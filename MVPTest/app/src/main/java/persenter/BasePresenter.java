package persenter;

public abstract class BasePresenter<T> {
    public T mView;
    public void attach(T view){
        this.mView = view;
    }
    public void detach(){
        mView = null;
    }
}
