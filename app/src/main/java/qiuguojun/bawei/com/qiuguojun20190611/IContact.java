package qiuguojun.bawei.com.qiuguojun20190611;

public interface IContact {
    //m
    interface IModel{
        void getData(String url,Callback callback);
    }
    //v
    interface IView{
        void getData(String json);
    }
    //p
    interface IPresenter{
        void startRequest(String url);
        void onDetach();
    }
    interface Callback{
        void saveData(String json);
    }
}
