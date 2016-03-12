package com.zzy.ecom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class ActivityFragment extends Fragment {

    private View view;

    @Override
    public View
    onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_activity,null);

        // list
        this.setListView();

        // textview
        this.setTextView();

        return view;
    }

    private void
    setListView()
    {
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
        ListViewForScrollView listView = (ListViewForScrollView)view.findViewById(R.id.joining_activity_list);

        // get time
        long time = System.currentTimeMillis();
        ArrayList<Object> resources = new ArrayList<>();
        resources.add(0, R.drawable.example_content);

        addActivity(arrayList, R.drawable.example_head, "GodLike", time, "Good Morning",
                "What do you think is the best way of travelling is?B:I think aeroplane is by far the best way.A:Why do you think so?",
                "3h", "1");
        addActivity(arrayList, R.drawable.example_head, "GodLike", time, "Good Morning",
                "What do you think is the best way of travelling is?B:I think aeroplane is by far the best way.A:Why do you think so?",
                "2m", "3");
        addActivity(arrayList, R.drawable.example_head, "GodLike", time, "Good Morning",
                "What do you think is the best way of travelling is?B:I think aeroplane is by far the best way.A:Why do you think so?",
                "1d", "2");

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), arrayList, R.layout.activity_outside_layout,
                new String[]{"activity_outside_author_img","activity_outside_author","activity_outside_subtitle","activity_outside_content_title","activity_outside_content","activity_outside_resttime","activity_outside_join_number"},
                new int[]{R.id.activity_outside_author_img,R.id.activity_outside_author,R.id.activity_outside_subtitle,R.id.activity_outside_content_title,R.id.activity_outside_content,R.id.activity_outside_resttime,R.id.activity_outside_join_number});
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), InsideActivity.class);
                startActivity(intent);
            }
        });
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

    private void
    setTextView()
    {
        LinearLayout layoutView = (LinearLayout)view.findViewById(R.id.check_already_done);
        layoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlreadyDoneActivities.class);
                startActivity(intent);
            }
        });
    }
}
