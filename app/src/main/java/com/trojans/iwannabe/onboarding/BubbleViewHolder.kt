package com.trojans.iwannabe.onboarding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trojans.iwannabe.R

class BubbleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView = itemView.findViewById(R.id.imageView_bubble)
    var textView: TextView = itemView.findViewById(R.id.textView_bubble)
}