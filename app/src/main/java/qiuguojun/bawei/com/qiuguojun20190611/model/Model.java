package qiuguojun.bawei.com.qiuguojun20190611.model;

import qiuguojun.bawei.com.qiuguojun20190611.IContact;
import qiuguojun.bawei.com.qiuguojun20190611.MainActivity;
import qiuguojun.bawei.com.qiuguojun20190611.utils.VolleyUtil;
/*作者邱国军
 * 日期20190611
 *
 * */
//M层
public class Model implements IContact.IModel{
    @Override
    public void getData(String url, final IContact.Callback callback) {
        VolleyUtil.getInstance().getUrl(url, MainActivity.contexts, new VolleyUtil.VolleyCallback() {
            @Override
            public void setResult(String jsonstr) {
                callback.saveData(jsonstr);
            }
        });
    }
}
