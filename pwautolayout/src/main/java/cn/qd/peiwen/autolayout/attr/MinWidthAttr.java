package cn.qd.peiwen.autolayout.attr;

import android.view.View;

/**
 * Created by zhy on 15/12/24.
 */
public class MinWidthAttr extends AutoAttr {
    public MinWidthAttr(int pxVal) {
        super(pxVal);
    }

    @Override
    protected void execute(View view, int val) {
        view.setMinimumWidth(val);
    }


    @Override
    public String toString() {
        return "MinWidthAttr{" + "pxVal=" + pxVal + '}';
    }
}
