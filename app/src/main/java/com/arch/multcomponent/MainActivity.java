package com.arch.multcomponent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.arch.componentlib.router.Router;
import com.arch.componentservice.componenta.ComponentAService;
import com.arch.rout_annotation.RouteNode;

//import com.arch.annotation.RouteNode;

@RouteNode(path = "/main", desc = "首页")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Fragment fragment;
    FragmentTransaction ft;

    Button installBtn;
    Button uninstallBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        installBtn = (Button) findViewById(R.id.install_share);
        uninstallBtn = (Button) findViewById(R.id.uninstall_share);
        installBtn.setOnClickListener(this);
        uninstallBtn.setOnClickListener(this);
        showFragment();
    }



    private void showFragment() {
        if (fragment != null) {
            ft = getSupportFragmentManager().beginTransaction();
            ft.remove(fragment).commit();
            fragment = null;
        }
        Router router = Router.getInstance();
        if (router.getService(ComponentAService.class.getSimpleName()) != null) {
            ComponentAService service = (ComponentAService) router.getService(ComponentAService.class.getSimpleName());
            fragment = service.getComponentAFragment();
            ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.tab_content, fragment).commitAllowingStateLoss();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.install_share:
                Router.registerComponent("com.arch.componentaservice.routerapp.RouterApplication");
//                Router.registerComponent("com.arch.multcomponent.MainActivity");
                break;
            case R.id.uninstall_share:
                Router.unregisterComponent("com.arch.componentaservice.routerapp.RouterApplication");
                break;
        }
    }
}
