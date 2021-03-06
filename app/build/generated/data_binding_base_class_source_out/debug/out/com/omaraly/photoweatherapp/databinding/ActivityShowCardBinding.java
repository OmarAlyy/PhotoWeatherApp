// Generated by data binding compiler. Do not edit!
package com.omaraly.photoweatherapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.omaraly.photoweatherapp.R;
import com.omaraly.photoweatherapp.ShowCardViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityShowCardBinding extends ViewDataBinding {
  @NonNull
  public final ImageView back;

  @NonNull
  public final CardView card;

  @NonNull
  public final TextView degree;

  @NonNull
  public final TextInputEditText etText;

  @NonNull
  public final ImageView iconStatus;

  @NonNull
  public final ImageView image;

  @NonNull
  public final TextView location;

  @NonNull
  public final MaterialButton save;

  @NonNull
  public final TextView text;

  @NonNull
  public final TextView textStatus;

  @NonNull
  public final TextView time;

  @Bindable
  protected ShowCardViewModel mViewModel;

  protected ActivityShowCardBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView back, CardView card, TextView degree, TextInputEditText etText,
      ImageView iconStatus, ImageView image, TextView location, MaterialButton save, TextView text,
      TextView textStatus, TextView time) {
    super(_bindingComponent, _root, _localFieldCount);
    this.back = back;
    this.card = card;
    this.degree = degree;
    this.etText = etText;
    this.iconStatus = iconStatus;
    this.image = image;
    this.location = location;
    this.save = save;
    this.text = text;
    this.textStatus = textStatus;
    this.time = time;
  }

  public abstract void setViewModel(@Nullable ShowCardViewModel ViewModel);

  @Nullable
  public ShowCardViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static ActivityShowCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_show_card, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityShowCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityShowCardBinding>inflateInternal(inflater, R.layout.activity_show_card, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityShowCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_show_card, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityShowCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityShowCardBinding>inflateInternal(inflater, R.layout.activity_show_card, null, false, component);
  }

  public static ActivityShowCardBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityShowCardBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityShowCardBinding)bind(component, view, R.layout.activity_show_card);
  }
}
