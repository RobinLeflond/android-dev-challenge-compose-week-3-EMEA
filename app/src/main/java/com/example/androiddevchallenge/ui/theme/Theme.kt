/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Colors.white,
    primaryVariant = Colors.rust300,
    secondary = Colors.rust300,
    background = Colors.gray900,
    surface = Colors.white150,
    onPrimary = Colors.gray900,
    onSecondary = Colors.gray900,
    onBackground = Colors.taupe100,
    onSurface = Colors.white800,
)

private val LightColorPalette = lightColors(
    primary = Colors.gray900,
    primaryVariant = Colors.rust600,
    secondary = Colors.rust600,
    background = Colors.taupe100,
    surface = Colors.white850,
    onPrimary = Colors.white,
    onSecondary = Colors.white,
    onBackground = Colors.taupe800,
    onSurface = Colors.gray800,
)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
