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
package com.example.androiddevchallenge.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.Elevations

sealed class NavItem(val title: String, val icon: ImageVector) {
    object Home : NavItem("Home", Icons.Filled.Spa)
    object Profile : NavItem("Profile", Icons.Filled.AccountCircle)
}

val navItems = listOf(
    NavItem.Home,
    NavItem.Profile,
)

sealed class YogaItem(val title: String, @DrawableRes val image: Int) {
    object Item0 : YogaItem("Short mantras", R.drawable.short_mantra)
    object Item1 : YogaItem("Stress and anxiety", R.drawable.stress_and_anxiety)
    object Item2 : YogaItem("Overwhelmed", R.drawable.overwhelmed)
    object Item3 : YogaItem("Nature meditations", R.drawable.nature_meditations)
    object Item4 : YogaItem("Self-massage", R.drawable.self_massage)
    object Item5 : YogaItem("Nightly wind down", R.drawable.nightly_wind_down)

    object Item6 : YogaItem("Inversions", R.drawable.inversions)
    object Item7 : YogaItem("Quick Yoga", R.drawable.quick_yoga)
    object Item8 : YogaItem("Stretching", R.drawable.stretching)
    object Item9 : YogaItem("Tabata", R.drawable.tabata)
    object Item10 : YogaItem("HIIT", R.drawable.hiit)
    object Item11 : YogaItem("Pre-natal Yoga", R.drawable.pre_natal_yoga)

    object Item12 : YogaItem("Meditate", R.drawable.meditate)
    object Item13 : YogaItem("With kids", R.drawable.with_kids)
    object Item14 : YogaItem("Aromatherapy", R.drawable.aeromatherapy)
    object Item15 : YogaItem("On the go", R.drawable.on_the_go)
    object Item16 : YogaItem("With pets", R.drawable.with_pets)
    object Item17 : YogaItem("High stress", R.drawable.high_stress)
}

val favoriteCollections = listOf(
    YogaItem.Item0,
    YogaItem.Item1,
    YogaItem.Item2,
    YogaItem.Item3,
    YogaItem.Item4,
    YogaItem.Item5,
)

val alignYourBody = listOf(
    YogaItem.Item6,
    YogaItem.Item7,
    YogaItem.Item8,
    YogaItem.Item9,
    YogaItem.Item10,
    YogaItem.Item11,
)

val alignYourMind = listOf(
    YogaItem.Item12,
    YogaItem.Item13,
    YogaItem.Item14,
    YogaItem.Item15,
    YogaItem.Item16,
    YogaItem.Item17,
)

@Composable
fun Home() {
    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = Modifier) {
            Scaffold(
                bottomBar = {
                    BottomNavigation(
                        elevation = Elevations.bottomNavigationElevation,
                        modifier = Modifier.height(56.dp),
                        backgroundColor = MaterialTheme.colors.background
                    ) {
                        navItems.forEach { item ->
                            BottomNavigationItem(
                                icon = {
                                    Icon(
                                        item.icon,
                                        contentDescription = null,
                                        modifier = Modifier.size(18.dp),
                                        tint = MaterialTheme.colors.onBackground

                                    )
                                },
                                label = {
                                    Text(
                                        item.title,
                                        style = MaterialTheme.typography.caption,
                                        color = MaterialTheme.colors.onBackground,
                                    )
                                },
                                selected = item == NavItem.Home,
                                onClick = {}
                            )
                        }
                    }
                }

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                ) {
                    TextField(
                        "",
                        onValueChange = {},
                        leadingIcon = {
                            Icon(
                                Icons.Filled.Search,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp),
                            )
                        },
                        placeholder = {
                            Text(
                                "Search",
                                style = MaterialTheme.typography.body1,
                                color = MaterialTheme.colors.onSurface,
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = MaterialTheme.colors.onPrimary,
                            cursorColor = MaterialTheme.colors.onSurface
                        )

                    )

                    Text(
                        "FAVORITE COLLECTIONS",
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .paddingFromBaseline(top = 40.dp)
                            .padding(start = 16.dp),
                    )

                    LazyRow(modifier = Modifier) {
                        item {
                            Spacer(modifier = Modifier.size(16.dp))
                        }
                        items(favoriteCollections.size) {
                            if (it < 3)
                                Column {
                                    Spacer(modifier = Modifier.size(8.dp))
                                    val item1 = favoriteCollections[it]
                                    FavoriteItem(item1.title, item1.image)
                                    Spacer(modifier = Modifier.size(8.dp))
                                    val item2 = favoriteCollections[it + 1]
                                    FavoriteItem(item2.title, item2.image)
                                    Spacer(modifier = Modifier.size(8.dp))
                                }
                            Spacer(modifier = Modifier.size(8.dp))
                        }
                        item {
                            Spacer(modifier = Modifier.size(16.dp))
                        }
                    }

                    Text(
                        "ALIGN YOUR BODY",
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .paddingFromBaseline(top = 40.dp)
                            .padding(start = 16.dp),
                    )
                    Spacer(modifier = Modifier.size(8.dp))

                    LazyRow(modifier = Modifier) {
                        item {
                            Spacer(modifier = Modifier.size(16.dp))
                        }
                        items(alignYourBody) { item ->
                            YogaElement(item.title, item.image)
                            Spacer(modifier = Modifier.size(8.dp))
                        }
                        item {
                            Spacer(modifier = Modifier.size(16.dp))
                        }
                    }

                    Text(
                        "ALIGN YOUR MIND",
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .paddingFromBaseline(top = 40.dp)
                            .padding(start = 16.dp),
                    )
                    Spacer(modifier = Modifier.size(8.dp))

                    LazyRow(modifier = Modifier) {
                        item {
                            Spacer(modifier = Modifier.size(16.dp))
                        }
                        items(alignYourMind) { item ->
                            YogaElement(item.title, item.image)
                            Spacer(modifier = Modifier.size(8.dp))
                        }
                        item {
                            Spacer(modifier = Modifier.size(16.dp))
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 28.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Surface(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape),
                    color = MaterialTheme.colors.primary,
                ) {
                    Image(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Filled.PlayArrow,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
                    )
                }
            }
        }
    }
}
