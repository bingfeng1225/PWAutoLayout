package cn.qd.peiwen.autolayout.attr;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhy on 15/12/5.
 */
public class WidthAttr extends AutoAttr {
    public WidthAttr(int pxVal) {
        super(pxVal);
    }

    @Override
    protected void execute(View view, int val) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.width = val;
    }

    @Override
    public String toString() {
        return "WidthAttr{" + "pxVal=" + pxVal + '}';
    }
}
