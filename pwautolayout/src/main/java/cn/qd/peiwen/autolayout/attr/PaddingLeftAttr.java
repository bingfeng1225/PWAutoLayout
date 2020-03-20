package cn.qd.peiwen.autolayout.attr;

import android.view.View;


/**
 * Created by zhy on 15/12/5.
 */
public class PaddingLeftAttr extends AutoAttr {
    public PaddingLeftAttr(int pxVal) {
        super(pxVal);
    }

    @Override
    protected void execute(View view, int val) {
        int l = val;
        int t = view.getPaddingTop();
        int r = view.getPaddingRight();
        int b = view.getPaddingBottom();
        view.setPadding(l, t, r, b);
    }


    @Override
    public String toString() {
        return "PaddingLeftAttr{" + "pxVal=" + pxVal + '}';
    }
}
