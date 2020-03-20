package cn.qd.peiwen.autolayout.attr;

import android.view.View;
import android.view.ViewGroup;


/**
 * Created by zhy on 15/12/5.
 */
public class MarginAttr extends AutoAttr {

    public MarginAttr(int pxVal) {
        super(pxVal);
    }

    @Override
    public void apply(View view) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            super.apply(view);
        }
    }

    @Override
    protected void execute(View view, int val) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        lp.leftMargin = lp.rightMargin = lp.topMargin = lp.bottomMargin = val;
    }

    @Override
    public String toString() {
        return "MarginAttr{" + "pxVal=" + pxVal + '}';
    }
}
