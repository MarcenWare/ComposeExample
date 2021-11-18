package com.example.composedexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedexample.ui.theme.ComposedExample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposedExample(darkTheme = true) {
                ListMessages(list = list)
            }
        }
    }
}

data class Message(val author: String, val body: String)

val list: List<Message> = mutableListOf(
    Message("Peter", "Hallo!"),
    Message("Heinrich", "Wie gehts?"),
    Message("Thorsten", "Hey!"),
    Message("Judith", "Moin"),
)

@Preview(showBackground = true)
@Composable
fun Preview() {
    ComposedExample(darkTheme = false) {
        MessageCard(message = list[0])
    }
}


@Preview(showBackground = true)
@Composable
fun Preview2() {
    ComposedExample(darkTheme = true) {
        ListMessages(list = list)
    }
}

@Composable
fun MessageCard(message: Message) {
    Row {
        Image(
            painter = painterResource(R.drawable.hslogo),
            contentDescription = "null",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.primary, CircleShape)
        )

        Spacer(modifier = Modifier.width(5.dp))

        Column {
            Text(
                text = message.author,
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.subtitle2
            )

            Surface(
                shape = MaterialTheme.shapes.small,
                elevation = 1.dp,
                color = MaterialTheme.colors.secondary,
                modifier = Modifier
                    .padding(1.dp)
            ) {
                Text(
                    text = message.body,
                    color = Color(255, 255, 255),
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
fun ListMessages(list: List<Message>) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            list.forEach {
                MessageCard(message = it)
            }
        }
    }
}