package com.jainjang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shin on 2016-11-24.
 * 메인탭의 히스토리 (공유이미지) 클릭시 넘어오는 액티비티
 * 리사이클러뷰 구성으로 서버에서 파싱하는 데이터에 따라 다른 어댑터를 구현해야할
 * 필요가 있다.
 */
public class HistoryActivity extends Activity {
    private RecyclerView historyRecyclerView;   //리사이클러뷰
    private RecyclerView.Adapter historyAdapter;    //어댑터
    private RecyclerView.LayoutManager layoutManager;   //레이아웃 매니저 수직
    private ArrayList<HistoryData> historyData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);

        historyRecyclerView = (RecyclerView) findViewById(R.id.history_reclyerview);

        layoutManager = new LinearLayoutManager(this);
        historyRecyclerView.setLayoutManager(layoutManager);

        historyData = new ArrayList<>();
        historyAdapter = new HistoryAdapter(historyData);
        historyRecyclerView.setAdapter(historyAdapter);

        historyData.add(new HistoryData(R.drawable.friendsrequest,"이벤트","45"));
        historyData.add(new HistoryData(R.drawable.friendsrequest,"좋아요","22"));
    }
}

class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private ArrayList<HistoryData> historyDataset;

    public HistoryAdapter(ArrayList<HistoryData> historyData) {
        historyDataset =historyData;
    }

    @Override   //아이템뷰 선언
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override       //bindviewholder에서 아이템 클릭이벤트등 구현
    public void onBindViewHolder(HistoryAdapter.ViewHolder holder, int position) {
//        final HistoryData myStoryEntityObject = historyDataset.get(position);
        holder.historyImage.setImageResource(historyDataset.get(position).image);
        holder.categoryText.setText(historyDataset.get(position).categoryText);
        holder.countText.setText(historyDataset.get(position).countText);
    }

    @Override
    public int getItemCount() {
        return historyDataset.size();
    }

    //뷰홀더에서 findviewbyid 할수있다. 요소편집 이쪽에서
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView historyImage;
        public TextView categoryText;
        public TextView countText;

        public ViewHolder(View view) {
            super(view);
            historyImage = (ImageView) view.findViewById(R.id.history_img);
            categoryText = (TextView) view.findViewById(R.id.history_text);
            countText = (TextView) view.findViewById(R.id.share_count);
        }
    }
}

//히스토리 어댑터에 쓸 데이터 (서버연결시에는 이미지를 string형으로 바꿔주어야한다.)
//image=상품이미지 categoryText = 카테고리 종류(매장,좋아요 등) countText =공유수 카운트
class HistoryData {
    public int image;
    public String categoryText;
    public String countText;

    public HistoryData(int image, String categoryText, String countText) {
        this.image = image;
        this.categoryText = categoryText;
        this.countText = countText;
    }
}
