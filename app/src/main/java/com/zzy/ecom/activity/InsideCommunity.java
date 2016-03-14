package com.zzy.ecom.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.zzy.ecom.R;
import com.zzy.ecom.entities.Community;
import com.zzy.ecom.entities.TransApp;

import java.util.ArrayList;
import java.util.List;

public class InsideCommunity extends Activity {

    private Community community;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_community);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //community = ((TransApp)getApplication()).getCommunity();
        community = new Community();

        TextView communityName = (TextView)findViewById(R.id.inside_community_name);
        communityName.setText(community.getCommunityName());

        TextView location = (TextView)findViewById(R.id.inside_community_location);
        location.setText(community.getLocation());

        TextView intro = (TextView)findViewById(R.id.inside_community_introduction);
        intro.setText(community.getIntro());

        initListView();
    }

    private void
    initListView()
    {
        final List<String> list = new ArrayList<>();
        list.add("雷龙老大");
        list.add("吞天");
        list.add("南开大能0s0");
        list.add("怒怒啦啦啦阿拉");
        list.add("不阿萨德开发历史");

        ListView listView = (ListView)findViewById(R.id.inside_community_members);
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);
        listView.setAdapter(adapter);
    }

}
