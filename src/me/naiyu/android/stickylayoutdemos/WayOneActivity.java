package me.naiyu.android.stickylayoutdemos;

import me.naiyu.android.stickylayoutdemos.util.DataHelper;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class WayOneActivity extends Activity {

	private ListView mListView;
	
	private View mHeaderView;
	
	private View mListViewHeaderView;
	
	private int mMinHeaderHeight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_way_one);
		
		mMinHeaderHeight = -getResources().getDimensionPixelSize(R.dimen.header_height);
		
		initView();
	}
	
	private void initView() {
		mHeaderView = findViewById(R.id.header_view);
		initListView();
	}

	private void initListView() {
		mListView = (ListView) findViewById(R.id.lv_way_one);
		
		mListViewHeaderView = getLayoutInflater().inflate(R.layout.header_layout, mListView, false);
		mListView.addHeaderView(mListViewHeaderView);
		
		mListView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, DataHelper
						.getListViewItems(50)));
		
		
		mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				int scrollY = getScrollY();
				mHeaderView.setTranslationY(Math.max(-scrollY, mMinHeaderHeight));
				
			}
		});
		
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// 因为加了headerView，为了得到真是的position，所以需要减1
				position -= 1;
				Toast.makeText(WayOneActivity.this, "click on " + position, Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	public int getScrollY() {
        View c = mListView.getChildAt(0);
        if (c == null) {
            return 0;
        }

        int firstVisiblePosition = mListView.getFirstVisiblePosition();
        int top = c.getTop();

        int headerHeight = 0;
        if (firstVisiblePosition >= 1) {
            headerHeight = mListViewHeaderView.getHeight();
        }

        return -top + firstVisiblePosition * c.getHeight() + headerHeight;
    }

}
