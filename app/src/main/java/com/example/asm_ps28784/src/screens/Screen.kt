package com.example.asm_ps28784.src.screens
import androidx.annotation.DrawableRes

import com.example.asm_ps28784.R

enum class Screen(val route: String, val iconSelected: Int, val iconUnselected: Int) {

    BOARDING("boarding", R.drawable.close_eye_24, R.drawable.close_eye_24),
    LOGIN("login", R.drawable.close_eye_24, R.drawable.close_eye_24),
    SIGNUP("signup", R.drawable.close_eye_24, R.drawable.close_eye_24),
    HOME("home", R.drawable.ic_home_filled, R.drawable.ic_home),
    Favorite("favorite", R.drawable.ic_save_filled, R.drawable.ic_save),
    Notification("notification", R.drawable.ic_notification_filled, R.drawable.ic_notification),
    Profile("profile", R.drawable.ic_profile_filled, R.drawable.ic_profile),
    PRODUCT("product", R.drawable.close_eye_24, R.drawable.close_eye_24),
    CONGRATS("congrats", R.drawable.close_eye_24, R.drawable.close_eye_24),
    CART("cart", R.drawable.close_eye_24, R.drawable.close_eye_24),
    CHECKOUT("checkout", R.drawable.close_eye_24, R.drawable.close_eye_24);
}
