package com.jainjang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jainjang.R;

import java.util.ArrayList;

/**
 * Created by Shin on 2016-12-01.
 * 팔로우 리스트를 확인할수있는 액티비티
 */

public class FollowActivity extends Activity {
    private RecyclerView followRecyclerView;   //리사이클러뷰
    private RecyclerView.Adapter followAdapter;    //어댑터
    private RecyclerView.LayoutManager layoutManager;   //레이아웃 매니저 수직
    private ArrayList<FollowData> followData;
    TextView followerCount; //follower + streamer
    int follower = 4;    //팔로워수
    int streamer = 2;     //유입자 수   파싱형식 String일수도

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.follower_list);

        followerCount=(TextView)findViewById(R.id.follower_count);
        followRecyclerView = (RecyclerView) findViewById(R.id.follower_list);   //리사이클러뷰

        layoutManager = new LinearLayoutManager(this);
        followRecyclerView.setLayoutManager(layoutManager);     //매니저 세팅

        followData = new ArrayList<>();     //데이터 리스트 선언
        followAdapter = new FollowAdapter(followData);  //데이터 어댑터 연결
        followRecyclerView.setAdapter(followAdapter);   //리사이클러뷰 어댑터 연결

        followData.add(new FollowData("헬로헬로"));     //요소추가 ->get요청시에는 다름
        followData.add(new FollowData("좋아요"));

        followerCount.setText(String.valueOf(streamer) + "/" + String.valueOf(follower));
    }
}

class FollowAdapter extends RecyclerView.Adapter<FollowAdapter.ViewHolder> {
    private ArrayList<FollowData> followDataset;

    public FollowAdapter(ArrayList<FollowData> followData) {
        followDataset = followData;
    }

    @Override   //아이템뷰 선언
    public FollowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.follower_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override       //bindviewholder에서 아이템 클릭이벤트등 구현
    public void onBindViewHolder(FollowAdapter.ViewHolder holder, int position) {
        holder.followNick.setText(followDataset.get(position).followNick);
    }

    @Override
    public int getItemCount() {
        return followDataset.size();
    }

    //뷰홀더에서 findviewbyid 할수있다. 요소편집 이쪽에서
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView followNick;

        public ViewHolder(View view) {
            super(view);
            followNick = (TextView) view.findViewById(R.id.follower_nickname);
        }
    }
}

class FollowData {
    public String followNick;

    public FollowData(String followNick) {
        this.followNick = followNick;
    }
}

