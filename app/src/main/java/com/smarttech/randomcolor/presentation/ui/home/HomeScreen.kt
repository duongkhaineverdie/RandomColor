package com.smarttech.randomcolor.presentation.ui.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarttech.randomcolor.R
import com.smarttech.randomcolor.presentation.ui.theme.RandomColorTheme
import com.smarttech.randomcolor.utils.Constants
import com.smarttech.randomcolor.utils.bounceClick
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen() {
    val homeViewModel: HomeViewModel = koinViewModel()
    val uiState by homeViewModel.uiState.collectAsState()
    val context = LocalContext.current
    HomeScreen(
        modifier = Modifier.fillMaxSize(),
        onClickRandomColor = homeViewModel::onClickRandomColor,
        onClickCopyColor = {
            Constants.copyClipboard(it, context)
            Toast.makeText(context, context.getText(R.string.copied), Toast.LENGTH_SHORT).show()
        },
        colorHex = uiState.colorHex,
        colorBackground = uiState.colorInt,
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onClickRandomColor: () -> Unit,
    onClickCopyColor: (String) -> Unit,
    colorBackground: Int = 0x000000,
    colorHex: String = "#000000",
) {
    Box(modifier = modifier.background(Color(colorBackground))) {
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .statusBarsPadding()
                .padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = colorHex, fontSize = 28.sp)

            IconButton(onClick = { onClickCopyColor(colorHex) }) {
                Icon(painter = painterResource(id = R.drawable.ic_copy), contentDescription = null)
            }
        }
        ElevatedButton(onClick = onClickRandomColor, modifier = Modifier.align(Alignment.Center).bounceClick()) {
            Text(text = stringResource(id = R.string.random_color), fontSize = 28.sp)
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun HomeScreenPreview() {
    RandomColorTheme {
        HomeScreen(
            modifier = Modifier.fillMaxSize(),
            onClickRandomColor = { /* no-op */ },
            onClickCopyColor = { /* no-op */ },
            colorHex = "#000000",
            colorBackground = 0x000000
        )
    }
}