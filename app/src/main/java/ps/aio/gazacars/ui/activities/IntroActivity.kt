package ps.aio.gazacars.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ps.aio.gazacars.R
import ps.aio.gazacars.databinding.ActivityIntroBinding
import ps.aio.gazacars.models.IntroItem
import ps.aio.gazacars.ui.adapters.AdapterIntroViewPager2

class IntroActivity : AppCompatActivity() {
    private lateinit var activityIntroBinding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityIntroBinding = DataBindingUtil.setContentView(this, R.layout.activity_intro)

        val items = arrayOf(
            IntroItem(
                "All In App",
                "Description of This ScreenDescription of This ScreenDescription of This ScreenDescription of This ScreenDescription of This ScreenDescription of This Screen",
                R.drawable.car_1
            ),
            IntroItem(
                "Ask the Expert",
                "Description of This ScreenDescription of This ScreenDescription of This ScreenDescription of This ScreenDescription of This ScreenDescription of This ScreenDescription of This Screen",
                R.drawable.car_2
            ),
            IntroItem(
                "Welcome To Gaza Cars ",
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est eopksio",
                R.drawable.car_3
            )
        )

        val adapterIntroViewPager2 = AdapterIntroViewPager2(this, items.asList())
        activityIntroBinding.screenIntroViewPager.adapter = adapterIntroViewPager2
        TabLayoutMediator(activityIntroBinding.tabIndicator,
            activityIntroBinding.screenIntroViewPager) { tab, posstion ->

        }.attach()
        activityIntroBinding.tabIndicator.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab!!.position < items.size - 1) {
                    activityIntroBinding.btnNext.text = tab.view.resources.getString(R.string.next)
                    activityIntroBinding.btnSkip.visibility = View.VISIBLE
                } else if (tab.position == items.size - 1) {
                    activityIntroBinding.btnNext.text = tab.view.resources.getString(R.string.finsh)
                    activityIntroBinding.btnSkip.visibility = View.GONE
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                return
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                return
            }

        })

        activityIntroBinding.btnNext.setOnClickListener {
            var position = activityIntroBinding.screenIntroViewPager.currentItem
            if (activityIntroBinding.btnNext.text == it.resources.getString(R.string.next)) {
                if (position < items.size) {
                    position++
                    activityIntroBinding.screenIntroViewPager.currentItem = position
                }
            } else
                goToLoginActivity()
        }
        activityIntroBinding.btnSkip.setOnClickListener { goToLoginActivity() }
    }

    private fun goToLoginActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

}