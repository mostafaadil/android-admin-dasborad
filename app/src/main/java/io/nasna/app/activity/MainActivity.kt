package io.nasna.app.activity

import android.app.FragmentManager
import android.app.FragmentTransaction
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.internal.NavigationMenu
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils.replace
import android.view.View
import android.widget.Toast
import io.nasna.app.R
import io.nasna.app.R.id.conainer
import io.nasna.app.R.id.navigation
import io.nasna.app.fragment.AccountsFragment
import io.nasna.app.fragment.LoyaltyFragment
import io.nasna.app.fragment.QrFragment
import io.nasna.app.fragment.TransactionsFragment

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {

                    navigation.getMenu().getItem(R.id.home).setChecked(true);
                    conainer.removeAllViews()
                    supportFragmentManager
                            // 3
                            .beginTransaction()
                            // 4
                            .add(R.id.conainer,AccountsFragment.newInstance(), "dogList")
                            // 5
                            .commit()
                }
                R.id.qr -> {
                    conainer.removeAllViews()
                    navigation.getMenu().getItem(R.id.qr).setChecked(true);

                    supportFragmentManager
                            // 3
                            .beginTransaction()
                            // 4
                            .add(R.id.conainer,QrFragment.newInstance(), "dogList")
                            // 5
                            .commit()

                }
                R.id.account -> {

                    conainer.removeAllViews()
                    navigation.getMenu().getItem(R.id.account).setChecked(true);

                    supportFragmentManager
                            // 3
                            .beginTransaction()
                            // 4
                            .add(R.id.conainer,AccountsFragment.newInstance(), "dogList")
                            // 5
                            .commit()
                }
                R.id.loyalty -> {
                    conainer.removeAllViews()
                    navigation.getMenu().getItem(R.id.loyalty).setChecked(true);

                    supportFragmentManager
                            // 3
                            .beginTransaction()
                            // 4
                            .add(R.id.conainer,LoyaltyFragment.newInstance(), "dogList")
                            // 5
                            .commit()
                  }
                R.id.transactions -> {
                    conainer.removeAllViews()

                    navigation.getMenu().getItem(R.id.transactions).setChecked(true);

                    supportFragmentManager
                            // 3
                            .beginTransaction()
                            // 4
                            .add(R.id.conainer,TransactionsFragment.newInstance(), "dogList")
                            // 5
                            .commit()
                }
            }
            false
        }
        floatingActionButton.setOnClickListener(View.OnClickListener {

            conainer.removeAllViews()
            supportFragmentManager
                    // 3
                    .beginTransaction()
                    // 4
                    .add(R.id.conainer,QrFragment.newInstance(), "dogList")
                    // 5
                    .commit()

        })

    }

    
}

