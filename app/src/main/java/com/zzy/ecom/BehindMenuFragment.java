package com.zzy.ecom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BehindMenuFragment extends Fragment {

    private View view;

    @Override
    public View
    onCreateView(LayoutInflater inflater, ViewGroup container,
                 Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_behind_menu, container, false);
            initListView();
        }
        return view;
    }

    private void
    initListView()
    {
        final List<String> list = new ArrayList<>();
        list.add("个人资料设置");
        list.add("新消息通知");
        list.add("隐私设置");
        list.add("空间清理");
        list.add("退出登录");

        ListView listView = (ListView)view.findViewById(R.id.behind_menu_listview);
        ListAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (list.get(position).equals("个人资料设置")) {
                    Intent intent = new Intent(getActivity(), UserSetting.class);
                    startActivity(intent);
                }
                if (list.get(position).equals("新消息通知")) {
                    Intent intent = new Intent(getActivity(), UserSetting.class);
                    startActivity(intent);
                }
                if (list.get(position).equals("隐私设置")) {
                    Intent intent = new Intent(getActivity(), UserSetting.class);
                    startActivity(intent);
                }
                if (list.get(position).equals("空间清理")) {
                    Intent intent = new Intent(getActivity(), UserSetting.class);
                    startActivity(intent);
                }
                if (list.get(position).equals("退出登录")) {
                    Intent intent = new Intent(getActivity(), UserSetting.class);
                    startActivity(intent);
                }
            }
        });
    }
}
