package br.com.mouzinho.marvelapp.view.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mouzinho.domain.entity.favorite.FavoriteCharacter
import br.com.mouzinho.marvelapp.R
import br.com.mouzinho.marvelapp.databinding.ViewHolderFavoriteBinding
import com.bumptech.glide.Glide

class FavoriteViewHolder private constructor(
    private val binding: ViewHolderFavoriteBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(favoriteCharacter: FavoriteCharacter) {
        with(binding) {
            this.favorite = favoriteCharacter
            imageViewFavorite.setOnClickListener { }
            rootLayout.setOnClickListener { }
            favoriteCharacter.landscapeThumbnailUrl?.let { url ->
                Glide.with(root.context.applicationContext)
                    .load(url)
                    .placeholder(R.drawable.thumb_placeholder)
                    .into(binding.imageViewAvatar)
            }
        }
    }

    companion object {
        fun inflate(parent: ViewGroup) = FavoriteViewHolder(
            ViewHolderFavoriteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}