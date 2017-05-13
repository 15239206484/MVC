package practice.code.com.baseframework.adapter;

import android.content.Context;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;

import java.util.List;

import practice.code.com.baseframework.R;
import practice.code.com.baseframework.model.entity.MessageEntity;

/**
 * Created by Administrator on 2017/5/11 0011.
 */

public class RefishRV extends BaseAdapter<MessageEntity.NewsBean> {
    public RefishRV(Context context, List<MessageEntity.NewsBean> datas) {
        super(context, R.layout.item_rv, datas);
    }

    @Override
    public void convert(ViewHolder holder, MessageEntity.NewsBean newsBean) {

        holder.setText(R.id.item_txt,newsBean.getAuthorid());

    }
}
