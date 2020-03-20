package cn.qd.peiwen.autolayout.attr;

import android.view.View;


import cn.qd.peiwen.autolayout.AutoLayout;


/**
 * Created by zhy on 15/12/4.
 */
public abstract class AutoAttr {
    protected int pxVal;

    public AutoAttr(int pxVal) {
        this.pxVal = pxVal;
    }

    public int getPxVal() {
        return pxVal;
    }

    public void setPxVal(int pxVal) {
        this.pxVal = pxVal;
    }

    protected abstract void execute(View view, int val);

    public void apply(View view) {
        int val =  AutoLayout.getInstance().getPercentSize(pxVal);
        execute(view, val);
    }

    @Override
    public String toString() {
        return "AutoAttr{" + "pxVal=" + pxVal + '}';
    }
}
