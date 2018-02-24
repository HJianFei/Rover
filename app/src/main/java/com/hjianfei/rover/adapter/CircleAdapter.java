package com.hjianfei.rover.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hjianfei.rover.R;
import com.hjianfei.rover.entity.CircleGridModel;
import com.hjianfei.rover.wedgit.CircleLayoutImpl;

import java.util.List;

/**
 * Created by HJianFei on 2018-02-24.
 */

public class CircleAdapter extends RecyclerView.Adapter<CircleAdapter.ViewHolder> {

    private Context mContext;
    private List<CircleGridModel> mList;
    protected LayoutInflater inflater;

    public CircleAdapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    public void setList(List<CircleGridModel> list) {
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = inflater.inflate(R.layout.item_circle_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.layout.setIsShowAll(mList.get(position).isShowAll);
        holder.layout.setUrlList(mList.get(position).urlList);
    }

    @Override
    public int getItemCount() {
        return getListSize(mList);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleLayoutImpl layout;

        public ViewHolder(View itemView) {
            super(itemView);
            layout = (CircleLayoutImpl) itemView.findViewById(R.id.layout_circle_grid);
        }
    }

    private int getListSize(List<CircleGridModel> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        return list.size();
    }
}
