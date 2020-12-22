package com.omaraly.photoweatherapp.databinding;
import com.omaraly.photoweatherapp.R;
import com.omaraly.photoweatherapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityShowCardBindingImpl extends ActivityShowCardBinding implements com.omaraly.photoweatherapp.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.card, 11);
        sViewsWithIds.put(R.id.image, 12);
        sViewsWithIds.put(R.id.iconStatus, 13);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    @NonNull
    private final android.widget.ProgressBar mboundView2;
    @NonNull
    private final android.widget.LinearLayout mboundView3;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    private OnTextChangedImpl mViewModelOnTexttChangedAndroidxDatabindingAdaptersTextViewBindingAdapterOnTextChanged;
    // Inverse Binding Event Handlers

    public ActivityShowCardBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private ActivityShowCardBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6
            , (android.widget.ImageView) bindings[1]
            , (androidx.cardview.widget.CardView) bindings[11]
            , (android.widget.TextView) bindings[6]
            , (com.google.android.material.textfield.TextInputEditText) bindings[9]
            , (android.widget.ImageView) bindings[13]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.TextView) bindings[4]
            , (com.google.android.material.button.MaterialButton) bindings[10]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[5]
            );
        this.back.setTag(null);
        this.degree.setTag(null);
        this.etText.setTag(null);
        this.location.setTag(null);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.ProgressBar) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.LinearLayout) bindings[3];
        this.mboundView3.setTag(null);
        this.save.setTag(null);
        this.text.setTag(null);
        this.textStatus.setTag(null);
        this.time.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new com.omaraly.photoweatherapp.generated.callback.OnClickListener(this, 1);
        mCallback3 = new com.omaraly.photoweatherapp.generated.callback.OnClickListener(this, 2);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x80L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.ViewModel == variableId) {
            setViewModel((com.omaraly.photoweatherapp.ShowCardViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.omaraly.photoweatherapp.ShowCardViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x40L;
        }
        notifyPropertyChanged(BR.ViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelIsLoading((androidx.databinding.ObservableBoolean) object, fieldId);
            case 1 :
                return onChangeViewModelMain((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeViewModelTemp((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeViewModelText((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 4 :
                return onChangeViewModelCountry((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 5 :
                return onChangeViewModelTime((androidx.databinding.ObservableField<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsLoading(androidx.databinding.ObservableBoolean ViewModelIsLoading, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelMain(androidx.databinding.ObservableField<java.lang.String> ViewModelMain, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelTemp(androidx.databinding.ObservableField<java.lang.String> ViewModelTemp, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelText(androidx.databinding.ObservableField<java.lang.String> ViewModelText, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelCountry(androidx.databinding.ObservableField<java.lang.String> ViewModelCountry, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelTime(androidx.databinding.ObservableField<java.lang.String> ViewModelTime, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        boolean viewModelIsLoadingGet = false;
        java.lang.String viewModelTextGet = null;
        java.lang.String viewModelCountryGet = null;
        java.lang.String viewModelMainGet = null;
        androidx.databinding.ObservableBoolean viewModelIsLoading = null;
        androidx.databinding.ObservableField<java.lang.String> viewModelMain = null;
        com.omaraly.photoweatherapp.ShowCardViewModel viewModel = mViewModel;
        androidx.databinding.ObservableField<java.lang.String> viewModelTemp = null;
        androidx.databinding.ObservableField<java.lang.String> viewModelText = null;
        int viewModelIsLoadingViewGONEViewVISIBLE = 0;
        int viewModelIsLoadingViewVISIBLEViewGONE = 0;
        java.lang.String viewModelTimeGet = null;
        java.lang.String viewModelTempGet = null;
        androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged viewModelOnTexttChangedAndroidxDatabindingAdaptersTextViewBindingAdapterOnTextChanged = null;
        androidx.databinding.ObservableField<java.lang.String> viewModelCountry = null;
        androidx.databinding.ObservableField<java.lang.String> viewModelTime = null;

        if ((dirtyFlags & 0xffL) != 0) {


            if ((dirtyFlags & 0xc1L) != 0) {

                    if (viewModel != null) {
                        // read ViewModel.isLoading
                        viewModelIsLoading = viewModel.isLoading;
                    }
                    updateRegistration(0, viewModelIsLoading);


                    if (viewModelIsLoading != null) {
                        // read ViewModel.isLoading.get()
                        viewModelIsLoadingGet = viewModelIsLoading.get();
                    }
                if((dirtyFlags & 0xc1L) != 0) {
                    if(viewModelIsLoadingGet) {
                            dirtyFlags |= 0x200L;
                            dirtyFlags |= 0x800L;
                    }
                    else {
                            dirtyFlags |= 0x100L;
                            dirtyFlags |= 0x400L;
                    }
                }


                    // read ViewModel.isLoading.get() ? View.GONE : View.VISIBLE
                    viewModelIsLoadingViewGONEViewVISIBLE = ((viewModelIsLoadingGet) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
                    // read ViewModel.isLoading.get() ? View.VISIBLE : View.GONE
                    viewModelIsLoadingViewVISIBLEViewGONE = ((viewModelIsLoadingGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
            if ((dirtyFlags & 0xc2L) != 0) {

                    if (viewModel != null) {
                        // read ViewModel.main
                        viewModelMain = viewModel.main;
                    }
                    updateRegistration(1, viewModelMain);


                    if (viewModelMain != null) {
                        // read ViewModel.main.get()
                        viewModelMainGet = viewModelMain.get();
                    }
            }
            if ((dirtyFlags & 0xc4L) != 0) {

                    if (viewModel != null) {
                        // read ViewModel.temp
                        viewModelTemp = viewModel.temp;
                    }
                    updateRegistration(2, viewModelTemp);


                    if (viewModelTemp != null) {
                        // read ViewModel.temp.get()
                        viewModelTempGet = viewModelTemp.get();
                    }
            }
            if ((dirtyFlags & 0xc8L) != 0) {

                    if (viewModel != null) {
                        // read ViewModel.text
                        viewModelText = viewModel.text;
                    }
                    updateRegistration(3, viewModelText);


                    if (viewModelText != null) {
                        // read ViewModel.text.get()
                        viewModelTextGet = viewModelText.get();
                    }
            }
            if ((dirtyFlags & 0xc0L) != 0) {

                    if (viewModel != null) {
                        // read ViewModel::onTexttChanged
                        viewModelOnTexttChangedAndroidxDatabindingAdaptersTextViewBindingAdapterOnTextChanged = (((mViewModelOnTexttChangedAndroidxDatabindingAdaptersTextViewBindingAdapterOnTextChanged == null) ? (mViewModelOnTexttChangedAndroidxDatabindingAdaptersTextViewBindingAdapterOnTextChanged = new OnTextChangedImpl()) : mViewModelOnTexttChangedAndroidxDatabindingAdaptersTextViewBindingAdapterOnTextChanged).setValue(viewModel));
                    }
            }
            if ((dirtyFlags & 0xd0L) != 0) {

                    if (viewModel != null) {
                        // read ViewModel.country
                        viewModelCountry = viewModel.country;
                    }
                    updateRegistration(4, viewModelCountry);


                    if (viewModelCountry != null) {
                        // read ViewModel.country.get()
                        viewModelCountryGet = viewModelCountry.get();
                    }
            }
            if ((dirtyFlags & 0xe0L) != 0) {

                    if (viewModel != null) {
                        // read ViewModel.time
                        viewModelTime = viewModel.time;
                    }
                    updateRegistration(5, viewModelTime);


                    if (viewModelTime != null) {
                        // read ViewModel.time.get()
                        viewModelTimeGet = viewModelTime.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x80L) != 0) {
            // api target 1

            this.back.setOnClickListener(mCallback2);
            this.save.setOnClickListener(mCallback3);
        }
        if ((dirtyFlags & 0xc4L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.degree, viewModelTempGet);
        }
        if ((dirtyFlags & 0xc0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etText, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)viewModelOnTexttChangedAndroidxDatabindingAdaptersTextViewBindingAdapterOnTextChanged, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, (androidx.databinding.InverseBindingListener)null);
        }
        if ((dirtyFlags & 0xd0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.location, viewModelCountryGet);
        }
        if ((dirtyFlags & 0xc1L) != 0) {
            // api target 1

            this.mboundView2.setVisibility(viewModelIsLoadingViewVISIBLEViewGONE);
            this.mboundView3.setVisibility(viewModelIsLoadingViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 0xc8L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.text, viewModelTextGet);
        }
        if ((dirtyFlags & 0xc2L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textStatus, viewModelMainGet);
        }
        if ((dirtyFlags & 0xe0L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.time, viewModelTimeGet);
        }
    }
    // Listener Stub Implementations
    public static class OnTextChangedImpl implements androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged{
        private com.omaraly.photoweatherapp.ShowCardViewModel value;
        public OnTextChangedImpl setValue(com.omaraly.photoweatherapp.ShowCardViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onTextChanged(java.lang.CharSequence arg0, int arg1, int arg2, int arg3) {
            this.value.onTexttChanged(arg0, arg1, arg2, arg3); 
        }
    }
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // ViewModel
                com.omaraly.photoweatherapp.ShowCardViewModel viewModel = mViewModel;
                // ViewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.back();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // ViewModel
                com.omaraly.photoweatherapp.ShowCardViewModel viewModel = mViewModel;
                // ViewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.save();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): ViewModel.isLoading
        flag 1 (0x2L): ViewModel.main
        flag 2 (0x3L): ViewModel.temp
        flag 3 (0x4L): ViewModel.text
        flag 4 (0x5L): ViewModel.country
        flag 5 (0x6L): ViewModel.time
        flag 6 (0x7L): ViewModel
        flag 7 (0x8L): null
        flag 8 (0x9L): ViewModel.isLoading.get() ? View.GONE : View.VISIBLE
        flag 9 (0xaL): ViewModel.isLoading.get() ? View.GONE : View.VISIBLE
        flag 10 (0xbL): ViewModel.isLoading.get() ? View.VISIBLE : View.GONE
        flag 11 (0xcL): ViewModel.isLoading.get() ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}