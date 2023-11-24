package com.dexciuq.rickandmortyapp.presentation.screen.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dexciuq.rickandmortyapp.domain.model.Character
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    navHostController: NavHostController,
    viewModel: MainViewModel = koinViewModel()
) {
    val characters by viewModel.characters.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getAllCharacters()
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(characters) {
            CharacterListItem(it)
        }
    }
}

@Composable
fun CharacterListItem(character: Character) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = character.name,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}