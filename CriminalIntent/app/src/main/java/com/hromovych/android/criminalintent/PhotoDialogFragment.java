package com.hromovych.android.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import androidx.fragment.app.DialogFragment;

import android.app.FragmentManager;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;


public class PhotoDialogFragment extends DialogFragment {

    private static final String ARG_IMAGE = "photo";
    private ImageView mImageZoom;

    public static PhotoDialogFragment newInstance(String imageFile) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_IMAGE, imageFile);

        PhotoDialogFragment fragment = new PhotoDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public PhotoDialogFragment() {
        // Required empty public constructor
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        String imageFile = (String) getArguments().getSerializable(ARG_IMAGE);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_dialog, null);

        Bitmap bitmap = PictureUtils.getScaledBitmap(imageFile, getActivity());

        mImageZoom = (ImageView) v.findViewById(R.id.full_image_crime);
        mImageZoom.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create()
                ;

    }


}
