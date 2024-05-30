package com.nvvi9.spotitube.utils

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.semantics.Role

fun Modifier.bouncingClickable(
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource,
    onClick: () -> Unit,
) = this
    .bouncing(interactionSource)
    .clickable(
        interactionSource = interactionSource,
        indication = null,
        enabled = enabled,
        onClick = onClick
    )


fun Modifier.bouncingSelectable(
    selected: Boolean,
    interactionSource: MutableInteractionSource,
    indication: Indication? = null,
    enabled: Boolean = true,
    role: Role? = null,
    onClick: () -> Unit
) = this
    .bouncing(interactionSource)
    .selectable(
        selected = selected,
        interactionSource = interactionSource,
        indication = indication,
        enabled = enabled,
        role = role,
        onClick = onClick
    )


private fun Modifier.bouncing(interactionSource: MutableInteractionSource) = composed {
    val isPressed by interactionSource.collectIsPressedAsState()
    val animationTransition = updateTransition(isPressed)
    val scaleFactor by animationTransition.animateFloat { pressed ->
        if (pressed) 0.98f else 1f
    }

    val opacity by animationTransition.animateFloat { pressed ->
        if (pressed) 0.7f else 1f
    }

    this.graphicsLayer {
        this.scaleX = scaleFactor
        this.scaleY = scaleFactor
        this.alpha = opacity
    }
}