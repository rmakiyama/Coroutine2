package com.okuzawats.comcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    @BindView(R.id.image_view)
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        accessApi()
    }

    // GitHubApiにアクセスする
    private fun accessApi() {
        GlobalScope.launch(Dispatchers.Main) {
            val request = GitHubApi.instance.fetchUserAsync("okuzawats")
            try {
                val response = request.await()
                setImage(response)
            } catch (e: Throwable) {
                Timber.e(e)
            }
        }
    }

    // アバターの画像を表示する
    private fun setImage(gitHubUser: GitHubUser) {
        Glide.with(CoroutineApplication.applicationContext())
                .load(gitHubUser.avatar_url)
                .into(imageView)
    }
}
