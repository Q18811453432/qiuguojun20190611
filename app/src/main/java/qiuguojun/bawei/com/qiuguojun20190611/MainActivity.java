package qiuguojun.bawei.com.qiuguojun20190611;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import qiuguojun.bawei.com.qiuguojun20190611.base.Mybase;
import qiuguojun.bawei.com.qiuguojun20190611.bean.JSonBean;
import qiuguojun.bawei.com.qiuguojun20190611.presenter.Presenter;
/*作者邱国军
* 日期20190611
*
* */
public class MainActivity extends AppCompatActivity implements IContact.IView {

    private String path = "https://www.apiopen.top/satinApi";
    public static Context contexts;
    private Presenter presenter;

    private Mybase adapter;
    private List<JSonBean.datas> lists = new ArrayList<>();
    private int index = 0;
    private XRecyclerView Xlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        contexts = this;
        presenter = new Presenter(this);
        presenter.startRequest(path);
        adapter = new Mybase(lists, contexts);
        Xlist.setAdapter(adapter);
        //设置上拉西拉权限
    Xlist.setPullRefreshEnabled(true);
        Xlist.setLoadingMoreEnabled(true);
        Xlist.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            //上拉刷新
            public void onRefresh() {
                index++;
                presenter.startRequest(path);
                Xlist.refreshComplete();
            }
//下拉加载
            @Override
            public void onLoadMore() {
                presenter.startRequest(path);
                Xlist.loadMoreComplete();
            }
        });
    }
//解析数据
    @Override
    public void getData(String json) {
        Gson gson = new Gson();
        JSonBean jSonBean = gson.fromJson(json, JSonBean.class);
        List<JSonBean.datas> data = jSonBean.getData();
        Log.i("TAG", data.size() + "");

        lists.addAll(data);
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        //资源id
        Xlist = (XRecyclerView) findViewById(R.id.Xlist);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        Xlist.setLayoutManager(manager);




    }
}
