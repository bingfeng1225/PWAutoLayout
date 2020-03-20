package cn.qd.peiwen.autolayout.attr;

import android.view.View;


/**
 * Created by zhy on 15/12/5.
 */
public class PaddingAttr extends AutoAttr {
    public PaddingAttr(int pxVal) {
        super(pxVal);
    }

    @Override
    protected void execute(View view, int val) {
        view.setPadding(val, val, val, val);
    }


    @Override
    public String toString() {
        return "PaddingAttr{" + "pxVal=" + pxVal + '}';
    }

}
