package cn.qd.peiwen.autolayout.attr;

import android.view.View;
import android.widget.TextView;

/**
 * Created by nick on 2018/1/13.
 */

public class LineSpacingExtraAttr extends AutoAttr {
    public LineSpacingExtraAttr(int pxVal) {
        super(pxVal);
    }
    @Override
    protected void execute(View view, int val) {
        if (!(view instanceof TextView))
            return;
        TextView textView = (TextView) view;
        textView.setLineSpacing(val,textView.getLineSpacingMultiplier());
    }

    @Override
    public String toString() {
        return "LineSpacingExtraAttr{" + "pxVal=" + pxVal + '}';
    }
}
