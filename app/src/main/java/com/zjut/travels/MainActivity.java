package com.zjut.travels;
/**
 * @author imotto
 * @version 1.0
 */
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;
import com.zjut.travels.homepage.FoundFragment;
import com.zjut.travels.homepage.MyFragment;
import com.zjut.travels.homepage.RegisteOrLogin;
import com.zjut.travels.homepage.HomeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private DrawerLayout mDrawerLayout;

    //标题栏部分变量
    // 底部菜单2个Linearlayout
    private LinearLayout LLHome;
    private LinearLayout LLFound;
    private LinearLayout LLMy;
    // 底部菜单2个ImageView
    private ImageView ivHome;
    private ImageView ivFound;
    private ImageView ivMy;
    // 底部菜单2个菜单标题
    private TextView tvHome;
    private TextView tvFound;
    private TextView tvMy;
    // 4个Fragment
    private Fragment homeFragment;
    private Fragment foundFragment;
    private Fragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化控件
        initView();
        // 初始化底部按钮事件
        initEvent();
        // 初始化并设置当前Fragment
        initFragment(0);
        //侧滑菜单部分
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_launcher_background);
        }
        navigationView.setCheckedItem(R.id.nav_us);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {            //获取Id
                    case R.id.nav_us:
                        System.out.println("你点击了关于我们");
                        //Toast.makeText (this,"关于我们",Toast.LENGTH_LONG).show ();
                        break;
                    case R.id.nav_friends:
                        Intent intent = new Intent(MainActivity.this, RegisteOrLogin.class);
                        startActivity(intent);
                        //MainActivity.this.finish();
                        //Toast.makeText (this,"friend",Toast.LENGTH_LONG).show ();
                        break;
                    case R.id.nav_money:
                        //Toast.makeText (this,"正在开发",Toast.LENGTH_LONG).show ();
                        break;
                }
                //mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }


    private void initFragment(int index) {
        // 由于是引用了V4包下的Fragment，所以这里的管理器要用getSupportFragmentManager获取
        FragmentManager fragmentManager = getSupportFragmentManager();
        // 开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 隐藏所有Fragment
        hideFragment(transaction);
        switch (index) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.fl_content, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                if (foundFragment == null) {
                    foundFragment = new FoundFragment();
                    transaction.add(R.id.fl_content, foundFragment);
                } else {
                    transaction.show(foundFragment);
                }
                break;
            case 2:
                if(myFragment == null){
                    myFragment = new MyFragment();
                    transaction.add(R.id.fl_content,myFragment);
                }else{
                    transaction.show(myFragment);
                }
            default:
                break;
        }
        // 提交事务
        transaction.commit();
    }

    //隐藏Fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (foundFragment != null) {
            transaction.hide(foundFragment);
        }
        if (myFragment != null) {
            transaction.hide(myFragment);
        }
    }

    private void initEvent() {
        // 设置按钮监听
        LLHome.setOnClickListener((View.OnClickListener) this);
        LLFound.setOnClickListener((View.OnClickListener) this);
        LLMy.setOnClickListener((View.OnClickListener) this);
    }

    private void initView() {

        // 底部菜单3个Linearlayout
        this.LLHome = (LinearLayout) findViewById(R.id.ll_home);
        this.LLFound = (LinearLayout) findViewById(R.id.ll_found);
        this.LLMy = (LinearLayout)findViewById(R.id.ll_my);

        // 底部菜单3个ImageView
        this.ivHome = (ImageView) findViewById(R.id.iv_home);
        this.ivFound = (ImageView) findViewById(R.id.iv_found);
        this.ivMy = (ImageView) findViewById(R.id.iv_my);

        // 底部菜单3个菜单标题
        this.tvHome = (TextView) findViewById(R.id.tv_home);
        this.tvFound = (TextView) findViewById(R.id.tv_found);
        this.tvMy = (TextView) findViewById(R.id.tv_my);
    }

    @Override
    public void onClick(View v) {
        // 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
        restartBotton();
        // ImageView和TetxView置为绿色，页面随之跳转
        switch (v.getId()) {
            case R.id.ll_home:
                ivHome.setImageResource(R.drawable.home);
                tvHome.setTextColor(0xff1B940A);
                initFragment(0);
                break;
            case R.id.ll_found:
                ivFound.setImageResource(R.drawable.search);
                tvFound.setTextColor(0xff1B940A);
                initFragment(1);
                break;
            case R.id.ll_my:
                ivMy.setImageResource(R.drawable.wode);
                tvMy.setTextColor(0xff1B940A);
                initFragment(2);
            default:
                break;
        }
    }

    private void restartBotton() {
        // ImageView置为灰色
        ivHome.setImageResource(R.drawable.home);
        ivFound.setImageResource(R.drawable.search);
        ivMy.setImageResource(R.drawable.wode);
        // TextView置为白色
        tvHome.setTextColor(0xffffffff);
        tvFound.setTextColor(0xffffffff);
        tvMy.setTextColor(0xffffffff);
    }
}
