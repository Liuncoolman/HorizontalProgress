package com.liun.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // 引用
        HorizontalProgressViewModel model = new HorizontalProgressViewModel();

        model.setViewUp(this, recyclerView, getProgressList());
    }

    /**
     * 模拟节点数据
     * node1.nodeStatus: 0 已完成状态  1正在处理状态  -1待处理状态
     *
     * @return
     */
    private List<Node> getProgressList() {
        List<Node> list = new ArrayList<>();

        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();

        node1.nodeName = "提交申请";
        node1.nodeStatus = 0;

        node2.nodeName = "等待回寄";
        node2.nodeStatus = 0;

        node3.nodeName = "已回寄";
        node3.nodeStatus = 0;

        node4.nodeName = "等待退款";
        node4.nodeStatus = 1;

        node5.nodeName = "完成";
        node5.nodeStatus = -1;


        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        return list;

    }
}
