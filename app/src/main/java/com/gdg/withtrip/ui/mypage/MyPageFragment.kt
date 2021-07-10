package com.gdg.withtrip.ui.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.FragmentMypageBinding

class MyPageFragment : Fragment() {

    private var _binding: FragmentMypageBinding? = null
    private val binding: FragmentMypageBinding
        get() = _binding!!

    private val myPageViewModel: MyPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMypageBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    private fun initView(){
        binding.myBoardList.apply {
            ivMenu.loadImage(R.drawable.ic_board_list_24dp)
            tvMenu.text = resources.getString(R.string.mypage_my_board)
            llMenu.setOnClickListener {

            }
        }

        binding.myApplyList.apply {
            ivMenu.loadImage(R.drawable.ic_apply_black_24dp)
            tvMenu.text = resources.getString(R.string.mypage_my_apply_board)
            llMenu.setOnClickListener {

            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        myPageViewModel.profile.observe(viewLifecycleOwner, {
            binding.myImage.loadImageUrl(it.profileImage,centerCrop = true)
            binding.myNickname.text = it.name
        })

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}

 fun ImageView.loadImage(
    @DrawableRes imageUrl: Int
) = Glide.with(this)
    .load(imageUrl)
    .into(this)

 fun ImageView.loadImageUrl(
    imageUrl: String?,
    @DrawableRes placeHolder: Int = 0,
    centerCrop: Boolean = false
) = Glide.with(this)
    .load(imageUrl)
    .placeholder(placeHolder)
    .also { if (centerCrop) it.apply(RequestOptions.circleCropTransform()) }
    .into(this)