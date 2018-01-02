/******************************************************************************
 * Copyright 2017 The Baidu Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *****************************************************************************/
package com.baidu.carlifevehicle.fragment;

import com.baidu.carlifevehicle.R;
import com.baidu.carlifevehicle.util.LogUtil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class HelpAndroidAOAFragment extends BaseFragment {

    private static final String TAG = "HelpAndroidAOAFragment";

    private ImageButton mBackBtn;
    private TextView mTitle;
    private TextView mAndroid;
    private View mAndroidLayout;

    private static HelpAndroidAOAFragment mHelpAndroidAOAFragment;

    public static HelpAndroidAOAFragment getInstance() {
        if (mHelpAndroidAOAFragment == null) {
            mHelpAndroidAOAFragment = new HelpAndroidAOAFragment();
        }

        return mHelpAndroidAOAFragment;
    }

    public HelpAndroidAOAFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        LogUtil.d(TAG, "onCreateView");
        mContentView = (ViewGroup) LayoutInflater.from(mActivity)
                .inflate(R.layout.frag_help_android, null);

        mBackBtn = (ImageButton) mContentView.findViewById(R.id.ib_left);
        mBackBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mTitle = (TextView) mContentView.findViewById(R.id.tv_title);
        mTitle.setText(getString(R.string.help_android_aoa_title));
        mAndroid = (TextView) mContentView.findViewById(R.id.android_device);
        mAndroid.setText(getString(R.string.help_android_aoa_device));
        mAndroidLayout = mContentView.findViewById(R.id.goto_android_layout);
        mAndroidLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentManager.showFragment(AuthorizationRequestHelpFragment.getInstance());
            }
        });

        return mContentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtil.d(TAG, "onDestroyView");
    }

    @Override
    public boolean onBackPressed() {
        if (mFragmentManager != null) {
            mFragmentManager.showFragment(HelpMainFragment.getInstance());
        }
        return true;
    }
}