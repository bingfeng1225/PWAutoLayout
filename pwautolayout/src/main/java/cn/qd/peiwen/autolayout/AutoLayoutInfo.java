package cn.qd.peiwen.autolayout;

import android.view.View;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.qd.peiwen.autolayout.attr.AutoAttr;
import cn.qd.peiwen.autolayout.attr.HeightAttr;
import cn.qd.peiwen.autolayout.attr.MaxHeightAttr;
import cn.qd.peiwen.autolayout.attr.MaxWidthAttr;
import cn.qd.peiwen.autolayout.attr.MinHeightAttr;
import cn.qd.peiwen.autolayout.attr.MinWidthAttr;
import cn.qd.peiwen.autolayout.attr.WidthAttr;

public class AutoLayoutInfo {
    private List<AutoAttr> autoAttrs = new ArrayList<>();

    public void addAttr(AutoAttr autoAttr) {
        autoAttrs.add(autoAttr);
    }

    public <T> T findAttr(Class<T> cls) {
        Iterator<AutoAttr> iterator = autoAttrs.iterator();
        while (iterator.hasNext()) {
            AutoAttr attr = iterator.next();
            if (cls.equals(attr.getClass())) {
                return (T) attr;
            }
        }
        return null;
    }

    public void fillAttrs(View view) {
        this.matchWidth();
        this.matchHeight();
        for (AutoAttr autoAttr : autoAttrs) {
            autoAttr.apply(view);
        }

        if (view instanceof IAutolayout) {
            ((IAutolayout) view).fillAutolayout();
        }
    }


    private void matchWidth() {
        WidthAttr widthAttr = findAttr(WidthAttr.class);
        MaxWidthAttr maxWidthAttr = findAttr(MaxWidthAttr.class);
        MinWidthAttr minWidthAttr = findAttr(MinWidthAttr.class);
        if (null == widthAttr) {
            return;
        }
        if (maxWidthAttr != null) {
            if (widthAttr.getPxVal() > maxWidthAttr.getPxVal()) {
                widthAttr.setPxVal(maxWidthAttr.getPxVal());
            }
        }

        if (minWidthAttr != null) {
            if (widthAttr.getPxVal() < minWidthAttr.getPxVal()) {
                widthAttr.setPxVal(minWidthAttr.getPxVal());
            }
        }

    }

    private void matchHeight() {
        HeightAttr heightAttr = findAttr(HeightAttr.class);
        MaxHeightAttr maxHeightAttr = findAttr(MaxHeightAttr.class);
        MinHeightAttr minHeightAttr = findAttr(MinHeightAttr.class);
        if (null == heightAttr) {
            return;
        }
        if (maxHeightAttr != null) {
            if (heightAttr.getPxVal() > maxHeightAttr.getPxVal()) {
                heightAttr.setPxVal(maxHeightAttr.getPxVal());
            }
        }

        if (minHeightAttr != null) {
            if (heightAttr.getPxVal() < minHeightAttr.getPxVal()) {
                heightAttr.setPxVal(minHeightAttr.getPxVal());
            }
        }
    }

    @Override
    public String toString() {
        return "AutoLayoutInfo{" + "autoAttrs=" + autoAttrs + '}';
    }
}