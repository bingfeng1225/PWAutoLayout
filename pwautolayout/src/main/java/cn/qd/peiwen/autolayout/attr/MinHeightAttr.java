package cn.qd.peiwen.autolayout.attr;

import android.view.View;


/**
 * Created by zhy on 15/12/24.
 */
public class MinHeightAttr extends AutoAttr {
    public MinHeightAttr(int pxVal) {
        super(pxVal);
    }

    @Override
    protected void execute(View view, int val) {
        try {
            view.setMinimumHeight(val);
        } catch (Exception ignore) {
        }
    }

    @Override
    public String toString() {
        return "MinHeightAttr{" + "pxVal=" + pxVal + '}';
    }
}
