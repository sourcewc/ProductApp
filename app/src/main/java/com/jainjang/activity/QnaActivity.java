package com.jainjang.activity;

import android.app.Activity;
import android.os.Bundle;
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
 * qr코드 스캔후 qna 버튼 클릭시 이쪽으로
 * 대댓글 기능 xml , 기능구현해야됨
 */

public class QnaActivity extends Activity {

    private RecyclerView qnaRecyclerView;   //리사이클러뷰
    private RecyclerView.Adapter qnaAdapter;    //어댑터
    private RecyclerView.LayoutManager layoutManager;   //레이아웃 매니저 수직
    private ArrayList<QnaData> qnaData;
    String signedUser="1";  //사람 상태 0타인 1 작성자 그외 관리자

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_qna);


    }

    class QnaAdapter extends RecyclerView.Adapter<QnaAdapter.ViewHolder> {
        private ArrayList<QnaData> qnaDataset;

        public QnaAdapter(ArrayList<QnaData> reviewData) {
            qnaDataset =qnaData;
        }

        @Override   //아이템뷰 선언
        public QnaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item,parent,false);
            QnaAdapter.ViewHolder viewHolder=new QnaActivity.QnaAdapter.ViewHolder(v);
            return viewHolder;
        }

        @Override       //bindviewholder에서 아이템 클릭이벤트등 구현
        public void onBindViewHolder(QnaAdapter.ViewHolder holder, int position) {
            holder.nickName.setText(qnaDataset.get(position).nickName);
            holder.review.setText(qnaDataset.get(position).qna);

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
            return qnaDataset.size();
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

    //옵션 생성, 셀렉트
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

        //메뉴 xml 바꾸고
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
class QnaData {
    public String nickName;
    public String qna;

    public QnaData(String nickName, String qna) {
        this.nickName = nickName;
        this.qna = qna;
    }
}




