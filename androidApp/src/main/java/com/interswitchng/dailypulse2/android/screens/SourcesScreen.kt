package com.interswitchng.dailypulse2.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.interswitchng.dailypulse2.articles.domain.Source
import com.interswitchng.dailypulse2.articles.presentation.SourcesViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SourcesScreen(
    onUpButtonClick: () -> Unit,
    sourcesViewModel: SourcesViewModel = getViewModel(),
) {
    val sourcesState = sourcesViewModel.sourcesState.collectAsState()

    Column {
        ToolBar(
            onUpButonClick = onUpButtonClick
        )

        when{
            sourcesState.value.error != null -> ErrorMessage(message = sourcesState.value.error!!)
            sourcesState.value.sources.isNotEmpty() ->  ResourcesListView(sourcesViewModel)
        }
    }

}

@Composable
fun ResourcesListView(viewModel: SourcesViewModel) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(viewModel.sourcesState.value.sources) { source ->
            SourceItemView(source)
        }
    }
}

@Composable
fun SourceItemView(source: Source) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = source.name,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = source.desc)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = source.origin,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}