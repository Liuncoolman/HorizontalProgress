package com.liun.example;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Description :取消订单处理进度
 * Author : Liun
 * Date   : 2016 16/9/7 15:39.
 * Email  : liun_coolman@foxmail.com
 */
public class HorizontalProgressListAdapter extends
        RecyclerView.Adapter<HorizontalProgressListAdapter.OrderProgressViewHolder> {

    private final List<Node> list;

    public HorizontalProgressListAdapter(List<Node> list) {
        this.list = list;
    }

    @Override
    public OrderProgressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.node_item,
                parent,
                false
        );
        OrderProgressViewHolder holder = new OrderProgressViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public void onBindViewHolder(OrderProgressViewHolder holder, int position) {
        Node node = list.get(position);
        if (position == 0) {
            // 第一个节点:隐藏line
            holder.leftLine.setVisibility(View.INVISIBLE);
        }
        if (position == list.size() - 1) {
            // 最后一个隐藏line
            holder.rightLine.setVisibility(View.INVISIBLE);
            holder.middleLine.setVisibility(View.INVISIBLE);
        }
        if (node.nodeStatus == 0) {
            // 已处理
            holder.nodeImage.setBackgroundResource(R.mipmap.progress_finish);
            holder.rightLine.setBackgroundResource(R.color.red);

        } else if (node.nodeStatus == 1) {
            // 正在处理
            holder.nodeImage.setBackgroundResource(R.mipmap.progress_select);
            holder.rightLine.setBackgroundResource(R.color.grey);
            holder.middleLine.setBackgroundResource(R.color.grey);
        } else if (node.nodeStatus == -1) {
            // 待处理
            holder.nodeImage.setBackgroundResource(R.mipmap.progress_unselect);
            holder.leftLine.setBackgroundResource(R.color.grey);
            holder.rightLine.setBackgroundResource(R.color.grey);
            holder.middleLine.setBackgroundResource(R.color.grey);
        }
        holder.nodeName.setText(node.nodeName);

    }

    class OrderProgressViewHolder extends RecyclerView.ViewHolder {
        public TextView leftLine,rightLine,middleLine,nodeName;
        public ImageView nodeImage;
        public OrderProgressViewHolder(View itemView) {
            super(itemView);

            // 节点左边的线
            leftLine = (TextView) itemView.findViewById(R.id.left_line);
            // 节点右边的线
            rightLine = (TextView) itemView.findViewById(R.id.right_line);
            // 节点与节点中间的线
            middleLine = (TextView) itemView.findViewById(R.id.middle_line);
            // 节点下面文字
            nodeName = (TextView) itemView.findViewById(R.id.nodeName);
            // 节点图片
            nodeImage = (ImageView) itemView.findViewById(R.id.image);
        }

    }


}
