package com.omaraly.photoweatherapp;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.omaraly.photoweatherapp.databinding.ActivityMainBindingImpl;
import com.omaraly.photoweatherapp.databinding.ActivityShowCardBindingImpl;
import com.omaraly.photoweatherapp.databinding.ActivityShowImageBindingImpl;
import com.omaraly.photoweatherapp.databinding.ActivitySplashBindingImpl;
import com.omaraly.photoweatherapp.databinding.BottomSheetSelectImageBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_ACTIVITYSHOWCARD = 2;

  private static final int LAYOUT_ACTIVITYSHOWIMAGE = 3;

  private static final int LAYOUT_ACTIVITYSPLASH = 4;

  private static final int LAYOUT_BOTTOMSHEETSELECTIMAGE = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.omaraly.photoweatherapp.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.omaraly.photoweatherapp.R.layout.activity_show_card, LAYOUT_ACTIVITYSHOWCARD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.omaraly.photoweatherapp.R.layout.activity_show_image, LAYOUT_ACTIVITYSHOWIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.omaraly.photoweatherapp.R.layout.activity_splash, LAYOUT_ACTIVITYSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.omaraly.photoweatherapp.R.layout.bottom_sheet_select_image, LAYOUT_BOTTOMSHEETSELECTIMAGE);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSHOWCARD: {
          if ("layout/activity_show_card_0".equals(tag)) {
            return new ActivityShowCardBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_show_card is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSHOWIMAGE: {
          if ("layout/activity_show_image_0".equals(tag)) {
            return new ActivityShowImageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_show_image is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSPLASH: {
          if ("layout/activity_splash_0".equals(tag)) {
            return new ActivitySplashBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + tag);
        }
        case  LAYOUT_BOTTOMSHEETSELECTIMAGE: {
          if ("layout/bottom_sheet_select_image_0".equals(tag)) {
            return new BottomSheetSelectImageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for bottom_sheet_select_image is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(1, "ViewModel");
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/activity_main_0", com.omaraly.photoweatherapp.R.layout.activity_main);
      sKeys.put("layout/activity_show_card_0", com.omaraly.photoweatherapp.R.layout.activity_show_card);
      sKeys.put("layout/activity_show_image_0", com.omaraly.photoweatherapp.R.layout.activity_show_image);
      sKeys.put("layout/activity_splash_0", com.omaraly.photoweatherapp.R.layout.activity_splash);
      sKeys.put("layout/bottom_sheet_select_image_0", com.omaraly.photoweatherapp.R.layout.bottom_sheet_select_image);
    }
  }
}
