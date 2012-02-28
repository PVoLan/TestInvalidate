package test.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class TestInvalidateActivity extends Activity {
	
	
	int screenW;
	int screenH;
	int itemW = 50;
	int itemH = 50;
	
	int intemsInRow = 6;
	int rows = 100;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        
        
        ScrollView scrollview = new ScrollView(this);
        scrollview.setBackgroundColor(Color.RED);
        scrollview.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        setContentView(scrollview);
        
        
        LinearLayout rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        rootLayout.setBackgroundColor(Color.YELLOW);
        scrollview.addView(rootLayout);
                
        
        final BenchmarkedLinearLayout contentHolder = new BenchmarkedLinearLayout(this);
        contentHolder.setOrientation(LinearLayout.VERTICAL);
        contentHolder.setBackgroundColor(Color.YELLOW);
        rootLayout.addView(contentHolder);
        
        
        final Button b = new Button(this);
        b.setText("qwerty");
        b.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				//case 1
				//b.setVisibility(Button.GONE);
				//end case 1
				
				//case 2
				//linear1.setPadding(50, 50, 50, 50);
				//end case 2
				
				//case 3
				LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( (LinearLayout.LayoutParams)contentHolder.getLayoutParams() );
				lp.setMargins(0, 50, 0, 0);				
				contentHolder.setLayoutParams(lp);
				//end case 3
				
			}
		});
        rootLayout.addView(b);
        
        
        
        TextView longTextView = new TextView(this);
        longTextView.setLayoutParams(new BenchmarkedLinearLayout.LayoutParams(100,100));
        longTextView.setText("zxc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc\nc");        
        contentHolder.addView(longTextView);
        
        
    }
    
    
    
    class BenchmarkedLinearLayout extends LinearLayout{
    	public BenchmarkedLinearLayout(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
    	public void invalidate() {
    		
			Log.i("-----------", "invalidate");
    		super.invalidate();
    		Log.i("-----------", "/invalidate");
    	}

		
		@Override
		public void draw(Canvas canvas) {
			Log.i("-----------", "draw");
			super.draw(canvas);
			Log.i("-----------", "/draw");
		}
		
		
		@Override
		protected void dispatchDraw(Canvas canvas) {
			Log.i("-----------", "dispatchDraw");
			super.dispatchDraw(canvas);
			Log.i("-----------", "/dispatchDraw");
		}
		
		
		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
			Log.i("-----------", "onLayout");
			super.onLayout(changed, l, t, r, b);
			Log.i("-----------", "/onLayout");
		}
		
		@Override
		protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
			Log.i("-----------", "onMeasure");
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
			Log.i("-----------", "/onMeasure");
		}
		
		@Override
		public void requestLayout() {
			Log.i("-----------", "requestLayout");
			super.requestLayout();
			Log.i("-----------", "/requestLayout");
		}
		
		
    }
}