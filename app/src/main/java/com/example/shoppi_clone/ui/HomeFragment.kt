package com.example.shoppi_clone.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.shoppi_clone.*
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarTitle = view.findViewById<TextView>(R.id.toolbar_home_title)
        val toolbarIcon = view.findViewById<ImageView>(R.id.toolbar_home_icon)
        val viewpager = view.findViewById<ViewPager2>(R.id.viewpager_home_banner)
        val viewpagerIndicator = view.findViewById<TabLayout>(R.id.viewpager_home_banner_indicator)

        /** Navigation 예시
        val button = view.findViewById<Button>(R.id.btn_enter_product_detail)
        button.setOnClickListener {
            /**
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.container_main, ProductDetailFragment())
            transaction.commit()
             */
            findNavController().navigate(R.id.action_home_to_product_detail) //Navigation 사용
        }
        */

        val assetLoader = AssetLoader()
        val homeJsonString = assetLoader.getJsonString(requireContext(), "home.json")

        if (!homeJsonString.isNullOrEmpty()) {
            val gson = Gson()
            val homeData = gson.fromJson(homeJsonString, HomeData::class.java)

            toolbarTitle.text = homeData.title.text
            GlideApp.with(this)
                .load(homeData.title.iconUrl)
                .into(toolbarIcon)

            viewpager.adapter = HomeBannerAdapter().apply {
                submitList(homeData.topBanners)
            }

            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
            val screenWidth = resources.displayMetrics.widthPixels
            val offset = screenWidth - pageWidth - pageMargin

            viewpager.offscreenPageLimit = 3
            viewpager.setPageTransformer { page, position ->
                page.translationX = position * -offset
            }
            TabLayoutMediator(viewpagerIndicator, viewpager) { tab, position ->

            }.attach()
        }
    }
}