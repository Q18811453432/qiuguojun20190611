package qiuguojun.bawei.com.qiuguojun20190611.presenter;

import java.lang.ref.SoftReference;

import qiuguojun.bawei.com.qiuguojun20190611.IContact;
import qiuguojun.bawei.com.qiuguojun20190611.model.Model;
//p层
/*作者邱国军
 * 日期20190611
 *
 * */
public class Presenter implements IContact.IPresenter{
    private Model model;
    private IContact.IView iView;
    private SoftReference<IContact.IView> softReference;

    public Presenter(IContact.IView iView) {
        model =new Model();
        this.iView = iView;
       softReference=new SoftReference<>(iView);
    }

    @Override
    public void startRequest(String url) {
       model.getData(url, new IContact.Callback() {
           @Override
           public void saveData(String json) {
               iView.getData(json);
           }
       });
    }

    @Override
    public void onDetach() {
        if (softReference!=null){
            softReference.clear();
        }
        if (model!=null){
            model=null;
        }
    }
}
