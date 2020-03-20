package cn.qd.peiwen.autolayout.attr;

import android.view.View;
import android.view.ViewGroup;


/**
 * Created by zhy on 15/12/5.
 */
public class MarginTopAttr extends AutoAttr {

    public MarginTopAttr(int pxVal) {
        super(pxVal);
    }

    @Override
    protected void execute(View view, int val) {
        if (!(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        lp.topMargin = val;
    }

    @Override
    public String toString() {
        return "MarginTopAttr{" + "pxVal=" + pxVal + '}';
    }
}
