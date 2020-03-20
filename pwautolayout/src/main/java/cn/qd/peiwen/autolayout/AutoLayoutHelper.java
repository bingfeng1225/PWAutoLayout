/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.qd.peiwen.autolayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import cn.qd.peiwen.autolayout.attr.HeightAttr;
import cn.qd.peiwen.autolayout.attr.LineSpacingExtraAttr;
import cn.qd.peiwen.autolayout.attr.MarginAttr;
import cn.qd.peiwen.autolayout.attr.MarginBottomAttr;
import cn.qd.peiwen.autolayout.attr.MarginLeftAttr;
import cn.qd.peiwen.autolayout.attr.MarginRightAttr;
import cn.qd.peiwen.autolayout.attr.MarginTopAttr;
import cn.qd.peiwen.autolayout.attr.MaxHeightAttr;
import cn.qd.peiwen.autolayout.attr.MaxWidthAttr;
import cn.qd.peiwen.autolayout.attr.MinHeightAttr;
import cn.qd.peiwen.autolayout.attr.MinWidthAttr;
import cn.qd.peiwen.autolayout.attr.PaddingAttr;
import cn.qd.peiwen.autolayout.attr.PaddingBottomAttr;
import cn.qd.peiwen.autolayout.attr.PaddingLeftAttr;
import cn.qd.peiwen.autolayout.attr.PaddingRightAttr;
import cn.qd.peiwen.autolayout.attr.PaddingTopAttr;
import cn.qd.peiwen.autolayout.attr.TextSizeAttr;
import cn.qd.peiwen.autolayout.attr.WidthAttr;
import cn.qd.peiwen.pwtools.SizeUtils;


public class AutoLayoutHelper {
    private final ViewGroup mHost;

    private static final int[] LL = new int[]{
            android.R.attr.textSize,//0--TextView
            android.R.attr.padding,//1
            android.R.attr.paddingLeft,//2
            android.R.attr.paddingTop,//3
            android.R.attr.paddingRight,//4
            android.R.attr.paddingBottom,//5
            android.R.attr.layout_width,//6
            android.R.attr.layout_height,//7
            android.R.attr.layout_margin,//8
            android.R.attr.layout_marginLeft,//9
            android.R.attr.layout_marginTop,//10
            android.R.attr.layout_marginRight,//11
            android.R.attr.layout_marginBottom,//12
            android.R.attr.maxWidth,//13
            android.R.attr.maxHeight,//14
            android.R.attr.minWidth,//15
            android.R.attr.minHeight,//16
            android.R.attr.lineSpacingExtra,//17
    };


    public AutoLayoutHelper(ViewGroup host) {
        mHost = host;
    }

    public void adjustChildren() {
        AutoLayout.getInstance().checkParams();
        for (int i = 0, n = mHost.getChildCount(); i < n; i++) {
            View view = mHost.getChildAt(i);
            ViewGroup.LayoutParams params = view.getLayoutParams();
            if (params instanceof AutoLayoutParams) {
                AutoLayoutInfo info = ((AutoLayoutParams) params).getAutoLayoutInfo();
                if (info != null) {
                    info.fillAttrs(view);
                }
            }
        }
    }

    public static AutoLayoutInfo getAutoLayoutInfo(Context context, AttributeSet attrs) {
        AutoLayoutInfo info = new AutoLayoutInfo();
        TypedArray array = context.obtainStyledAttributes(attrs, LL);
        int n = array.getIndexCount();
        for (int i = 0; i < n; i++) {
            int index = array.getIndex(i);
            if (!SizeUtils.isPxVal(array.peekValue(index))) {
                continue;
            }
            int pxVal = 0;
            try {
                pxVal = array.getDimensionPixelOffset(index, 0);
            } catch (Exception ignore) {
                continue;
            }
            switch (index) {
                case 0:
                    info.addAttr(new TextSizeAttr(pxVal));
                    break;
                case 1:
                    info.addAttr(new PaddingAttr(pxVal));
                    break;
                case 2:
                    info.addAttr(new PaddingLeftAttr(pxVal));
                    break;
                case 3:
                    info.addAttr(new PaddingTopAttr(pxVal));
                    break;
                case 4:
                    info.addAttr(new PaddingRightAttr(pxVal));
                    break;
                case 5:
                    info.addAttr(new PaddingBottomAttr(pxVal));
                    break;
                case 6:
                    info.addAttr(new WidthAttr(pxVal));
                    break;
                case 7:
                    info.addAttr(new HeightAttr(pxVal));
                    break;
                case 8:
                    info.addAttr(new MarginAttr(pxVal));
                    break;
                case 9:
                    info.addAttr(new MarginLeftAttr(pxVal));
                    break;
                case 10:
                    info.addAttr(new MarginTopAttr(pxVal));
                    break;
                case 11:
                    info.addAttr(new MarginRightAttr(pxVal));
                    break;
                case 12:
                    info.addAttr(new MarginBottomAttr(pxVal));
                    break;
                case 13:
                    info.addAttr(new MaxWidthAttr(pxVal));
                    break;
                case 14:
                    info.addAttr(new MaxHeightAttr(pxVal));
                    break;
                case 15:
                    info.addAttr(new MinWidthAttr(pxVal));
                    break;
                case 16:
                    info.addAttr(new MinHeightAttr(pxVal));
                    break;
                case 17:
                    info.addAttr(new LineSpacingExtraAttr(pxVal));
                    break;
            }
        }
        array.recycle();
        return info;
    }
}
