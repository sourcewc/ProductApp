package com.jainjang.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by Shin on 2016-11-28.
 * qr코드 스캔후 리뷰버튼클릭시 이쪽으로
 */

public class ReviewActivity extends Activity {
    private RecyclerView reviewRecyclerView;   //리사이클러뷰
    private RecyclerView.Adapter reviewAdapter;    //어댑터
    private RecyclerView.LayoutManager layoutManager;   //레이아웃 매니저 수직
    private ArrayList<ReviewData> reviewData;

    String signedUser="1";  //사람 상태 0타인 1 작성자 그외 관리자
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_review);

        reviewRecyclerView = (RecyclerView) findViewById(R.id.review_recycler);

        layoutManager = new LinearLayoutManager(this);
        reviewRecyclerView.setLayoutManager(layoutManager);

        reviewData = new ArrayList<>();
        reviewAdapter = new ReviewAdapter(reviewData);
        reviewRecyclerView.setAdapter(reviewAdapter);

        reviewData.add(new ReviewData("헬로헬로","이거좋군요"));
        reviewData.add(new ReviewData("좋아요","역시 최고네요"));



    }

    class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {
        private ArrayList<ReviewData> reviewDataset;

        public ReviewAdapter(ArrayList<ReviewData> reviewData) {
            reviewDataset =reviewData;
        }

        @Override   //아이템뷰 선언
        public ReviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item,parent,false);
            ReviewAdapter.ViewHolder viewHolder=new ReviewAdapter.ViewHolder(v);
            return viewHolder;
        }

        @Override       //bindviewholder에서 아이템 클릭이벤트등 구현
        public void onBindViewHolder(ReviewAdapter.ViewHolder holder, int position) {
            holder.nickName.setText(reviewDataset.get(position).nickName);
            holder.review.setText(reviewDataset.get(position).reivew);

            //이미지 옵션버튼
            holder.optionMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnClick(view);
                }
            });
        }

        @Override
        public int getItemCount() {
            return reviewDataset.size();
        }

        //뷰홀더에서 findviewbyid 할수있다. 요소편집 이쪽에서
        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView nickName;
            public TextView review;
            public ImageView optionMenu;

            public ViewHolder(View view) {
                super(view);
                nickName = (TextView) view.findViewById(R.id.nickname);
                review = (TextView) view.findViewById(R.id.review);
                optionMenu = (ImageView)view.findViewById(R.id.optionMenu);

                //작성자인지 아닌지 확인 1작성자 0타인 그외(관리자) 서버연결 확인필요
                switch (signedUser) {
                    case "1":
                        optionMenu.setVisibility(View.VISIBLE);
                        break;
                    case "0":
                        optionMenu.setVisibility(View.GONE);
                        break;
                    default:
                        optionMenu.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    class ReviewData {
        public String nickName;
        public String reivew;

        public ReviewData( String nickName, String reivew) {
            this.nickName = nickName;
            this.reivew = reivew;
        }
    }

    //옵션 생성, 셀렉트    menu 바꿔야됨
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.qr_result_menu, menu);
        return true;

    }
    public void mOnClick(View v) {
        PopupMenu popup = new PopupMenu(this,v);
        MenuInflater inflater =popup.getMenuInflater();
        Menu menu= popup.getMenu();
        inflater.inflate(R.menu.qr_result_menu,menu);

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_itemqna:
                        return true;
                    case R.id.menu_request_stamp:
                        return true;
                    default:
                        return false;
                }
            }
        });
        popup.show();
    }

    /////////////////


}
