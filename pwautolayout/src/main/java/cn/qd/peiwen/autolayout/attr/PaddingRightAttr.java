package cn.qd.peiwen.autolayout.attr;

import android.view.View;


/**
 * Created by zhy on 15/12/5.
 */
public class PaddingRightAttr extends AutoAttr {
    public PaddingRightAttr(int pxVal) {
        super(pxVal);
    }

    @Override
    protected void execute(View view, int val) {
        int l = view.getPaddingLeft();
        int t = view.getPaddingTop();
        int r = val;
        int b = view.getPaddingBottom();
        view.setPadding(l, t, r, b);
    }


    @Override
    public String toString() {
        return "PaddingRightAttr{" + "pxVal=" + pxVal + '}';
    }
}
