package cn.qd.peiwen.autolayout.attr;

import android.view.View;
import android.view.ViewGroup;


/**
 * Created by zhy on 15/12/5.
 */
public class HeightAttr extends AutoAttr {

    public HeightAttr(int pxVal) {
        super(pxVal);
    }

    @Override
    protected void execute(View view, int val) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.height = val;
    }

    @Override
    public String toString() {
        return "HeightAttr{" + "pxVal=" + pxVal + '}';
    }
}
