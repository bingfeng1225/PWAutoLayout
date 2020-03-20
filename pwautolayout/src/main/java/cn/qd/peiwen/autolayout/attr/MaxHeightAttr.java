package cn.qd.peiwen.autolayout.attr;

import android.view.View;


import java.lang.reflect.Method;

/**
 * Created by zhy on 15/12/24.
 */
public class MaxHeightAttr extends AutoAttr {
    public MaxHeightAttr(int pxVal) {
        super(pxVal);
    }

    @Override
    protected void execute(View view, int val) {
        try {
            Method setMaxWidthMethod = view.getClass().getMethod("setMaxHeight", int.class);
            setMaxWidthMethod.invoke(view, val);
        } catch (Exception ignore) {
        }
    }

    @Override
    public String toString() {
        return "MaxHeightAttr{" + "pxVal=" + pxVal + '}';
    }
}
