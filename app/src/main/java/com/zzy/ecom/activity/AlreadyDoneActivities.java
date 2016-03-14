package com.zzy.ecom.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.app.Activity;
import android.widget.SimpleAdapter;

import com.zzy.ecom.R;
import com.zzy.ecom.customview.ListViewForScrollView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class AlreadyDoneActivities extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_done_activities);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        this.setListView();
    }

    private void
    setListView()
    {
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
        ListViewForScrollView listView = (ListViewForScrollView)findViewById(R.id.already_activity_list);

        // get time
        long time = System.currentTimeMillis();
        ArrayList<Object> resources = new ArrayList<>();
        resources.add(0, R.drawable.example_content);

        addActivity(arrayList, R.drawable.example_head, "GodLike", time, "Good Morning",
                "What do you think is the best way of travelling is?B:I think aeroplane is by far the best way.A:Why do you think so?",
                "0", "10");
        addActivity(arrayList, R.drawable.example_head, "GodLike", time, "Good Morning",
                "What do you think is the best way of travelling is?B:I think aeroplane is by far the best way.A:Why do you think so?",
                "0", "23");
        addActivity(arrayList, R.drawable.example_head, "GodLike", time, "Good Morning",
                "What do you think is the best way of travelling is?B:I think aeroplane is by far the best way.A:Why do you think so?",
                "0", "9");

        SimpleAdapter adapter = new SimpleAdapter(this, arrayList, R.layout.activity_outside_layout,
                new String[]{"activity_outside_author_img","activity_outside_author","activity_outside_subtitle","activity_outside_content_title","activity_outside_content","activity_outside_resttime","activity_outside_join_number"},
                new int[]{R.id.activity_outside_author_img,R.id.activity_outside_author,R.id.activity_outside_subtitle,R.id.activity_outside_content_title,R.id.activity_outside_content,R.id.activity_outside_resttime,R.id.activity_outside_join_number});
        listView.setAdapter(adapter);
    }

    private void
    addActivity(ArrayList<HashMap<String,Object>> list,
                Object headPicture, String userName,
                long time, String title, String content,
                String restTime, String joinNumber)
    {
        // transfer time to a format style
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        String outputTime = format.format(date);

        // add note component
        HashMap<String, Object> itemContent = new HashMap<>();
        itemContent.put("activity_outside_author_img",headPicture);
        itemContent.put("activity_outside_author",userName);
        itemContent.put("activity_outside_subtitle",outputTime);
        itemContent.put("activity_outside_content_title", title);
        itemContent.put("activity_outside_content", content);
        itemContent.put("activity_outside_resttime", restTime);
        itemContent.put("activity_outside_join_number", joinNumber);
        list.add(itemContent);
    }

}
