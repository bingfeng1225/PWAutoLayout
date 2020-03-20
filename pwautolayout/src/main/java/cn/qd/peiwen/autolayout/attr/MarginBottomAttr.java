package cn.qd.peiwen.autolayout.attr;

import android.view.View;
import android.view.ViewGroup;


/**
 * Created by zhy on 15/12/5.
 */
public class MarginBottomAttr extends AutoAttr {
    public MarginBottomAttr(int pxVal) {
        super(pxVal);
    }

    @Override
    protected void execute(View view, int val) {
        if (!(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        lp.bottomMargin = val;
    }

    @Override
    public String toString() {
        return "MarginBottomAttr{" + "pxVal=" + pxVal + '}';
    }
}
