package com.mariochoa.presentation.goal

import com.mariochoa.domain.goal.Goal
import com.mariochoa.presentation.AbstractViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GoalViewModel: AbstractViewModel() {

    private val _uiState = MutableStateFlow(UIState())
    val uiState: StateFlow<UIState> = _uiState.asStateFlow()

    fun onEvent(intent: UIEvent) {
        when (intent) {
            is UIEvent.OnGoalComplete -> {}
            is UIEvent.SaveGoal -> {
                _uiState.update { currentState ->
                    currentState.copy(
                        goals = currentState.goals + intent.goal
                    )
                }
            }
        }
    }

    fun onState() {

    }

}

data class UIState(
    val goals: List<Goal> = emptyList(),
    val userName: String = ""
)

sealed class UIEvent {
    data class OnGoalComplete(val goal: Goal): UIEvent()
    data class SaveGoal(val goal: Goal): UIEvent()
}