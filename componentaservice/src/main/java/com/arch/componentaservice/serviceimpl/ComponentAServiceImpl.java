package com.arch.componentaservice.serviceimpl;


import android.support.v4.app.Fragment;

import com.arch.componentaservice.ComponentAFragment;
import com.arch.componentservice.componenta.ComponentAService;

/**
 * Created by wurongqiu on 2018/1/31.
 */

public class ComponentAServiceImpl implements ComponentAService {

    @Override
    public Fragment getComponentAFragment() {
        return new ComponentAFragment();
    }
}
