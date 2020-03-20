package cn.qd.peiwen.autolayout.attr;

import android.view.View;


/**
 * Created by zhy on 15/12/5.
 */
public class PaddingBottomAttr extends AutoAttr {
    public PaddingBottomAttr(int pxVal) {
        super(pxVal);
    }

    @Override
    protected void execute(View view, int val) {
        int l = view.getPaddingLeft();
        int t = view.getPaddingTop();
        int r = view.getPaddingRight();
        int b = val;
        view.setPadding(l, t, r, b);
    }


    @Override
    public String toString() {
        return "PaddingBottomAttr{" + "pxVal=" + pxVal + '}';
    }
}
