package com.oscar.mall.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.oscar.mall.R
import com.oscar.malllibrary.fragments.BaseFragment
import com.oscar.malllibrary.fragments.MallFragment

/**
 *
 * @Description：
 * @Author: haishan
 * @CreateDate: 2020/10/9 3:08 PM
 */
class TestFragment : MallFragment() {
    override fun setLayout(): Any = R.layout.fragment_test

    override fun onBindView(savedInstanceState: Bundle?, rootView: View) {
        Toast.makeText(context, "初始化完成！", Toast.LENGTH_LONG).show()
    }
}