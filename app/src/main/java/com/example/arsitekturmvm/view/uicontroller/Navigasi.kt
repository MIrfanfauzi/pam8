package com.example.arsitekturmvm.view.uicontroller

import com.example.arsitekturmvm.view.FormSiswa
import com.example.arsitekturmvm.view.TampilData
import com.example.arsitekturmvm.viewmodel.SiswaViewModel
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.arsitekturmvm.model.DataJK

enum class Navigasi {
    Formulirku,
    Detail
}
@Composable
fun SiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier,
    viewModel: SiswaViewModel = viewModel ()
){}