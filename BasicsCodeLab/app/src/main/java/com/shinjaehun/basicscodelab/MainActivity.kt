package com.shinjaehun.basicscodelab

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import com.shinjaehun.basicscodelab.ui.theme.BasicsCodeLabTheme
import kotlin.math.exp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            BasicsCodeLabTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
                MyApp(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

//@Composable
//fun MyApp(modifier: Modifier = Modifier) {
//    Surface(
//        modifier = modifier,
//        color = MaterialTheme.colorScheme.background
//    ) {
//        Greeting("ShinJaehun")
//    }
//}

//@Composable
//fun MyApp(
//    modifier: Modifier = Modifier,
//    names: List<String> = listOf("World", "Compose")
//) {
//    Column(modifier) {
//        for (name in names) {
//            Greeting(name = name)
//        }
//    }
//}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
//    var shouldShowOnboarding by remember { mutableStateOf(true) }
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    Surface(modifier, color = MaterialTheme.colorScheme.background) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            Greetings()
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
////    val expended = remember { mutableStateOf(false) }
//    var expended by rememberSaveable { mutableStateOf(false) }
//
////    val extraPdding = if (expended.value) 48.dp else 0.dp
////    val extraPdding = if (expended) 48.dp else 0.dp
//    val extraPdding by animateDpAsState(
//        if (expended) 48.dp else 0.dp,
//        animationSpec = spring(
//            Spring.DampingRatioMediumBouncy,
//            stiffness = Spring.StiffnessLow
//        )
//    )
//    Surface(
//        color = MaterialTheme.colorScheme.primary,
//        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
////        Text(
////            text = "Hello $name!",
////            modifier = modifier.padding(24.dp)
////        )
//
////        Column(
////            modifier = modifier
////                .fillMaxWidth()
////                .padding(24.dp)
////        ) {
////            Text(text = "Hello ")
////            Text(text = name)
////        }
//
//        Row(modifier = Modifier.padding(24.dp)) {
//            Column(
//                modifier = Modifier
//                    .weight(1f)
////                    .padding(bottom = extraPdding)
//                    .padding(bottom = extraPdding.coerceAtLeast(0.dp))
//            ) {
//                Text(text = "Hello ")
////                Text(text = name, style = MaterialTheme.typography.headlineMedium)
//                Text(text = name, style = MaterialTheme.typography.headlineMedium.copy(
//                    fontWeight = FontWeight.ExtraBold
//                ))
//            }
//            ElevatedButton(
//                onClick = {
////                    expended.value = !expended.value
//                    expended = !expended
//                }
//            ) {
////                Text(if (expended.value) "Show less" else "Show more")
//                Text(if (expended) "Show less" else "Show more")
//            }
//        }
//    }
//}

@Composable
private fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ){
        CardContent(name)
    }
}

@Composable
fun CardContent(name: String) {
    var expended by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello ")
            Text(text = name, style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.ExtraBold
            ))
            if (expended) {
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                )
            }
        }
        IconButton(onClick = { expended = !expended }) {
            Icon(
                imageVector = if (expended) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expended) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }
            )
        }
    }
}

//@Composable
//private fun Greetings(
//    modifier: Modifier = Modifier,
//    names: List<String> = listOf("World", "Compose")
//) {
//    Column(modifier = modifier.padding(vertical = 4.dp)) {
//        for (name in names) {
//            Greeting(name = name)
//        }
//    }
//}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "$it" }
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier, onContinueClicked: () -> Unit) {
//    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the basic codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    BasicsCodeLabTheme {
//        Greeting("Android")
//        MyApp()
//        OnboardingScreen()
        Greetings()
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "GreetingDarkPreview"
)
@Composable
fun GreetingDarkPreview() {
    BasicsCodeLabTheme {
        Greetings()
    }
}
//@Preview(showBackground = true, widthDp = 320, heightDp = 320)
//@Composable
//fun OnboardingPreview() {
//    BasicsCodeLabTheme {
//        OnboardingScreen(onContinueClicked = {})
//    }
//}
//
//@Preview
//@Composable
//fun MyAppPreview() {
//    BasicsCodeLabTheme {
//        MyApp(Modifier.fillMaxSize())
//    }
//}
