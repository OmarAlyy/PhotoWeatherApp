package com.omaraly.photoweatherapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.omaraly.photoweatherapp.R;
import com.omaraly.photoweatherapp.Utilities.GlobalVariables;
import com.omaraly.photoweatherapp.databinding.BottomSheetSelectImageBinding;

public class ActionBottomDialogFragment extends BottomSheetDialogFragment
        implements View.OnClickListener {

    BottomSheetSelectImageBinding binding;
    private ItemClickListener mListener;

    public static ActionBottomDialogFragment newInstance() {
        return new ActionBottomDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.bottom_sheet_select_image, container, false);

        binding.linGallery.setOnClickListener(this);
        binding.linCamera.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ItemClickListener) {
            mListener = (ItemClickListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.linCamera:

                mListener.onItemClick(GlobalVariables.CAMERA);
                dismiss();
                break;

            case R.id.linGallery:

                mListener.onItemClick(GlobalVariables.GALLERY);
                dismiss();
                break;
        }


    }


    public interface ItemClickListener {
        void onItemClick(int type);
    }
}