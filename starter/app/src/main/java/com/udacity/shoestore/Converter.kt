package com.udacity.shoestore

import android.view.View
import android.widget.EditText
import androidx.databinding.InverseMethod


object Converter {
        @InverseMethod("stringToDouble")
        @JvmStatic fun doubleToString( value: Double?
        ): String {
            // Converts Double to String.
            return value.toString()
        }

        @JvmStatic fun stringToDouble(value: String ): Double? {
            // Converts String to Double.
            return value.toDoubleOrNull()
        }
}