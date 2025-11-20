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
){

    Scaffold { isiRuang->
        val uiState = viewModel.statusUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulirku.name,

            modifier = Modifier.padding(isiRuang)){
            composable(route = Navigasi.Formulirku.name){
                val konteks = LocalContext.current
                FormSiswa (
                    pilihanJK = DataJK.jenisK.map { id -> konteks.resources.getString(id)},
                    onSubmitButtonClicked = {
                        viewModel.saveDataSiswa(it)
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name){
                TampilData (
                    statusUiSiswa = uiState.value,
                    onBackButtonClicked = {
                        cancelAndBackToFormulirku(navController)
                    }
                )
            }


        }
    }
}
private fun cancelAndBackToFormulirku(
    navController: NavHostController
) {
    navController.popBackStack(Navigasi.Formulirku.name,
        inclusive = false)
}
