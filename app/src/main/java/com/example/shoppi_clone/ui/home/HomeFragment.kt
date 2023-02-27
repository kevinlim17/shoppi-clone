package com.example.shoppi_clone.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.shoppi_clone.*
import com.example.shoppi_clone.common.KEY_PRODUCT_ID
import com.example.shoppi_clone.databinding.FragmentHomeBinding
import com.example.shoppi_clone.ui.common.*
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment(), ProductClickListener {

    private val viewModel: HomeViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        binding.lifecycleOwner = viewLifecycleOwner

        setToolbar()
        setNavigation()
        setTopBanners()
        setListAdapter()
    }

    override fun onProductClick(productId: String) {
        findNavController().navigate(R.id.action_home_to_product_detail, bundleOf(
            KEY_PRODUCT_ID to "desk-1"
        ))
    }

    private fun setToolbar() {
        viewModel.title.observe(viewLifecycleOwner) { title ->
            binding.title = title
        }
    }

    private fun setNavigation(){
        viewModel.openProductEvent.observe(viewLifecycleOwner, EventObserver { banner ->
            findNavController().navigate(R.id.action_home_to_product_detail, bundleOf(
                KEY_PRODUCT_ID to banner.productDetail.productId
            ))
        })
    }

    private fun setTopBanners() {
        with(binding.viewpagerHomeBanner) {
            adapter = HomeBannerAdapter(viewModel).apply {
                viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
                    submitList(banners)
                }
            }
            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
            val screenWidth = resources.displayMetrics.widthPixels
            val offset = screenWidth - pageWidth - pageMargin

            offscreenPageLimit = 3
            setPageTransformer { page, position ->
                page.translationX = position * -offset
            }
            TabLayoutMediator(binding.viewpagerHomeBannerIndicator, this) { tab, position ->

            }.attach()
        }
    }

    private fun setListAdapter() {
        val titleAdapter = SectionTitleAdapter()
        val productPromotionAdapter = ProductPromotionAdapter(this)

        binding.rvHomePromotion.adapter = ConcatAdapter(titleAdapter, productPromotionAdapter)
        viewModel.promotions.observe(viewLifecycleOwner){
            titleAdapter.submitList(listOf(it.title))
            productPromotionAdapter.submitList(it.items)
        }
    }
}