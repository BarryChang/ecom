package com.zzy.ecom.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.app.Activity;
import android.widget.SimpleAdapter;

import com.zzy.ecom.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class InsideActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_activity);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        initMainNote();
        initAnswerList();
    }

    private void
    initMainNote()
    {
        ArrayList<HashMap<String, Object>> noteArrayList = new ArrayList<HashMap<String, Object>>();
        ListViewForScrollView notesList = (ListViewForScrollView)findViewById(R.id.inside_activity_main_note);

        // get time
        long time = System.currentTimeMillis();
        ArrayList<Object> resources = new ArrayList<>();
        resources.add(0, R.drawable.example_content);

        // add notes
        addMainNote(noteArrayList, R.drawable.example_head, "GodLike", time, "Good Morning",
                "What do you think is the best way of travelling is?B:I think aeroplane is by far the best way.A:Why do you think so?",
                resources, "1");

        SimpleAdapter mySimpleAdapter = new SimpleAdapter(this, noteArrayList, R.layout.note_outside_layout,
                new String[]{"note_outside_author_img","note_outside_author","note_outside_subtitle","note_outside_content_title","note_outside_content","note_outside_content_img","note_outside_like_number"},
                new int[]{R.id.note_outside_author_img,R.id.note_outside_author,R.id.note_outside_subtitle,R.id.note_outside_content_title,R.id.note_outside_content,R.id.note_outside_content_img,R.id.note_outside_like_number});
        notesList.setAdapter(mySimpleAdapter);
    }

    private void
    addMainNote(ArrayList<HashMap<String,Object>> list,
                Object headPicture, String userName,
                long time, String title, String content,
                ArrayList<Object> resources, String likeNumber)
    {
        // transfer time to a format style
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        String outputTime = format.format(date);

        // add note component
        HashMap<String, Object> itemContent = new HashMap<>();
        itemContent.put("note_outside_author_img",headPicture);
        itemContent.put("note_outside_author",userName);
        itemContent.put("note_outside_subtitle",outputTime);
        itemContent.put("note_outside_content_title", title);
        itemContent.put("note_outside_content", content);
        itemContent.put("note_outside_content_img", resources.get(0));
        itemContent.put("note_outside_like_number", likeNumber);
        list.add(itemContent);
    }

    private void
    initAnswerList()
    {
        ArrayList<HashMap<String, Object>> noteArrayList = new ArrayList<HashMap<String, Object>>();
        ListViewForScrollView notesList = (ListViewForScrollView)findViewById(R.id.inside_activity_list);

        // get time
        long time = System.currentTimeMillis();

        // add notes
        addAnswer(noteArrayList, R.drawable.example_head, "GodLike", time, "what does the fox say, ding, ding, ding, ding");
        addAnswer(noteArrayList, R.drawable.example_head, "GodLike", time, "what does the fox say, ding, ding, ding, ding");
        addAnswer(noteArrayList, R.drawable.example_head, "GodLike", time, "what does the fox say, ding, ding, ding, ding");
        addAnswer(noteArrayList, R.drawable.example_head, "GodLike", time, "what does the fox say, ding, ding, ding, ding");
        addAnswer(noteArrayList, R.drawable.example_head, "GodLike", time, "what does the fox say, ding, ding, ding, ding");
        addAnswer(noteArrayList, R.drawable.example_head, "GodLike", time, "what does the fox say, ding, ding, ding, ding");
        addAnswer(noteArrayList, R.drawable.example_head, "GodLike", time, "what does the fox say, ding, ding, ding, ding");
        addAnswer(noteArrayList, R.drawable.example_head, "GodLike", time, "what does the fox say, ding, ding, ding, ding");


        SimpleAdapter mySimpleAdapter = new SimpleAdapter(this, noteArrayList, R.layout.answer_layout,
                new String[]{"note_answer_author_img","note_answer_author","note_answer_subtitle","note_answer_content"},
                new int[]{R.id.note_answer_author_img,R.id.note_answer_author,R.id.note_answer_subtitle,R.id.note_answer_content});
        notesList.setAdapter(mySimpleAdapter);
    }

    private void
    addAnswer(ArrayList<HashMap<String,Object>> list,
              Object headPicture, String userName,
              long time, String content)
    {
        // transfer time to a format style
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        String outputTime = format.format(date);

        // add note component
        HashMap<String, Object> itemContent = new HashMap<>();
        itemContent.put("note_answer_author_img",headPicture);
        itemContent.put("note_answer_author",userName);
        itemContent.put("note_answer_subtitle",outputTime);
        itemContent.put("note_answer_content", content);
        list.add(itemContent);
    }

}
