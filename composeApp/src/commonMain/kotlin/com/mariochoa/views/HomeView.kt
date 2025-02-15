package com.mariochoa.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

// Data class for a goal
data class Goal(
    val id: Int,
    val icon: @Composable () -> Unit,
    val title: String,
    val description: String,
    var isCompleted: Boolean
)

// Enum for days of the week (platform-agnostic)
enum class DayOfWeek(val displayName: String) {
    MONDAY("Mon"),
    TUESDAY("Tue"),
    WEDNESDAY("Wed"),
    THURSDAY("Thu"),
    FRIDAY("Fri"),
    SATURDAY("Sat"),
    SUNDAY("Sun")
}

@Composable
fun HomeView() {
    // Sample data for goals (replace with your actual data source)
    val goals = remember {
        mutableStateListOf(
            Goal(
                1,
                { Icon(Icons.Filled.Info, contentDescription = "Info") },
                "Morning Walk",
                "30 minutes walk in the park",
                false
            ),
            Goal(
                2,
                { Icon(Icons.Filled.Info, contentDescription = "Info") },
                "Read a Book",
                "Read for 1 hour",
                false
            ),
            Goal(
                3,
                { Icon(Icons.Filled.Info, contentDescription = "Info") },
                "Learn Compose",
                "Study Jetpack Compose",
                false
            )
        )
    }

    // **Important:** Determine "today" outside the composable if possible,
    // or use a saved value if platform-specific date retrieval isn't feasible.
    // For this example, we'll just pick a fixed day for demonstration.
    val today = DayOfWeek.MONDAY

    Column(modifier = Modifier.fillMaxSize()) {
        // Days of the week list
        DaysOfWeekList(today = today)

        // Goals list
        GoalsList(goals = goals)
    }
}

@Composable
fun DaysOfWeekList(today: DayOfWeek) {
    val daysOfWeek = remember { DayOfWeek.values().toList() }
    val listState = rememberLazyListState()

    LaunchedEffect(today) {
        // Scroll to today's day
        val todayIndex = daysOfWeek.indexOf(today)
        if (todayIndex != -1) {
            listState.animateScrollToItem(index = todayIndex)
        }
    }

    LazyRow(
        state = listState,
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(daysOfWeek) { dayOfWeek ->
            DayOfWeekItem(dayOfWeek = dayOfWeek, isToday = dayOfWeek == today)
        }
    }
}

@Composable
fun DayOfWeekItem(dayOfWeek: DayOfWeek, isToday: Boolean) {
    val backgroundColor = if (isToday) MaterialTheme.colorScheme.primary else Color.Transparent
    val textColor =
        if (isToday) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface

    Surface(
        color = backgroundColor,
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .width(48.dp), // Fixed width for consistent size
    ) {
        Text(
            text = dayOfWeek.displayName,
            color = textColor,
            fontWeight = if (isToday) FontWeight.Bold else FontWeight.Normal,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun GoalsList(goals: MutableList<Goal>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(goals, key = { it.id }) { goal ->
            GoalItem(goal = goal) { isChecked ->
                goal.isCompleted = isChecked
            }
        }
    }
}

@Composable
fun GoalItem(goal: Goal, onCheckedChange: (Boolean) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            goal.icon() // Display the icon
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = goal.title, style = MaterialTheme.typography.titleMedium)
                Text(text = goal.description, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = goal.isCompleted,
                onCheckedChange = { isChecked ->
                    onCheckedChange(isChecked)
                }
            )
        }
    }
}