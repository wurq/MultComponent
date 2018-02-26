package com.arch.componentaservice.routerapp;

import com.arch.componentaservice.serviceimpl.ComponentAServiceImpl;
import com.arch.componentlib.irouterapplication.IRouterApplication;
import com.arch.componentlib.router.Router;
import com.arch.componentlib.router.ui.UIRouter;
import com.arch.componentservice.componenta.ComponentAService;

/**
 * Created by wurongqiu on 2018/1/31.
 */

public class RouterApplication implements IRouterApplication {
    Router router = Router.getInstance();
    UIRouter uiRouter = UIRouter.getInstance();

    @Override
    public void onCreate() {
        uiRouter.registerUI("componentaservice");
        router.addService(ComponentAService.class.getSimpleName(), new ComponentAServiceImpl());
    }

    @Override
    public void onStop() {
        uiRouter.unregisterUI("componentaservice");
        router.removeService(ComponentAService.class.getSimpleName());
    }
}
