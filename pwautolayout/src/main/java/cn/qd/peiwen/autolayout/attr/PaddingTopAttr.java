package cn.qd.peiwen.autolayout.attr;

import android.view.View;


/**
 * Created by zhy on 15/12/5.
 */
public class PaddingTopAttr extends AutoAttr {
    public PaddingTopAttr(int pxVal) {
        super(pxVal);
    }

    @Override
    protected void execute(View view, int val) {
        int l = view.getPaddingLeft();
        int t = val;
        int r = view.getPaddingRight();
        int b = view.getPaddingBottom();
        view.setPadding(l, t, r, b);
    }

    @Override
    public String toString() {
        return "PaddingTopAttr{" + "pxVal=" + pxVal + '}';
    }
}
