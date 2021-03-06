package com.zzy.ecom.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.zzy.ecom.R;
import com.zzy.ecom.activity.InsideCommunity;
import com.zzy.ecom.activity.InsideNote;
import com.zzy.ecom.customview.ListViewForScrollView;
import com.zzy.ecom.entities.Community;
import com.zzy.ecom.entities.TransApp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class PlazaFragment extends Fragment {

    private View view;
    private Community community;

    @Override
    public View
    onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_plaza, null);

        community = ((TransApp)getActivity().getApplication()).getCommunity();

        // title with Community name
        this.setCommunityName(community.getCommunityName());

        // Community bkg
        this.setCommunityBkg(community.getBkgPicture());

        // statistics
        this.initStatistics();

        // notes
        this.initPlazaNotes();

        // scroll view
        ScrollView scrollView = (ScrollView)view.findViewById(R.id.plaza_scroll_view);
        scrollView.scrollTo(0, 0);

        return view;
    }

    private void
    setCommunityName(String name)
    {
        LinearLayout titleBar = (LinearLayout)view.findViewById(R.id.plaza_title_bar);
        titleBar.setOnClickListener(listener);
        TextView communityName = (TextView)view.findViewById(R.id.plaza_community_name);
        communityName.setText(name);
    }

    private void
    setCommunityBkg(int img)
    {
        ImageView communityBkg = (ImageView)view.findViewById(R.id.community_bkg);
        communityBkg.setImageResource(img);
        communityBkg.setOnClickListener(listener);
    }

    private void
    initPlazaNotes()
    {
        ArrayList<HashMap<String, Object>> noteArrayList = new ArrayList<HashMap<String, Object>>();
        ListViewForScrollView notesList = (ListViewForScrollView)view.findViewById(R.id.plaza_notes);

        // get time
        long time = System.currentTimeMillis();
        ArrayList<Object> resources = new ArrayList<>();
        resources.add(0, R.drawable.example_content);

        // add notes
        addNote(noteArrayList, R.drawable.example_head, "GodLike", time, "Good Morning",
                "What do you think is the best way of travelling is?B:I think aeroplane is by far the best way.A:Why do you think so?",
                resources, "1");
        addNote(noteArrayList, R.drawable.example_head, "GodLike", time, "Good Morning",
                "What do you think is the best way of travelling is?B:I think aeroplane is by far the best way.A:Why do you think so?",
                resources, "2");
        addNote(noteArrayList, R.drawable.example_head, "GodLike", time, "Good Morning",
                "What do you think is the best way of travelling is?B:I think aeroplane is by far the best way.A:Why do you think so?",
                resources, "10");

        SimpleAdapter mySimpleAdapter = new SimpleAdapter(getActivity(), noteArrayList, R.layout.note_outside_layout,
                new String[]{"note_outside_author_img","note_outside_author","note_outside_subtitle","note_outside_content_title","note_outside_content","note_outside_content_img","note_outside_like_number"},
                new int[]{R.id.note_outside_author_img,R.id.note_outside_author,R.id.note_outside_subtitle,R.id.note_outside_content_title,R.id.note_outside_content,R.id.note_outside_content_img,R.id.note_outside_like_number});
        notesList.setAdapter(mySimpleAdapter);

        notesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), InsideNote.class);
                startActivity(intent);
            }
        });
    }

    private void
    addNote(ArrayList<HashMap<String,Object>> list,
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
    initStatistics()
    {
        TextView notesNumber = (TextView)view.findViewById(R.id.notes_amount_number);
        notesNumber.setText(String.valueOf(community.getNotesAmount()));
        TextView usersNumber = (TextView)view.findViewById(R.id.current_user_number);
        usersNumber.setText(String.valueOf(community.getMemberAmount()));
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), InsideCommunity.class);
            startActivity(intent);
        }
    };
}
