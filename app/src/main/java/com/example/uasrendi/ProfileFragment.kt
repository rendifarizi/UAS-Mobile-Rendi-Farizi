package com.example.uasrendi

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProfileFragment : Fragment() {


    lateinit var list: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)


        list = root.findViewById(R.id.list)


        list.adapter = linkAdapter

        return root
    }


    private val linkAdapter by lazy {
        val items = listOf<LinkModel>(
            LinkModel("WhatsApp", R.drawable.whatsapp, "https://wa.me/+6281364064104"),
            LinkModel("Tiktok", R.drawable.tiktok, "https://www.tiktok.com/@rendifarizi89"),
            LinkModel("Instagram", R.drawable.instagram, "https://www.instagram.com/rendi.farizi/"),

            )

        LinkAdapter(items, object : LinkAdapter.AdapterListener {
            override fun onClick(linktree: LinkModel) {1
                Log.e("onClick", linktree.url)
                openUrl(linktree.url)
            }

        })
    }

    private fun openUrl(url: String) {
        val openUrl = Intent(Intent.ACTION_VIEW)
        openUrl.data = Uri.parse(url)
        startActivity(openUrl)
    }
}