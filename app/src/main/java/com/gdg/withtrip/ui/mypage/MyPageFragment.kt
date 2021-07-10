package com.gdg.withtrip.ui.mypage

import android.content.Context
import android.os.Bundle
import android.util.Log
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
import com.gdg.withtrip.SearchToolBarHolder
import com.gdg.withtrip.databinding.FragmentMypageBinding

class MyPageFragment : Fragment() {

    private var _binding: FragmentMypageBinding? = null
    private val binding: FragmentMypageBinding
        get() = _binding!!

    private val myPageViewModel: MyPageViewModel by viewModels()

    lateinit var searchToolBar: SearchToolBarHolder


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

        if (::searchToolBar.isInitialized) {
            searchToolBar.getController().searchWord.observe(viewLifecycleOwner, {
                Log.d("검색 단어 ->", it)
            })
        }

        myPageViewModel.profile.observe(viewLifecycleOwner, {
            binding.myImage.loadImageUrl(it.profileImage,centerCrop = true)
            binding.myNickname.text = it.name
        })

        myPageViewModel.loginState.observe(viewLifecycleOwner,{
          val (icon,text) =  when(it){
                LoginState.LOGIN ->{
                    R.drawable.ic_logout_black_24dp to R.string.mypage_logout
                }
                LoginState.LOGOUT ->{
                    R.drawable.ic_login_black_24dp to R.string.mypage_login
                }
            }

            binding.mySign.apply {
                ivMenu.loadImage(icon)
                tvMenu.text = resources.getString(text)
                llMenu.setOnClickListener {

                }
            }
        })

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            searchToolBar = context as SearchToolBarHolder
        } catch (e: Exception) {
            e.printStackTrace()
        }
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