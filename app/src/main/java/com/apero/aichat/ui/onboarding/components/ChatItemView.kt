package com.apero.aichat.ui.onboarding.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.apero.aichat.R
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView

class ChatItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val avatarImageView: ImageView
    private val labelCardView: MaterialCardView
    private val labelIconView: ImageView
    private val labelTextView: TextView
    private val titleTextView: TextView
    private val descriptionTextView: TextView

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.view_chat_item, this, true)
        
        avatarImageView = view.findViewById(R.id.iv_avatar)
        labelCardView = view.findViewById(R.id.card_label)
        labelIconView = view.findViewById(R.id.iv_label_icon)
        labelTextView = view.findViewById(R.id.tv_label)
        titleTextView = view.findViewById(R.id.tv_title)
        descriptionTextView = view.findViewById(R.id.tv_description)
    }

    fun setImageContent(drawable: Drawable?) {
        if (drawable != null) {
            Glide.with(context)
                .load(drawable)
                .circleCrop()
                .into(avatarImageView)
            avatarImageView.isVisible = true
        } else {
            avatarImageView.isVisible = false
        }
    }

    fun setImageContent(imageUrl: String?) {
        if (!imageUrl.isNullOrEmpty()) {
            Glide.with(context)
                .load(imageUrl)
                .circleCrop()
                .into(avatarImageView)
            avatarImageView.isVisible = true
        } else {
            avatarImageView.isVisible = false
        }
    }

    fun setSmallIcon(drawable: Drawable?) {
        labelIconView.setImageDrawable(drawable)
        labelIconView.isVisible = drawable != null
        updateLabelCardVisibility()
    }

    fun setLabelText(text: String?) {
        labelTextView.text = text
        labelTextView.isVisible = !text.isNullOrEmpty()
        updateLabelCardVisibility()
    }

    fun setTitle(title: String?) {
        titleTextView.text = title
        titleTextView.isVisible = !title.isNullOrEmpty()
    }

    fun setDescription(description: String?) {
        descriptionTextView.text = description
        descriptionTextView.isVisible = !description.isNullOrEmpty()
    }

    private fun updateLabelCardVisibility() {
        labelCardView.isVisible = labelIconView.isVisible || labelTextView.isVisible
    }
}