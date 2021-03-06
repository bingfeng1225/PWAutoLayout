package cn.qd.peiwen.autolayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import cn.qd.peiwen.autolayout.layout.AutoCardView;
import cn.qd.peiwen.autolayout.layout.AutoFrameLayout;
import cn.qd.peiwen.autolayout.layout.AutoLinearLayout;
import cn.qd.peiwen.autolayout.layout.AutoRelativeLayout;
import cn.qd.peiwen.mvp.MVPActivity;


/**
 * Created by zhy on 15/11/19.
 */
public abstract class AutoLayoutActivity extends MVPActivity
{
    private static final String LAYOUT_LINEARLAYOUT = "LinearLayout";
    private static final String LAYOUT_FRAMELAYOUT = "FrameLayout";
    private static final String LAYOUT_RELATIVELAYOUT = "RelativeLayout";
    private static final String LAYOUT_CARDVIEW = "android.support.v7.widget.CardView";

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs)
    {
        View view = null;
        if (name.equals(LAYOUT_FRAMELAYOUT))
        {
            view = new AutoFrameLayout(context, attrs);
        }

        if (name.equals(LAYOUT_LINEARLAYOUT))
        {
            view = new AutoLinearLayout(context, attrs);
        }

        if (name.equals(LAYOUT_RELATIVELAYOUT))
        {
            view = new AutoRelativeLayout(context, attrs);
        }

        if(name.equals(LAYOUT_CARDVIEW)) {
            view = new AutoCardView(context,attrs);
        }

        if (view != null) return view;

        return super.onCreateView(name, context, attrs);
    }

}
