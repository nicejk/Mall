package com.oscar.mall

import android.os.Bundle
import com.oscar.mall.fragments.TestFragment
import com.oscar.malllibrary.activities.ProxyActivity
import com.oscar.malllibrary.fragments.MallFragment

class MainActivity : ProxyActivity() {
    override fun setRootFragment(): MallFragment {
        return TestFragment()
    }
}