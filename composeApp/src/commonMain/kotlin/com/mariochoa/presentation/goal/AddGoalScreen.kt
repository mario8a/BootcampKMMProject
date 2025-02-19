package com.mariochoa.presentation.goal

//import androidx.compose.material.icons.filled.Bedtime
//import androidx.compose.material.icons.filled.FitnessCenter
//import androidx.compose.material.icons.filled.ImportContacts
//import androidx.compose.material.icons.filled.LightMode
//import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.ImportContacts
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import bootcampkmmproject.composeapp.generated.resources.Res
import bootcampkmmproject.composeapp.generated.resources.description
import bootcampkmmproject.composeapp.generated.resources.frequency
import bootcampkmmproject.composeapp.generated.resources.new_goal
import bootcampkmmproject.composeapp.generated.resources.pick_icon
import bootcampkmmproject.composeapp.generated.resources.save_goal
import bootcampkmmproject.composeapp.generated.resources.title
import bootcampkmmproject.composeapp.generated.resources.week_days
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.mariochoa.domain.goal.Goal
import com.mariochoa.presentation.AppScreen
import com.mariochoa.presentation.composables.core.ChipGroup
import com.mariochoa.presentation.composables.core.ChipGroupMultiselect
import org.jetbrains.compose.resources.stringArrayResource
import org.jetbrains.compose.resources.stringResource

class AddGoalScreen(private val viewModel: GoalViewModel) : AppScreen() {
    override val topBarTitle: (@Composable () -> Unit)?
        get() = {
            Text(
                stringResource(Res.string.new_goal),
                style = MaterialTheme.typography.displaySmall
            )
        }

    override val contentComposable: @Composable () -> Unit
        get() = { AddGoal(viewModel) }
}

@Composable
fun AddGoal(viewModel: GoalViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {
        var title by rememberSaveable { mutableStateOf("") }
        var description by rememberSaveable { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxSize().padding(vertical = 60.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(stringResource(Res.string.title))
                },
                value = title,
                onValueChange = {
                    title = it
                },
                singleLine = true,
                maxLines = 1
            )


            TextField(
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(stringResource(Res.string.description))
                },
                value = description,
                onValueChange = {
                    description = it
                },
                maxLines = 2
            )

            ChipGroup(
                title = stringResource(Res.string.pick_icon),
                elements = GoalIcons.entries.map { it.icon },
                initialState = 0,
                onChipSelected = { _, element ->
                    println(element)
                }
            )

            val weekDays = stringArrayResource(Res.array.week_days).mapNotNull {
                it.firstOrNull()
            }

            ChipGroupMultiselect(
                title = stringResource(Res.string.frequency),
                elements = weekDays,
                initialState = setOf(0, 2, 4),
                onChipSelected = { items -> println(items) }
            )

        }

        val navigator = LocalNavigator.currentOrThrow

        Button(
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter)
                .padding(PaddingValues(0.dp, 0.dp, 0.dp, 16.dp)),
            onClick = {
                // Guardar en el viewModel
                // viewModel.onEvent(UIEvent.SaveGoal(goal = Goal(1, title, description)))
                viewModel.onEvent(UIEvent.SaveGoal(goal = Goal(1, title, description)))
                navigator.pop()
            },
        ) {
            Text(stringResource(Res.string.save_goal))
        }
    }


}

enum class GoalIcons(
    val icon: ImageVector
) {
    WATER(Icons.Default.LocalDrink),
    SUN(Icons.Default.LightMode),
    FITNESS(Icons.Default.FitnessCenter),
    SLEEP(Icons.Default.Bedtime),
    BOOK(Icons.Default.ImportContacts),
}