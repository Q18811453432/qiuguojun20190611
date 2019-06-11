package qiuguojun.bawei.com.qiuguojun20190611.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import qiuguojun.bawei.com.qiuguojun20190611.R;
import qiuguojun.bawei.com.qiuguojun20190611.bean.JSonBean;
/*作者邱国军
 * 日期20190611
 *
 * */
public class Mybase extends RecyclerView.Adapter<Mybase.OneHolder>{
    private List<JSonBean.datas> list;
    private Context context;

    public Mybase(List<JSonBean.datas> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public OneHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context,R.layout.mybase, null);
        OneHolder oneHolder=new OneHolder(view);
        return oneHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OneHolder oneHolder, int i) {
     oneHolder.t_name.setText(list.get(i).getName());
        oneHolder.t_text.setText(list.get(i).getText());
        Glide.with(context).load(list.get(i).getCdn_img()).into(oneHolder.t_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class OneHolder extends RecyclerView.ViewHolder{
        private TextView t_name,t_text;
        private ImageView t_image;
        public OneHolder(@NonNull View itemView) {
            super(itemView);
            t_name=itemView.findViewById(R.id.name);
            t_text=itemView.findViewById(R.id.text);
            t_image=itemView.findViewById(R.id.image);
        }
    }
}
