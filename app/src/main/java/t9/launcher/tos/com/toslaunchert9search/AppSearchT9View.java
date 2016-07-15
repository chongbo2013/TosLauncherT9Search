package t9.launcher.tos.com.toslaunchert9search;

import android.content.Context;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * T9拨号盘 3*4 T9拨号盘
 * Created by ferris on 2016/7/15.
 */
public class AppSearchT9View extends ViewGroup {
    private int col=3;
    private int row=4;
    public AppSearchT9View(Context context) {
        super(context);
        init(context,null);
    }

    public AppSearchT9View(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }


    public  void init(Context context,AttributeSet attrs){
        setPadding(25,25,25,25);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //measure每个图标的大小
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int height = View.MeasureSpec.getSize(heightMeasureSpec);

        int paddingLeft=getPaddingLeft();
        int paddingRight=getPaddingRight();
        int padingTop=getPaddingTop();
        int padingBottom=getPaddingBottom();
        int gridWidth=(width-paddingLeft-paddingRight)/col;
        int gridHeight=(height-padingTop-padingBottom)/row;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View v = getChildAt(i);
            if (v != null) {
                int childWidthSpec = View.MeasureSpec.makeMeasureSpec(gridWidth, widthMode);
                int childHeightSpec = View.MeasureSpec.makeMeasureSpec(gridHeight, heightMode);
                v.measure(childWidthSpec, childHeightSpec);
            }
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // layout child
        int paddingLeft=getPaddingLeft();
        int paddingRight=getPaddingRight();
        int padingTop=getPaddingTop();
        int padingBottom=getPaddingBottom();
        int releaseWidth=(getMeasuredWidth()-paddingLeft-paddingRight)/col;
        int releaseHeiht=(getMeasuredHeight()-padingTop-padingBottom)/row;
        int iconOffsetX=paddingLeft;
        int iconOffsetY=padingTop;
        int left;
        int top;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View v = getChildAt(i);
            //行
            int currentRow=i/col;
            //列  row=1 col=4
            int currentCol=i%col;
            left=currentCol*releaseWidth+iconOffsetX;
            top=currentRow*releaseHeiht+iconOffsetY;
            if (v != null) {
                v.layout(left, top, left+releaseWidth, top+releaseHeiht);
            }
        }
    }


}
