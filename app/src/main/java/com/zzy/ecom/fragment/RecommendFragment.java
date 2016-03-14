package com.zzy.ecom.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.zzy.ecom.R;

import java.util.ArrayList;
import java.util.List;


public class RecommendFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_recommend, null);

        initListView();

        return view;
    }

    private void
    initListView()
    {
        final List<String> list = new ArrayList<>();
        list.add("用户雷龙老大刚刚发起了一个活动,点击查看详情");
        list.add("用户吞天刚刚报名参加了用户雷龙老大发起的活动");
        list.add("南开大能0s0刚刚发表了一个帖子");
        list.add("怒怒啦啦啦阿拉刚刚发表了一个帖子");
        list.add("不阿萨德开发历史发起了一个活动,点击查看详情");

        ListView listView = (ListView)view.findViewById(R.id.recommend_list);
        ListAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, list);
        listView.setAdapter(adapter);
    }

}
