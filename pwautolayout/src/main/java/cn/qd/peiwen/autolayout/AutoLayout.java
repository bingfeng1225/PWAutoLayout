package cn.qd.peiwen.autolayout;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import cn.qd.peiwen.pwtools.ScreenUtils;


/**
 * Created by zhy on 15/11/18.
 */
public class AutoLayout {
    private static AutoLayout sIntance = new AutoLayout();
    private static final String KEY_DESIGN_WIDTH = "design_width";
    private static final String KEY_DESIGN_HEIGHT = "design_height";
    private static final String KEY_REFER_TO_WIDTH = "refer_to_width";

    private int screenWidth;
    private int screenHeight;
    private int designWidth;
    private int designHeight;
    private boolean referToWidth = true;

    private AutoLayout() {

    }

    public static AutoLayout getInstance() {
        return sIntance;
    }


    public void checkParams() {
        if (designHeight <= 0 || designWidth <= 0) {
            throw new RuntimeException("you must set " + KEY_DESIGN_WIDTH + " and " + KEY_DESIGN_HEIGHT + "  in your manifest file.");
        }
    }

    public boolean isReferToWidth() {
        return referToWidth;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getDesignWidth() {
        return designWidth;
    }

    public int getDesignHeight() {
        return designHeight;
    }

    public int getPercentSize(int val) {
        if(isReferToWidth()){
            return getPercentWidthSize(val);
        }else{
            return getPercentHeightSize(val);
        }
    }

    public void init(Context context) {
        this.getMetaData(context);
        int[] screenSize = ScreenUtils.getScreenSize(context);
        screenWidth = screenSize[0];
        screenHeight = screenSize[1];
    }

    private void getMetaData(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                designWidth = applicationInfo.metaData.getInt(KEY_DESIGN_WIDTH, 1080);
                designHeight = applicationInfo.metaData.getInt(KEY_DESIGN_HEIGHT, 1920);
                referToWidth = applicationInfo.metaData.getBoolean(KEY_REFER_TO_WIDTH, true);
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("you must set " + KEY_DESIGN_WIDTH + " and " + KEY_DESIGN_HEIGHT + "  in your manifest file.", e);
        }
    }


    private int getPercentWidthSize(int val) {
        int res = val * screenWidth;
        if (res % designWidth == 0) {
            return res / designWidth;
        } else {
            return res / designWidth + 1;
        }
    }

    private int getPercentHeightSize(int val) {
        int res = val * screenHeight;
        if (res % designHeight == 0) {
            return res / designHeight;
        } else {
            return res / designHeight + 1;
        }
    }
}
